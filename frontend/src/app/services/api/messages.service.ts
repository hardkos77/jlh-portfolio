import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Message {
  id: number
  fullName: string
  email: string
  content: string
  timestamp: string
}

@Injectable({
  providedIn: 'root',
})
export class MessageApi {
  private apiUrl = '/api/messages';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Message[]> {
    return this.http.get<Message[]>(this.apiUrl);
  }
}
