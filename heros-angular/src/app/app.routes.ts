import { Routes } from '@angular/router';
import { HerosPage} from './page/heros-page/heros-page';
import { ConnexionPage } from './page/connexion-page/connexion-page';
import { TDB } from './page/TableauDeBord-page/TDB';
import { MissionPage } from './page/mission-page/mission-page';
import { authGuard } from './guard/auth-guard';

export const routes: Routes = [
  // Redirection par défaut vers /home si l'utilisateur écrit / dans l'URL
  //{ path: '', redirectTo: 'home', pathMatch: 'full' },

  // Connexion
  { path: 'auth', component: ConnexionPage },

  // Tableau de bord
  { path: 'home', component: TDB, canActivate: [authGuard]}, 
  // pour protéger la route avec le guard

  // Gestion des héros 
  { path: 'heros', component: HerosPage, canActivate: [authGuard] },

  // Gestion des missions 
  { path: 'mission', component: MissionPage , canActivate: [authGuard]},

  // Tableau de bord
  //{ path: 'dashboard', component: TableauDeBordPage },

  // Redirection vers le dashboard si l'URL n'existe pas
  //{ path: '**', redirectTo: 'home' }
];
