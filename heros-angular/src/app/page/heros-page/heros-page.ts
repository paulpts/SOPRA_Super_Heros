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

  /**
   * Retourne le texte du statut à afficher pour un héros.
   *
   * Dans ton back, le "statut" (en cours / terminé / pas commencé) est porté
   * par l’entité Mission, pas par Heros.
   * Et chaque Mission a un champ `statut` + un `hero`.
   *
   * Actuellement, ton HerosDto ne contient pas la liste de missions,
   * donc on ne peut PAS savoir réellement "est-ce qu’il a une mission en cours ?".
   *
   * Du coup, je te propose une logique simple basée sur la santé/motivation,
   * que tu pourras ajuster ou remplacer plus tard par une vraie info venant du back.
   */
  public getStatut(hero: HerosDto): string {
    // Exemple de règles simples (à adapter selon ce que tu veux) :

    // Très faible santé -> blessé
    if (hero.sante <= 25) {
      return 'Blessé';
    }

    // Santé correcte mais faible motivation -> en repos
    if (hero.motivation <= 30) {
      return 'En repos';
    }

    // A modifier en fonction du back statut mission (par ex. si le back renvoie un booléen hero.enMission)
   
    return 'Disponible';
  }

  /**
   * Bouton "Recruter un super-héros" (colonne de droite).
   * Pour le moment je laisse un TODO. Plus tard tu pourras :
   *  - soit ouvrir un formulaire de création,
   *  - soit naviguer vers une autre page.
   */
  public recruterSuperHero(): void {
    console.log('TODO : ouvrir le formulaire de recrutement d’un super-héros');
  }
}