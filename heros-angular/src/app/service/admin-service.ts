import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, startWith, Subject, switchMap } from 'rxjs';
import { AdminDto } from '../dto/admin-dto';

@Injectable({
  providedIn: 'root',    
})
export class AdminService {
  private apiUrl: string = '/Admin'; // adapter au backend
  private refresh$: Subject<void> = new Subject<void>();

  constructor(private http: HttpClient) {}

  public findAll(): Observable<AdminDto[]> {
    return this.refresh$.pipe(
      startWith(null),
      switchMap(() => this.http.get<AdminDto[]>(this.apiUrl))
    );
  }

  public refresh(): void {
    this.refresh$.next();
  }

  public findById(id: number): Observable<AdminDto> {
    return this.http.get<AdminDto>(`${this.apiUrl}/${id}`);
  }

  public save(AdminDto: AdminDto): void {
    const payload = AdminDto.toJson();

    if (AdminDto.id == null) {
      this.http.post<AdminDto>(this.apiUrl, payload).subscribe(() => this.refresh());
    } else {
      this.http.put<AdminDto>(`${this.apiUrl}/${AdminDto.id}`, payload).subscribe(() => this.refresh());
    }
  }

  public deleteById(id: number): void {
    this.http.delete<void>(`${this.apiUrl}/${id}`).subscribe(() => this.refresh());
  }
}
