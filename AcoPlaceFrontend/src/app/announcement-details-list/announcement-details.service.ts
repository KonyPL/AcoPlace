import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AnnouncementDetails } from '../model/announcement-details';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AnnouncementDetailsService {

  constructor(private httpClient: HttpClient) { }

  getAnnouncementsDetailsList(): Observable<AnnouncementDetails[]> {
    return this.httpClient.get<AnnouncementDetails[]>("http://localhost:8080/announcementDetailsAll");
  }

  getAnnouncementDetailsById(id: number): Observable<AnnouncementDetails> {
    return this.httpClient.get<AnnouncementDetails>(`http://localhost:8080/announcementDetails/`+id);
  }

  createAnnouncementDetails(announcementDetails: AnnouncementDetails): Observable<Object> {
    return this.httpClient.post(`http://localhost:8080/addAnnouncementDetails/`, announcementDetails);
  }


}
