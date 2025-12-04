import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject, startWith, switchMap } from 'rxjs';
import { HerosDto } from '../dto/heros-dto';


@Injectable({
  providedIn: 'root',
})
export class HerosService {
  private apiUrl: string = 'http://localhost:8080/api/heros'; //  car  au niveau du back on a : @RequestMapping("/api/heros")
  private refresh$: Subject<void> = new Subject<void>();

  constructor(private http: HttpClient) { }

  /** Liste de tous les héros (vue admin) */
  public findAll(): Observable<HerosDto[]> {
    return this.refresh$.pipe(
      startWith(null),
      switchMap(() => this.http.get<HerosDto[]>(this.apiUrl))
    );
  }

  /** Liste des héros de l' agence (vue chef d'agence) */
  public findByAgence(agenceId: number | string): Observable<HerosDto[]> {
    return this.refresh$.pipe(
      startWith(null),
      switchMap(() =>
        this.http.get<HerosDto[]>(`${this.apiUrl}/agence/${agenceId}`)
      )
    );
  }

  
  public findById(id: number | string): Observable<HerosDto> {
    return this.http.get<HerosDto>(`${this.apiUrl}/${id}`);
  }

  public refresh(): void {
    this.refresh$.next();
  }

  public save(herosDto: HerosDto): void {
    const payload = herosDto.toJson();

    if (!herosDto.id) {
      this.http.post<HerosDto>(this.apiUrl, payload).subscribe(() => this.refresh());
      return;
    }

    this.http.put<HerosDto>(`${this.apiUrl}/${herosDto.id}`, payload)
      .subscribe(() => this.refresh());
  }

public update(hero: HerosDto): Observable<HerosDto> {
     return this.http.put<HerosDto>(`${this.apiUrl}/${hero.id}`, hero);
}

  public deleteById(id: string): void {
    this.http.delete<void>(`${this.apiUrl}/${id}`).subscribe(() => this.refresh());
  }

 public findAllOmega(): Observable<HerosDto[]> {
    return this.http.get<HerosDto[]>('http://localhost:8080/api/omega');
  }

  public findAllBeta(): Observable<HerosDto[]> {
    return this.http.get<HerosDto[]>('http://localhost:8080/api/beta');
  }

  public findAllAlpha(): Observable<HerosDto[]> {
    return this.http.get<HerosDto[]>('http://localhost:8080/api/alpha');
  }
}

