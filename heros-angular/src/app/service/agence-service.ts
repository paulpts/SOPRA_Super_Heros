import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject, startWith, switchMap } from 'rxjs';
import { AgenceDto } from '../dto/agence-dto';

@Injectable({
  providedIn: 'root',
})
export class AgenceService {

  private apiUrl: string = 'http://localhost:8080/api/agence';

  private refresh$: Subject<void> = new Subject<void>();

  constructor(private http: HttpClient) { }

  
  public findAll(): Observable<AgenceDto[]> {
    return this.refresh$.pipe(
     
      startWith(null),
      switchMap(() => this.http.get<AgenceDto[]>(this.apiUrl)),
    );
  }

  
  public refresh(): void {
    this.refresh$.next();
  }

  public findById(id: number | string): Observable<AgenceDto> {
    return this.http.get<AgenceDto>(`${this.apiUrl}/${id}`);
  }

  
  public findByChefId(chefId: number | string): Observable<AgenceDto> {
    return this.http.get<AgenceDto>(`${this.apiUrl}/chef/${chefId}`);
  }

 
  public save(agenceDto: AgenceDto): void {
    const payload = agenceDto.toJson();

    
    if (!agenceDto.id) {
      this.http.post<AgenceDto>(this.apiUrl, payload)
        .subscribe(() => this.refresh());
      return;
    }

    
    this.http.put<AgenceDto>(`${this.apiUrl}/${agenceDto.id}`, payload)
      .subscribe(() => this.refresh());
  }

  public update(agence: AgenceDto): Observable<AgenceDto> {
    const payload = agence.toJson ? agence.toJson() : agence;
    return this.http.put<AgenceDto>(`${this.apiUrl}/${agence.id}`, payload);
  }

  public deleteById(id: number | string): void {
    this.http.delete<void>(`${this.apiUrl}/${id}`)
      .subscribe(() => this.refresh());
  }
}
