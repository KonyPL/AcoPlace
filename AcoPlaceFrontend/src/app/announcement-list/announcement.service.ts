import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Announcement } from '../model/announcement';
import { AnnouncementParams } from '../model/announcementParams';
import { AnnouncementDetails } from '../model/announcement-details';

@Injectable({
  providedIn: 'root'
})
export class AnnouncementService {

  constructor(private httpClient: HttpClient) { }

  getAnnouncementsList(): Observable<Announcement[]> {
    return this.httpClient.get<Announcement[]>("http://localhost:8080/free/announcements");
  }

  getAnnouncementById(id: number): Observable<Announcement> {
    return this.httpClient.get<Announcement>(`http://localhost:8080/announcement/` + id);
  }

  createAnnouncement(announcement: Announcement): Observable<Object> {
    return this.httpClient.post(`http://localhost:8080/addAnnouncement`, announcement);
  }

  getAnnouncementWithParams(announcementParams: AnnouncementParams): Observable<Announcement[]> {

    let params = new HttpParams();

    if (announcementParams.city != undefined) {
      params = params.set('city', announcementParams.city);
    }
    if (announcementParams.country != undefined) {
      params = params.set('country', announcementParams.country);
    }
    if (announcementParams.district != undefined) {
      params = params.set('district', announcementParams.district);
    }

    if ((announcementParams.priceMax != undefined) && (announcementParams.priceMin != undefined)) {
      params = params.set('priceMin', announcementParams.priceMin);
      params = params.set('priceMax', announcementParams.priceMax);
    }
    if (announcementParams.floor != undefined) {
      params = params.set('floor', announcementParams.floor);
    }
    if (announcementParams.floors != undefined) {
      params = params.set('floors', announcementParams.floors);
    }
    if (announcementParams.bedrooms != undefined) {
      params = params.set('bedrooms', announcementParams.bedrooms);
    }
    if (announcementParams.bathrooms != undefined) {
      params = params.set('bathrooms', announcementParams.bathrooms);
    }
    if (announcementParams.balcony != undefined) {
      params = params.set('balcony', announcementParams.balcony);
    }
    if (announcementParams.lotSize != undefined) {
      params = params.set('lotSize', announcementParams.lotSize);
    }
    if (announcementParams.bedsInRoom != undefined) {
      params = params.set('bedsInRoom', announcementParams.bedsInRoom);
    }
    if (announcementParams.numberOfFlatmates != undefined) {
      params = params.set('numberOfFlatmates', announcementParams.numberOfFlatmates);
    }
    if (announcementParams.internetSpeed != undefined) {
      params = params.set('internetSpeed', announcementParams.internetSpeed);
    }
    if (announcementParams.livingSpace != undefined) {
      params = params.set('livingSpace', announcementParams.livingSpace);
    }

    if (announcementParams.propertyType != undefined) {
      params = params.set('propertyType', announcementParams.propertyType);
    }
    let mustHave = "";
    if (announcementParams.oven === true) mustHave += "oven,";
    if (announcementParams.shower === true) mustHave += "shower,";
    if (announcementParams.bath === true) mustHave += "bath,";
    if (announcementParams.microwave === true) mustHave += "microwave,";
    if (announcementParams.elevator === true) mustHave += "elevator,";
    if (announcementParams.petsAllowed === true) mustHave += "petsAllowed,";
    if (announcementParams.nearPark === true) mustHave += "nearPark,";
    if (announcementParams.fenced === true) mustHave += "fenced,";
    if (announcementParams.nearTram === true) mustHave += "nearTram,";
    if (announcementParams.nearBus === true) mustHave += "nearBus,";
    if (announcementParams.wifi === true) mustHave += "wifi,";
    if (announcementParams.ethernetOutlets === true) mustHave += "ethernetOutlets,";
    if (announcementParams.internet === true) mustHave += "internet,";
    if (announcementParams.tv === true) mustHave += "tv,";
    if (announcementParams.dishwasher === true) mustHave += "dishwasher,";
    if (announcementParams.clothesDryer === true) mustHave += "clothesDryer,";
    if (announcementParams.nearShoppingMall === true) mustHave += "nearShoppingMall,";
    if (announcementParams.nearBakery === true) mustHave += "nearBakery,";
    if (announcementParams.nearFoodMarket === true) mustHave += "nearFoodMarket,";
    if (announcementParams.nearSupermarket === true) mustHave += "nearSupermarket,";
    if (announcementParams.flatParking === true) mustHave += "flatParking,";
    if (announcementParams.basement === true) mustHave += "basement,";
    if (announcementParams.parking === true) mustHave += "parking,";

    if (mustHave != "") params = params.set('mustHave', mustHave);



    return this.httpClient.get<Announcement[]>(`http://localhost:8080/free/searchAnnouncement`, { params });

  }

  getAnnouncementDetailsById(id: number): Observable<AnnouncementDetails> {
    return this.httpClient.get<AnnouncementDetails>(`http://localhost:8080/announcementDetails/` + id);
  }


}
