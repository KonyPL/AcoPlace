import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Announcement } from '../model/announcement';
import { Place } from '../model/place';

@Injectable({
  providedIn: 'root'
})
export class PlaceService {

  constructor(private httpClient: HttpClient) { }

  getPlacesList(): Observable<Place[]> {
    return this.httpClient.get<Place[]>("http://localhost:8080/places");
  }
}
