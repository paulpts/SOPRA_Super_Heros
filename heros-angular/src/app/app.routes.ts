import { Routes } from '@angular/router';
import { HerosPage} from './page/heros-page/heros-page';
//import { TableauDeBordPage } from './page/TableauDeBord-page/TableauDeBord';

export const routes: Routes = [
  // Redirection par défaut vers /home si l'utilisateur écrit / dans l'URL
  //{ path: '', redirectTo: 'home', pathMatch: 'full' },

  // Tableau de bord
  //{ path: 'home', component: HomePage },

  // Gestion des héros 
  { path: 'heros', component: HerosPage },

  // Gestion des missions 
 // { path: 'mission', component: MissionPage },

  // Tableau de bord
  //{ path: 'dashboard', component: TableauDeBordPage },

  // Redirection vers le dashboard si l'URL n'existe pas
  //{ path: '**', redirectTo: 'home' }
];
