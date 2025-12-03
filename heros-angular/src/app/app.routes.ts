import { Routes } from '@angular/router';
import { HerosPage} from './page/heros-page/heros-page';
import { ConnexionPage } from './page/connexion-page/connexion-page';
import { TDB } from './page/TableauDeBord-page/TDB';
import { MissionPage } from './page/mission-page/mission-page';

export const routes: Routes = [
  // Redirection par défaut vers /home si l'utilisateur écrit / dans l'URL
  //{ path: '', redirectTo: 'home', pathMatch: 'full' },

  // Connexion
  { path: 'auth', component: ConnexionPage },

  // Tableau de bord
  { path: 'home', component: TDB },

  // Gestion des héros 
  { path: 'heros', component: HerosPage },

  // Gestion des missions 
  { path: 'mission', component: MissionPage },

  // Tableau de bord
  //{ path: 'dashboard', component: TableauDeBordPage },

  // Redirection vers le dashboard si l'URL n'existe pas
  //{ path: '**', redirectTo: 'home' }
];
