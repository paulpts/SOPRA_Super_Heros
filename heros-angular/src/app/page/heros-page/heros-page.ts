import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { HerosDto } from '../../dto/heros-dto';
import { HerosService } from '../../service/heros-service';

@Component({
  imports: [ CommonModule ],
  templateUrl: './heros-page.html',
  styleUrl: './heros-page.css',
})
export class HerosPage implements OnInit {

  /**
   Liste de tous les héros (toutes agences confondues) ==>  voir  HTML avec : heros$ | async
   */
  protected heros$!: Observable<HerosDto[]>;

  constructor(private herosService: HerosService) { }

  ngOnInit(): void {
    this.heros$ = this.herosService.findAll();
  }

  public trackHero(index: number, hero: HerosDto): string {
    return hero.id;
  }

  
  public getStatut(hero: HerosDto): string {
    

    
    if (hero.sante <= 25) {
      return 'Blessé';
    }

    
    if (hero.motivation <= 30) {
      return 'En repos';
    }

    
   
    return 'Disponible';
  }

  
  public recruterSuperHero(): void {
    console.log('TODO : ouvrir le formulaire de recrutement d’un super-héros');
  }
}