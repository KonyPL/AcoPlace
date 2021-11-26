import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Announcement } from '../model/announcement';
import { AnnouncementParams } from '../model/announcementParams';

@Injectable({
  providedIn: 'root'
})
export class AnnouncementService {

  constructor(private httpClient: HttpClient) { }

  getAnnouncementsList(): Observable<Announcement[]> {
    return this.httpClient.get<Announcement[]>("http://localhost:8080/announcements");
  }

  getAnnouncementById(id: number): Observable<Announcement> {
    return this.httpClient.get<Announcement>(`http://localhost:8080/announcement/`+id);
  }

  createAnnouncement(announcement: Announcement): Observable<Object> {
    return this.httpClient.post(`http://localhost:8080/addAnnouncement/`, announcement);
  }

  getAnnouncementWithParams(announcementParams: AnnouncementParams): Observable<Announcement[]>{
    
    const params= new HttpParams()
    .set('priceMin',announcementParams.priceMin)
    .set('priceMax',announcementParams.priceMax)
    .set('propertyType',announcementParams.propertyType)
    .set('shower',announcementParams.shower)
    .set('oven',announcementParams.oven);


    return this.httpClient.get<Announcement[]>(`http://localhost:8080/searchAnnouncement/`,{params});

  }

}
