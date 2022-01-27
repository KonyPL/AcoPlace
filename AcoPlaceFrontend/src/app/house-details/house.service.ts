import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HouseDetails } from '../model/house-details';

@Injectable({
  providedIn: 'root'
})
export class HouseService {

  constructor(private httpClient: HttpClient) { }


  getHouseByAnnouncementId(id: number): Observable<HouseDetails> {
    return this.httpClient.get<HouseDetails>(`http://localhost:8080/free/houseDetails/announcement/` + id);
  }
}
