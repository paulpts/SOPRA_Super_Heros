import { Component } from '@angular/core';
import { Router } from '@angular/router'; // Pour naviguer vers une autre page


@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [], // Pas besoin de module spécifique pour l'instant
  templateUrl: './connexion-page.html',
  styleUrl: './connexion-page.css'
})
export class ConnexionPage {

  // On injecte le Router pour pouvoir changer de page
  constructor(private router: Router) {}

  // Cette fonction est appelée quand on clique sur le bouton
  seConnecter() {
    console.log('Bouton cliqué ! Simulation de connexion...');
    
    // TEMPORAIRE : On redirige vers l'accueil Admin pour tester la navigation
    // Tu pourras changer ça plus tard quand tu auras la sécurité
    this.router.navigate(['/admin/home']);
  }

}