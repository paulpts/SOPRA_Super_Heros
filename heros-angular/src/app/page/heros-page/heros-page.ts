import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HerosDto } from '../../dto/heros-dto';
import { MissionDto } from '../../dto/mission-dto';
import { HerosService } from '../../service/heros-service';
import { MissionService } from '../../service/mission-service';

@Component({
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './heros-page.html',
  styleUrl: './heros-page.css',
})
export class HerosPage implements OnInit {

  // Listes des héros selon leur type
  alphaHeros: HerosDto[] = [];
  betaHeros: HerosDto[] = [];
  omegaHeros: HerosDto[] = [];
  heros: HerosDto[] = [];

  // Toutes les missions
  missions: MissionDto[] = [];

  // Checkbox pour les filtres
  showAlpha = false;
  showBeta = false;
  showOmega = false;

 //propriété pour stocker le héros sélectionné
  selectedHero: HerosDto | null = null;

  constructor(
    private herosService: HerosService,
    private missionService: MissionService
  ) {}

  ngOnInit(): void {

    // Charger les héros alpha
    this.herosService.findAllAlpha().subscribe((donneesAlpha) => {
      this.alphaHeros = donneesAlpha;
    });

    // Charger les héros beta
    this.herosService.findAllBeta().subscribe((donneesBeta) => {
      this.betaHeros = donneesBeta;
    });

    // Charger les héros omega
    this.herosService.findAllOmega().subscribe((donneesOmega) => {
      this.omegaHeros = donneesOmega;
    });

    // Charger toutes les missions
    this.missionService.findAll().subscribe((donneesMissions) => {
      this.missions = donneesMissions;
    });
  }

  // Cette fonction renvoie la liste des héros à afficher
  getHeros(): HerosDto[] {

    //const liste: HerosDto[] = [];

    const aucunFiltre = !this.showAlpha && !this.showBeta && !this.showOmega;

    // Si aucun filtre n'est coché : on affiche tous les héros
    if (aucunFiltre) {

      // Ajouter les alpha
      for (let i = 0; i < this.alphaHeros.length; i++) {
        this.heros.push(this.alphaHeros[i]);
      }

     
      for (let i = 0; i < this.betaHeros.length; i++) {
        this.heros.push(this.betaHeros[i]);
      }

   
      for (let i = 0; i < this.omegaHeros.length; i++) {
        this.heros.push(this.omegaHeros[i]);
      }

      return this.heros;
    }

    // Si le filtre Alpha est coché
    if (this.showAlpha) {
      for (let i = 0; i < this.alphaHeros.length; i++) {
        this.heros.push(this.alphaHeros[i]);
      }
    }

   
    if (this.showBeta) {
      for (let i = 0; i < this.betaHeros.length; i++) {
        this.heros.push(this.betaHeros[i]);
      }
    }

    // Si le filtre Omega est coché
    if (this.showOmega) {
      for (let i = 0; i < this.omegaHeros.length; i++) {
        this.heros.push(this.omegaHeros[i]);
      }
    }

    return this.heros;
  }
  filtrerMissionHero(hero: HerosDto): MissionDto[] {

  // On récupère l'id du héros et on le convertit en nombre
  const idHero = Number(hero.id);

  // Liste dans laquelle on va mettre les missions trouvées
  const liste: MissionDto[] = [];


  for (let i = 0; i < this.missions.length; i++) {
    const mission = this.missions[i];

    // Si la mission appartient à ce héros
    if (mission.herosId === idHero) {
      liste.push(mission); // On l'ajoute
    }
  }

  // On renvoie les missions filtrées
  return liste;

}
// Met a jour le héross sélectionné
selectHero(hero: HerosDto): void {
  this.selectedHero = hero;
}


recruter(): void {
  // Pour l'instant on fait juste un log
  console.log('TODO : ouvrir la page ou le formulaire de recrutement');
}
}


