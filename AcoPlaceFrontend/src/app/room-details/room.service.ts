import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RoomDetails } from '../model/room-details';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  constructor(private httpClient: HttpClient) { }


  getRoomByAnnouncementId(id: number): Observable<RoomDetails> {
    return this.httpClient.get<RoomDetails>(`http://localhost:8080/free/roomDetails/announcement/` + id);
  }
}
