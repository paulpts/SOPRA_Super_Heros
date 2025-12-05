import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HerosService } from '../../service/heros-service';
import { HerosDto } from '../../dto/heros-dto';
import { ChefAgenceService } from '../../service/chefAgence-service';

@Component({
  standalone: true,
  imports: [CommonModule, FormsModule],
  selector: 'app-heros-page',
  templateUrl: './heros-page.html',
  styleUrls: ['./heros-page.css']
})
export class HerosPage implements OnInit {

  //listes de héros récupérées selon leur type 
  alphaHeros: HerosDto[] = [];
  betaHeros: HerosDto[] = [];
  omegaHeros: HerosDto[] = [];

  //liste final qu'on affiche à l'écran après avoir filtrer
  filteredHeros: HerosDto[] = [];

  // checkbox décochées au chargement de la page
  protected showAlpha: boolean = false;
  protected showBeta: boolean = false;
  protected showOmega: boolean = false;

  selectedHero: HerosDto | undefined;

  constructor(private herosService: HerosService, private chefAgenceService: ChefAgenceService) { }
  // au chargement de la page, on récupère tous les types de héros 
  ngOnInit(): void {
    this.loadAlpha();
    this.loadBeta();
    this.loadOmega();
  }

  private loadAlpha(): void {
    this.herosService.findAllAlpha().subscribe(
      (heros: HerosDto[]) => {
        const agenceId = this.chefAgenceService.agenceDuChefId;
        if (!agenceId) {
          console.error("Impossible de filtrer : agence du chef non chargée.");
          this.alphaHeros = [];
          return;
        }
        this.alphaHeros = heros.filter(h => h.agenceId === agenceId);
        this.updateFiltered(); //
      }
    );
  }

  private loadBeta(): void {
    this.herosService.findAllBeta().subscribe(
      (heros: HerosDto[]) => {
        const agenceId = this.chefAgenceService.agenceDuChefId;
        if (!agenceId) {
          console.error("Impossible de filtrer : agence du chef non chargée.");
          this.betaHeros = [];
          return;
        }
        this.betaHeros = heros.filter(h => h.agenceId === agenceId);
        this.updateFiltered(); // on refait la liste filteredHeros
      }
    );
  }

    private loadOmega(): void {
    this.herosService.findAllOmega().subscribe(
      (heros: HerosDto[]) => {
        const agenceId = this.chefAgenceService.agenceDuChefId;
        if (!agenceId) {
          console.error("Impossible de filtrer : agence du chef non chargée.");
          this.omegaHeros = [];
          return;
        }
        this.omegaHeros = heros.filter(h => h.agenceId === agenceId);
        this.updateFiltered();
      }
    );
    }

  updateFiltered(): void {
    const resultat: HerosDto[] = [];

    const aucunFiltre =
      this.showAlpha === false && this.showBeta === false && this.showOmega === false;

    if (aucunFiltre) {
      let i: number;

      for (i = 0; i < this.alphaHeros.length; i++) {
        resultat.push(this.alphaHeros[i]);
      }

      for (i = 0; i < this.betaHeros.length; i++) {
        resultat.push(this.betaHeros[i]);
      }

      for (i = 0; i < this.omegaHeros.length; i++) {
        resultat.push(this.omegaHeros[i]);
      }
    } else {
      let i: number;

      if (this.showAlpha) {
        for (i = 0; i < this.alphaHeros.length; i++) {
          resultat.push(this.alphaHeros[i]);
        }
      }

      if (this.showBeta) {
        for (i = 0; i < this.betaHeros.length; i++) {
          resultat.push(this.betaHeros[i]);
        }
      }

      if (this.showOmega) {
        for (i = 0; i < this.omegaHeros.length; i++) {
          resultat.push(this.omegaHeros[i]);
        }
      }
    }

    this.filteredHeros = resultat;
  }

  selectHero(hero: HerosDto): void {
    this.selectedHero = hero;
  }
}
