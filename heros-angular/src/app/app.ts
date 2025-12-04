import { Component, signal } from '@angular/core';
import { Navigation } from './page/navigation/navigation'; 
import { RouterOutlet, Router, NavigationEnd, Event } from '@angular/router'; 
import { CommonModule } from '@angular/common';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Navigation, CommonModule],
  templateUrl: './app.html',
  styleUrls: ['./app.scss']
})
export class App {
  showHeader = true;

  constructor(private router: Router) {
    // On s'abonne aux changements de page
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd) // On attend la fin de la navigation
    ).subscribe((event: any) => {
      // Si l'url contient '/login', on cache le header
      if (event.url.includes('/auth')) {
        this.showHeader = false;
      } else {
        this.showHeader = true;
      }
    });
  }
}