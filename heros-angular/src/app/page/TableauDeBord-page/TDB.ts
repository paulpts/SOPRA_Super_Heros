import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common'; // Utile pour les futures boucles *ngFor
import { MissionDto } from '../../dto/mission-dto';
import { FormsModule } from '@angular/forms';
import { AgenceDto } from '../../dto/agence-dto';
import { MissionService } from '../../service/mission-service';
import { AgenceService } from '../../service/agence-service';

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

  constructor(private missionService: MissionService, private agenceService: AgenceService) {}

  ngOnInit(): void { 
    this.missionService.findAll().subscribe((missions) => { 
      this.missions = missions;
    });
    this.agenceService.findAll().subscribe((agences) => { 
      this.agences = agences;
    })
  }

 
}