import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, startWith, Subject, switchMap } from 'rxjs';
import { HeroDto } from '../dto/heros-dto';

@Injectable({
  providedIn: 'root',    
})
export class HeroService {
  private apiUrl: string = '/heros'; // adapter au backend
  private refresh$: Subject<void> = new Subject<void>();

  constructor(private http: HttpClient) {}

  public findAll(): Observable<HeroDto[]> {
    return this.refresh$.pipe(
      startWith(null),
      switchMap(() => this.http.get<HeroDto[]>(this.apiUrl))
    );
  }

  public refresh(): void {
    this.refresh$.next();
  }

  public findById(id: number): Observable<HeroDto> {
    return this.http.get<HeroDto>(`${this.apiUrl}/${id}`);
  }

  public save(heroDto: HeroDto): void {
    const payload = heroDto.toJson();

    if (heroDto.id == null) {
      this.http.post<HeroDto>(this.apiUrl, payload).subscribe(() => this.refresh());
    } else {
      this.http.put<HeroDto>(`${this.apiUrl}/${heroDto.id}`, payload).subscribe(() => this.refresh());
    }
  }

  public deleteById(id: number): void {
    this.http.delete<void>(`${this.apiUrl}/${id}`).subscribe(() => this.refresh());
  }
}
