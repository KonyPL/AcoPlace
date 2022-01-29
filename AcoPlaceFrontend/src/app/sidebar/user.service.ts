import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserDetails } from '../model/user-details';
import { UserProfileDto } from '../model/user-profile-dto';
import { WebUser } from '../model/WebUser';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }
  
  getCurrentUser(): Observable<WebUser> {
    return this.httpClient.get<WebUser>(`http://localhost:8080/user/current`);
  }

  getCurrentUserDetails(): Observable<UserDetails> { //zmiana danych potrzebna
    return this.httpClient.get<UserDetails>(`http://localhost:8080/currentUserDetails`);
  }

  //getCurrentUserProfileDto

  getCurrentUserProfileDto(): Observable<UserProfileDto> { //zmiana danych potrzebna
    return this.httpClient.get<UserProfileDto>(`http://localhost:8080/userProfileDto/current`);
  }

  
  updateUserByDto(userProfileDto: UserProfileDto): Observable<Object> {
    console.log("JESTEM W UPDATE USER BY DTO");
    return this.httpClient.post(`http://localhost:8080/user/editByDto`, userProfileDto);
  }

  getCurrentUserProfileDtoByAnnouncementId(id: number): Observable<UserProfileDto> {
    return this.httpClient.get<UserProfileDto>(`http://localhost:8080/userProfileDto/getByAnnouncementId/`+ id)
  }
}
