import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HerosService } from '../../service/heros-service';
import { HerosDto } from '../../dto/heros-dto';

@Component({
  standalone: true,
  imports: [CommonModule, FormsModule],
  selector: 'app-heros-page',
  templateUrl: './heros-page.html',
  styleUrls: ['./heros-page.css']
})
export class HerosPage implements OnInit {

  alphaHeros: HerosDto[] = [];
  betaHeros: HerosDto[] = [];
  omegaHeros: HerosDto[] = [];

  filteredHeros: HerosDto[] = [];

  showAlpha: boolean = false;
  showBeta: boolean = false;
  showOmega: boolean = false;

  selectedHero: HerosDto | undefined;

  constructor(private herosService: HerosService) {}

  ngOnInit(): void {
    this.loadAlpha();
    this.loadBeta();
    this.loadOmega();
  }

  private loadAlpha(): void {
    this.herosService.findAllAlpha().subscribe(
      (heros: HerosDto[]) => {
        this.alphaHeros = heros;
        this.updateFiltered();
      }
    );
  }

  private loadBeta(): void {
    this.herosService.findAllBeta().subscribe(
      (heros: HerosDto[]) => {
        this.betaHeros = heros;
        this.updateFiltered();
      }
    );
  }

  private loadOmega(): void {
    this.herosService.findAllOmega().subscribe(
      (heros: HerosDto[]) => {
        this.omegaHeros = heros;
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
