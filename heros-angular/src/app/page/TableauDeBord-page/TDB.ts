import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; // Utile pour les futures boucles *ngFor

@Component({
  selector: 'app-agency-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './TDB.html',
  styleUrls: ['./TDB-page.css']
})
export class TDB {

  // Variable affichée dans la bannière Welcome
  nomChefAgence: string = 'Nick Fury'; 

  constructor() {}

  // Tu pourras ajouter ici des méthodes plus tard, par exemple :
  // recruterHero() { ... }

}