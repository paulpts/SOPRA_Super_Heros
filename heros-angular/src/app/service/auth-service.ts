    import { Injectable } from '@angular/core';
    import { HttpClient } from '@angular/common/http';
    // Vérifie que ces fichiers existent bien chez toi
    import { AuthRequestDto } from '../dto/auth-request-dto';
    import { AuthResponseDto } from '../dto/auth-response-dto';

    // 1. IMPORT MAGIQUE : Permet de lire ce qu'il y a caché dans le token (l'ID, le rôle...)
    import { jwtDecode } from 'jwt-decode';

    // 2. INTERFACE LOCALE : C'est le "moule" pour lire le contenu du token.
    // ⚠️ TRES IMPORTANT : Le nom des champs (sub, iat, id) doit correspondre 
    // à ce que ton BACKEND a mis dans le token. Vérifie sur jwt.io !
    interface MonTokenDecode {
      sub: string;    // Le sujet (souvent le login)
      id: number;     // <--- L'ID du chef d'agence que tu veux récupérer
    }

    @Injectable({
      providedIn: 'root', // Ce service est disponible partout dans l'application
    })
    export class AuthService {
      
      // Ces variables gardent les infos en mémoire vive tant que l'appli tourne
      private _token: string = "";
      private _id: number = 0;

      // L'adresse de ton Backend Spring Boot.
      // On tape sur le port 8080 car c'est là que vit la sécurité.
      private apiUrl = 'http://localhost:8080/api/auth'; 

      constructor(private http: HttpClient) {
        // --- AU DÉMARRAGE DE L'APPLI (F5) ---
        // Le constructeur se lance une seule fois quand on ouvre le site.
        
        // 1. On regarde dans la poche du navigateur (LocalStorage) si on a déjà un ticket.
        this._token = localStorage.getItem("token") ?? "";
        
        // 2. Si on a trouvé un ticket, on le décrypte tout de suite pour retrouver l'ID.
        // Cela permet de rester connecté même si on rafraîchit la page.
        if (this._token) {
          this.decoderToken();
        }
      }

      // --- GETTERS ---
      // Permet aux autres pages de lire le token et l'id sans pouvoir les modifier directement
      public get token(): string { return this._token; }
      public get id(): number { return this._id; }


      // --- LA MÉTHODE PRINCIPALE DE CONNEXION ---
      // Elle prend le login/mdp (dto) et retourne une Promesse (succès ou échec)
      public auth(authRequest: AuthRequestDto): Promise<void> {
        return new Promise((resolve, reject) => {
          
          // ETAPE 1 : On envoie la lettre au Back (POST)
          // .toJson() convertit ton objet TypeScript en JSON pur pour Java
          this.http.post<AuthResponseDto>(this.apiUrl, authRequest.toJson()).subscribe({
            
            // ETAPE 2 : Le Back a répondu "Succès" (Code 200)
            next: (resp) => {
              console.log("✅ Connexion réussie ! Token reçu :", resp.token);

              // 1. On met à jour la mémoire vive
              this._token = resp.token; 
              
              // 2. On sauvegarde dans le navigateur (pour ne pas perdre la connexion au refresh)
              // localStorage.setItem("token", this._token);
              sessionStorage.setItem("token", this._token);
              // 3. On extrait l'ID caché dans le token
              try {
                this.decoderToken();
                // Tout est bon, on valide la promesse. La page de connexion peut rediriger.
                resolve(); 
              } catch (e) {
                // Si le token est bizarre, on rejette
                reject("Token reçu mais illisible");
              }
            },

            // ETAPE 3 : Le Back a répondu "Erreur" (401, 403, 500...)
            error: (err) => {
              console.error("❌ Echec connexion :", err);
              // On prévient la page de connexion qu'il y a un souci
              reject(err); 
            }
          });
        })
      }

      // --- MÉTHODE PRIVÉE (Outil interne) ---
      // Sert uniquement à lire le token JWT et remplir la variable _id
      private decoderToken() {
        try {
          // La librairie jwt-decode fait le travail difficile
          const decoded = jwtDecode<MonTokenDecode>(this._token);
          
          console.log("🔍 Contenu du token :", decoded);

          // On stocke l'ID. 
          // ⚠️ Si 'decoded.id' est undefined, c'est que ton interface MonTokenDecode 
          // ne correspond pas au vrai token du Back.
          this._id = decoded.id; 
          
        } catch (error) {
          console.error("Erreur lecture token", error);
          this._id = 0;
        }
      }

      // --- UTILITAIRE : Est-ce qu'on est connecté ? ---
      public isLogged(): boolean {
        // Renvoie VRAI si le token n'est pas vide
        return !!this._token;
      }
      
      // --- DECONNEXION ---
      public logout() {
        // On vide tout : mémoire vive et navigateur
        this._token = "";
        this._id = 0;
        localStorage.removeItem("token");
      }
    }