import { Injectable, Output, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { LoginDto } from '../login/login-request.payload';
import { map, tap } from 'rxjs/operators';
import { UserNameDto } from './user-name-dto';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  



  constructor(private httpClient: HttpClient) {
  }

 /* signup(signupRequestPayload: SignupRequestPayload): Observable<any> {
    return this.httpClient.post('http://localhost:8080/api/auth/signup', signupRequestPayload, { responseType: 'text' });
  }*/

  login(loginRequestPayload: LoginDto): Observable<any> {
    return this.httpClient.post<any>('http://localhost:8080/api/auth/signin',
      loginRequestPayload);
  }


  isloggedIn(): Observable<any> {
    return this.httpClient.get<any>('http://localhost:8080/api/auth/isLoggedIn');
  }


  getUserName(): Observable<UserNameDto> {
    return this.httpClient.get<UserNameDto>('http://localhost:8080/api/auth/currentUserName');
  }

  getCurrentUserObject(): Observable<any> {
    return this.httpClient.get<any>('http://localhost:8080/api/auth/currentUserName');
  }

  /*logout() {
    this.httpClient.post('http://localhost:8080/api/auth/logout', this.refreshTokenPayload,
      { responseType: 'text' })
      .subscribe(data => {
        console.log(data);
      }, error => {
        throwError(error);
      })
    this.localStorage.clear('authenticationToken');
    this.localStorage.clear('username');
    this.localStorage.clear('refreshToken');
    this.localStorage.clear('expiresAt');
  }
*/
 

}
