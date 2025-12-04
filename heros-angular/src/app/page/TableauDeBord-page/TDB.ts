import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common'; // Utile pour les futures boucles *ngFor
import { MissionDto } from '../../dto/mission-dto';
import { FormsModule } from '@angular/forms';
import { AgenceDto } from '../../dto/agence-dto';
import { MissionService } from '../../service/mission-service';
import { AgenceService } from '../../service/agence-service';
import { HerosDto } from '../../dto/heros-dto';

interface HeroTest {
  id: number;
  nom: string;
  coutCreation: number; // J'ai repris le nom de ton erreur
  agenceId: number | undefined | null;
}

@Component({
  selector: 'app-agency-dashboard',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './TDB.html',
  styleUrls: ['./TDB-page.css']
})
export class TDB {

  public missions: MissionDto[] = [];
  public agences: AgenceDto[] = [];
  // public agence : AgenceDto = new AgenceDto();

  //constructor(private missionService: MissionService, private agenceService: AgenceService) {}
 // //ngOnInit(): void { 
  //   this.missionService.findAll().subscribe((missions) => { 
  //     this.missions = missions;
  //   });
  //   this.agenceService.findAll().subscribe((agences) => { 
  //     this.agences = agences;
  //   })
  // }

  // --- 1. LES DONNÉES DE L'AGENCE (Simulation) ---
  monAgenceId: number = 10;      // ID fictif de ton agence connectée
  budgetAgence: number = 5000;   // On commence avec 5000 crédits

  // --- 2. LA LISTE DES HÉROS DISPONIBLES (Simulation Back) ---
  herosDisponibles: HeroTest[] = [
    { id: 1, nom: 'Spiderman', coutCreation: 1000, agenceId: null },
    { id: 2, nom: 'Thor', coutCreation: 3000, agenceId: null },
    { id: 3, nom: 'Hulk', coutCreation: 4500, agenceId: null }, // Trop cher si on recrute Thor avant !
    { id: 4, nom: 'Ant-Man', coutCreation: 500, agenceId: 1 }
  ];

  // Liste de MES héros (vide au début)
  mesHeros: HeroTest[] = [];

  constructor() {}

  ngOnInit(): void {
    console.log("Budget initial :", this.budgetAgence);
  }

  // --- 3. LA FONCTION DE RECRUTEMENT (Le Script) ---
  recruterHero(hero: HeroTest) {
    
    // ÉTAPE A : Vérifier si le héros est déjà pris
    if (hero.agenceId !== null) {
      alert(`Impossible ! ${hero.nom} travaille déjà pour quelqu'un.`);
      return;
    }

    // ÉTAPE B : Vérifier le budget (Business Logic)
    if (this.budgetAgence < hero.coutCreation) {
      alert(`Pas assez d'argent ! Il te manque ${hero.coutCreation - this.budgetAgence} crédits pour recruter ${hero.nom}.`);
      return; // On arrête tout, pas de recrutement.
    }

    // ÉTAPE C : La Transaction (Si tout est OK)
    
    // 1. On retire les sous
    this.budgetAgence = this.budgetAgence - hero.coutCreation;

    // 2. On change l'attribut agence du héros (Signature du contrat)
    hero.agenceId = this.monAgenceId;

    // 3. Mise à jour visuelle (Optionnel mais sympa)
    // On le retire de la liste "Disponibles"
    this.herosDisponibles = this.herosDisponibles.filter(h => h.id !== hero.id);
    // On l'ajoute à "Mes Héros"
    this.mesHeros.push(hero);

    // Feedback
    console.log(`Succès ! ${hero.nom} a rejoint l'agence.`);
    console.log("Nouveau budget :", this.budgetAgence);
  }
 

 
 
}