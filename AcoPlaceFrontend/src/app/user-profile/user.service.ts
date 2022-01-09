import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { UserPrefereces } from '../model/user-preferences';
import { WebUser } from '../model/web-user';

@Injectable({
    providedIn: 'root'
})
export class UserService {

    constructor(private httpClient: HttpClient) { }


    getUserInfo(): Observable<WebUser> {
        return this.httpClient.get<WebUser>(`http://localhost:8080/user/getuser`);
    }

    /*getUsersList(): Observable<User[]> {
        return this.httpClient.get<User[]>("http://localhost:8080/users");
    }

    getUserById(id: number): Observable<User> {
        return this.httpClient.get<User>(`http://localhost:8080/announcement/` + id);
    }

    createUser(announcement: User): Observable<Object> {
        return this.httpClient.post(`http://localhost:8080/addAnnouncement/`, announcement);
    }*/

    //   getUserWithParams(userPreferences: UserPrefereces): Observable<User[]> {

    //     const params = new HttpParams()
    //       .set('priceMin', userParams.priceMin)
    //       .set('priceMax', userParams.priceMax)
    //       .set('propertyType', announcementParams.propertyType)
    //       .set('shower', announcementParams.shower)
    //       .set('oven', announcementParams.oven);


    //     return this.httpClient.get<User[]>(`http://localhost:8080/searchAnnouncement`, { params });
    //     // /
    //   }

   /* getUserDetailsById(id: number): Observable<UserTable> {
        return this.httpClient.get<UserTable>(`http://localhost:8080/announcementDetails/` + id);
    }*/


}
