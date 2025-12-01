import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject, startWith, switchMap } from 'rxjs';
import { HerosDto } from '../dto/heros-dto';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class HerosService {
  private apiUrl: string = environment.apiUrl + '/heros';
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

  public deleteById(id: string): void {
    this.http.delete<void>(`${this.apiUrl}/${id}`).subscribe(() => this.refresh());
  }
}