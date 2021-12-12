import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FlatDetails } from '../model/flat-details';

@Injectable({
  providedIn: 'root'
})
export class FlatService {

  constructor(private httpClient: HttpClient) { }


  getFlatByAnnouncementId(id: number): Observable<FlatDetails> {
    return this.httpClient.get<FlatDetails>(`http://localhost:8080/flatDetails/announcement/`+id);
  }
}
