import { Routes } from '@angular/router';
import { HomePage } from './page/home-page/home-page';
import { HerosPage} from './page/heros-page/heros-page';
import { MissionPage } from './page/mission-page/mission-page';

export const routes: Routes = [
  // Redirection par défaut vers /home si l'utilisateur écrit / dans l'URL
  { path: '', redirectTo: 'home', pathMatch: 'full' },

  // Tableau de bord
  { path: 'home', component: HomePage },

  // Gestion des héros 
  { path: 'heros', component: HerosPage },

  // Gestion des missions 
  { path: 'mission', component: MissionPage },

  // Redirection vers le dashboard si l'URL n'existe pas
  { path: '**', redirectTo: 'home' }
];
