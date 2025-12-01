import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, startWith, Subject, switchMap } from 'rxjs';
import { ChefAgenceDto } from '../dto/chefAgence-dto';

@Injectable({
  providedIn: 'root',    
})
export class ChefAgenceService {
  private apiUrl: string = '/ChefAgence'; // adapter au backend
  private refresh$: Subject<void> = new Subject<void>();

  constructor(private http: HttpClient) {}

  public findAll(): Observable<ChefAgenceDto[]> {
    return this.refresh$.pipe(
      startWith(null),
      switchMap(() => this.http.get<ChefAgenceDto[]>(this.apiUrl))
    );
  }

  public refresh(): void {
    this.refresh$.next();
  }

  public findById(id: number): Observable<ChefAgenceDto> {
    return this.http.get<ChefAgenceDto>(`${this.apiUrl}/${id}`);
  }

  public save(ChefAgenceDto: ChefAgenceDto): void {
    const payload = ChefAgenceDto.toJson();

    if (ChefAgenceDto.id == null) {
      this.http.post<ChefAgenceDto>(this.apiUrl, payload).subscribe(() => this.refresh());
    } else {
      this.http.put<ChefAgenceDto>(`${this.apiUrl}/${ChefAgenceDto.id}`, payload).subscribe(() => this.refresh());
    }
  }

  public deleteById(id: number): void {
    this.http.delete<void>(`${this.apiUrl}/${id}`).subscribe(() => this.refresh());
  }
}
