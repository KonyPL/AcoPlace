import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Announcement } from '../model/announcement';

@Injectable({
  providedIn: 'root'
})
export class AnnouncementService {

  constructor(private httpClient: HttpClient) { }

  getAnnouncementsList(): Observable<Announcement[]> {
    return this.httpClient.get<Announcement[]>("http://localhost:8080/annoucements");
  }

  getAnnouncementById(id: number): Observable<Announcement> {
    return this.httpClient.get<Announcement>(`http://localhost:8080/announcement/`+id);
  }

  createAnnouncement(announcement: Announcement): Observable<Object> {
    return this.httpClient.post(`http://localhost:8080/addAnnouncement/`, announcement);
  }


}
