import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Appointment {
  id: number
  fullName: string
  email: string
  reason: string
  scheduledAt: string
  status: string
}

@Injectable({
  providedIn: 'root',
})
export class AppointmentApi {
  private apiUrl = '/api/appointments';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Appointment[]> {
    return this.http.get<Appointment[]>(this.apiUrl);
  }
}
