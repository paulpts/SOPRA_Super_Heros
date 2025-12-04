import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common'; 
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

// DTOs
import { MissionDto } from '../../dto/mission-dto';
import { AgenceDto } from '../../dto/agence-dto';
import { HerosDto } from '../../dto/heros-dto';
import { ChefAgenceDto } from '../../dto/chefAgence-dto';

// Services
import { MissionService } from '../../service/mission-service';
import { AgenceService } from '../../service/agence-service';
import { HerosService } from '../../service/heros-service'; 
import { ChefAgenceService } from '../../service/chefAgence-service';

@Component({
  selector: 'app-agency-dashboard',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './TDB.html',
  styleUrls: ['./TDB-page.css']
})
export class TDB implements OnInit {

  // --- VARIABLES DYNAMIQUES ---
  public missions: MissionDto[] = [];
  public herosDisponibles: HerosDto[] = [];
  public mesHeros: HerosDto[] = [];
  
  public monAgence: AgenceDto = {} as AgenceDto; 
  
  public chefConnecte: ChefAgenceDto | null = null;
  // Pas forcément besoin de doubler avec agenceConnecte si monAgence fait le travail, 
  // mais je le laisse si tu t'en sers ailleurs.
  public agenceConnecte: AgenceDto | null = null;

  constructor(
    private missionService: MissionService, 
    private agenceService: AgenceService,
    private herosService: HerosService,
    private chefAgenceService: ChefAgenceService, 
    private router: Router
  ) {}

  ngOnInit(): void { 
    this.chargerDonnees();
  }

  chargerDonnees() {
    let chefIdStr = localStorage.getItem('userId'); 

    if (!chefIdStr) {
      console.warn("⚠️ Pas d'userId dans le stockage. Tentative d'extraction depuis le token...");
      const idRecupere = this.extraireIdDuToken();
      
      if (idRecupere) {
        console.log("✅ ID récupéré avec succès depuis le token :", idRecupere);
        chefIdStr = idRecupere.toString();
        localStorage.setItem('userId', chefIdStr);
      }
    }

    if (!chefIdStr) {
      console.error("❌ Echec critique : Aucun ID utilisateur trouvé. Redirection...");
      this.router.navigate(['/login']);
      return;
    }

    const chefId = Number(chefIdStr); 
    console.log("Chargement des données pour le Chef ID :", chefId);

    // 1. Récupérer les infos du Chef
    this.chefAgenceService.findById(chefId).subscribe({
      next: (chef) => {
        this.chefConnecte = chef;
        console.log("Infos du chef chargées :", this.chefConnecte);

        // --- CORRECTION ETAPE 2 : On utilise l'ID contenu dans l'objet Chef ---
        // Vérifie bien si ton DTO utilise 'agenceId' ou 'agenceID' (je mets agenceId par convention)
        if (this.chefConnecte && this.chefConnecte.agenceId) {
            
            console.log("🔍 Recherche de l'agence ID :", this.chefConnecte.agenceId);

            this.agenceService.findById(this.chefConnecte.agenceId).subscribe({
                next: (agence) => {
                    this.monAgence = agence;
                    this.agenceConnecte = agence; // Synchro des deux variables
                    console.log("Agence chargée via ID :", this.monAgence);
                    
                    // Une fois l'agence chargée, on lance le reste
                    this.chargerListesHeros();
                    this.chargerMissions();
                },
                error: (err: any) => console.error("Erreur chargement agence via ID", err)
            });

        } else {
            console.warn("⚠️ Ce chef n'a pas d'agenceId associé !");
        }
      },
      error: (err: any) => console.error("Impossible de charger le chef", err)
    });
  }


  // Méthode pour extraire l'ID du token JWT stocké dans le localStorage (Merci Gemini!)
  private extraireIdDuToken(): number | null {
    const token = localStorage.getItem('token') || localStorage.getItem('access_token');
    if (!token) return null;

    try {
      const payloadBase64 = token.split('.')[1];
      const payloadJson = atob(payloadBase64);
      const payload = JSON.parse(payloadJson);
      return payload.id ? Number(payload.id) : null;
    } catch (e) {
      console.error("Erreur décodage token", e);
      return null;
    }
  }

  chargerListesHeros() {
    this.herosService.findAll().subscribe({
      next: (tousLesHeros) => {
        this.mesHeros = tousLesHeros.filter(h => h.agenceId === this.monAgence.id);
        this.herosDisponibles = tousLesHeros.filter(h => !h.agenceId);
      },
      error: (err: any) => console.error("Erreur chargement héros", err)
    });
  }

  chargerMissions() {
    this.missionService.findAll().subscribe({
      next: (missions) => this.missions = missions,
      error: (err: any) => console.error("Erreur chargement missions", err)
    });
  }

  recruterHero(hero: HerosDto) {
    if (hero.agenceId) {
      alert(`Impossible ! ${hero.nom} travaille déjà pour quelqu'un.`);
      return;
    }

    // J'utilise 'budget' comme dans ton code (vérifie que c'est bien 'budget' et pas 'argent' dans ton DTO)
    if (this.monAgence.budget < hero.coutCreation) {
      alert(`Pas assez de budget ! Il te manque ${hero.coutCreation - this.monAgence.budget} crédits.`);
      return; 
    }

    const ancienAgenceId = hero.agenceId; 
    hero.agenceId = this.monAgence.id;

    this.herosService.update(hero).subscribe({
      next: (heroSauvegarde: HerosDto) => {
        console.log(`Succès ! ${heroSauvegarde.nom} recruté.`);

        this.monAgence.budget -= hero.coutCreation;
        
        this.agenceService.update(this.monAgence).subscribe({
          next: () => console.log("Budget mis à jour en BDD"),
          error: (err: any) => console.error("Erreur mise à jour budget", err)
        });

        this.herosDisponibles = this.herosDisponibles.filter(h => h.id !== hero.id);
        this.mesHeros.push(heroSauvegarde);
      },
      error: (err: any) => {
        console.error("Erreur recrutement", err);
        hero.agenceId = ancienAgenceId;
      }
    });
  }
}