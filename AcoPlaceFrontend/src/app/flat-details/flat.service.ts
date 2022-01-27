import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AnnouncementDetails } from '../model/announcement-details';
import { AnnouncementParams } from '../model/announcementParams';
import { FlatDetails } from '../model/flat-details';

@Injectable({
  providedIn: 'root'
})
export class FlatService {

  constructor(private httpClient: HttpClient) { }

  // getAnnouncementsDetailsList(): Observable<AnnouncementDetails[]> {
  //   return this.httpClient.get<AnnouncementDetails[]>("http://localhost:8080/announcementDetailsAll");
  // }

  getAnnouncementDetailsById(id: number): Observable<AnnouncementParams> {
    return this.httpClient.get<AnnouncementParams>(`http://localhost:8080/announcementDetails/`+id);
  }

  getFlatByAnnouncementId(id: number): Observable<FlatDetails> {
    return this.httpClient.get<FlatDetails>(`http://localhost:8080/free/flatDetails/announcement/` + id);
  }
}
