import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MissionService } from '../../service/mission-service';
import { MissionDto } from '../../dto/mission-dto';

@Component({
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './mission-page.html',
  styleUrl: './mission-page.css',
})
export class MissionPage implements OnInit {

  // Toutes les missions reçues du back
 public missions: MissionDto[] = [];

  //les 3 checkbox apparaissent décochées quand la page se charge.
  showDisponibles = false;
  showEnCours = false;
  showTerminees = false;

  constructor(private missionService: MissionService) {}

  ngOnInit(): void { 
    this.missionService.findAll().subscribe((missions) => { 
      this.missions = missions;
    });
  }

  // Liste des missions filtrées 
       
  public filtrerMissions(): MissionDto[] {

  
  if (!this.showDisponibles && !this.showEnCours && !this.showTerminees) {// si aucune checkbox cochées alors pas de filtrage ==> on renvoit toutes les missions 
     
    return this.missions;
  }

   return this.missions.filter((mission) => {

    //  le statut en modifié en minuscule 
    const statut = (mission.statut || '').toLowerCase();

    // si on veut voir les "disponible" et que le statut de la mission est "disponible"
    if (this.showDisponibles && statut === 'disponible') {
      return true;
    }

    
    if (this.showEnCours && statut === 'en-cours') {
      return true;
    }

    
    if (this.showTerminees && statut === 'terminee') {
      return true;
    }

    
    return false;
  });
}

}
