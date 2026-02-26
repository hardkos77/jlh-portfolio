import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface OfferedService {
  id: number;
  title: string;
  description: string;
  imageUrl: string;
}

@Injectable({
  providedIn: 'root',
})
export class OfferedServiceApi {
  private apiUrl = '/api/services';

  constructor(private http: HttpClient) {}

  getAll(): Observable<OfferedService[]> {
    return this.http.get<OfferedService[]>(this.apiUrl);
  }
}
