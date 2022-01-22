import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Announcement } from '../model/announcement';
import { AnnouncementParams } from '../model/announcementParams';
import { AnnouncementDetails } from '../model/announcement-details';

@Injectable({
    providedIn: 'root'
})
export class SearchService {

    constructor(private httpClient: HttpClient) { }

    getAnnouncementsList(): Observable<Announcement[]> {
        return this.httpClient.get<Announcement[]>("http://localhost:8080/free/announcements");
    }

    getAnnouncementById(id: number): Observable<Announcement> {
        return this.httpClient.get<Announcement>(`http://localhost:8080/announcement/` + id);
    }

    getAnnouncementDetailsById(id: number): Observable<AnnouncementDetails> {
        return this.httpClient.get<AnnouncementDetails>(`http://localhost:8080/announcementDetails/` + id);
    }


}
