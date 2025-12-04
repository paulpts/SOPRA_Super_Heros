import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MissionService } from '../../service/mission-service';
import { MissionDto } from '../../dto/mission-dto';
import { HerosService } from '../../service/heros-service';
@Component({
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './mission-page.html',
  styleUrl: './mission-page.css',
})
export class MissionPage implements OnInit {

  // Toutes les missions reçues du back
 public missions: MissionDto[] = [];
 public selectedMission?: MissionDto;   // peut être vide au début
public selectedHeroAlias: string = ''; // chaîne vide au début

  //les 3 checkbox apparaissent décochées quand la page se charge.
  protected showDisponibles : boolean = false;
  protected showEnCours : boolean = false;
  protected showTerminees : boolean  = false;

  constructor(private missionService: MissionService,private herosService: HerosService ) {}

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

    
    if (this.showEnCours && statut === 'en cours') {
      return true;
    }

    
    if (this.showTerminees && statut === 'terminee') {
      return true;
    }

    
    return false;
  });
} 
  public selectMission(mission: MissionDto): void {
    this.selectedMission = mission; 
    // Récupérer l'alias du héros assigné à la mission
    if (mission.herosId) {
      this.herosService.findById(mission.herosId).subscribe((heros) => {
        this.selectedHeroAlias = heros.alias;
      });
    } else {
      this.selectedHeroAlias = '';
    }
  }
  public clearSelection(): void {
    this.selectedMission = undefined;
    this.selectedHeroAlias = '';
  }   
}