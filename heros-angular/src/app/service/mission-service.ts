import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject, startWith, switchMap } from 'rxjs';
import { MissionDto } from '../dto/mission-dto';

@Injectable({
  providedIn: 'root',
})
export class MissionService {

  private apiUrl: string = 'http://localhost:8080/api/mission';

  
  private refresh$: Subject<void> = new Subject<void>();

  constructor(private http: HttpClient) { }

  
  public findAll(): Observable<MissionDto[]> {
    return this.refresh$.pipe(
      startWith(null),
      switchMap(() => this.http.get<MissionDto[]>(this.apiUrl))
    );
  }

  
  public refresh(): void {
    this.refresh$.next();
  }

  
  public findById(id: number | string): Observable<MissionDto> {
    return this.http.get<MissionDto>(`${this.apiUrl}/${id}`);
  }


  public save(missionDto: MissionDto): Observable<MissionDto> {
    const payload = missionDto.toJson();

    if (missionDto.id === null) {
      
      return this.http.post<MissionDto>(this.apiUrl, payload);
      
    }

    
     return this.http.put<MissionDto>(`${this.apiUrl}/${missionDto.id}`, payload);
  }

  
  public deleteById(id: number | string): void {
    this.http.delete<void>(`${this.apiUrl}/${id}`)
      .subscribe(() => this.refresh());
  }
}
