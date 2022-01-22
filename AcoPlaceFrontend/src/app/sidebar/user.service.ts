import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { WebUser } from '../model/WebUser';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }
  
  getCurrentUser(): Observable<WebUser> {
    return this.httpClient.get<WebUser>(`http://localhost:8080/user/current`);
  }
}
