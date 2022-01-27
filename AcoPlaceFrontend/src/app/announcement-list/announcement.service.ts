import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Announcement } from '../model/announcement';
import { AnnouncementParams } from '../model/announcementParams';
import { HouseDetails } from '../model/house-details';
import { FlatDetails } from '../model/flat-details';
import { RoomDetails } from '../model/room-details';
import { AnnouncementDetails } from '../model/announcement-details';
import { AnnouncementCreateDto } from '../model/announcement-dto';

@Injectable({
  providedIn: 'root'
})
export class AnnouncementService {

  constructor(private httpClient: HttpClient) { }

  getAnnouncementsList(): Observable<Announcement[]> {
    return this.httpClient.get<Announcement[]>("http://localhost:8080/free/announcements");
  }

  getActiveAnnouncementsList(): Observable<Announcement[]> {
    return this.httpClient.get<Announcement[]>("http://localhost:8080/announcements/active");
  }

  getInactiveAnnouncementsList(): Observable<Announcement[]> {
    return this.httpClient.get<Announcement[]>("http://localhost:8080/announcements/inactive");
  }


  getAnnouncementById(id: number): Observable<Announcement> {
    return this.httpClient.get<Announcement>(`http://localhost:8080/free/announcement/` + id);
  }


  addAnnouncementToFavourite(id: number): Observable<any> {
    return this.httpClient.get<any>(`http://localhost:8080/announcement/favourite/` + id);
  }


  createAnnouncement(announcement: Announcement): Observable<any> {
    return this.httpClient.post(`http://localhost:8080/addAnnouncement`, announcement);
  }
  createHouseDetails(houseDetails: HouseDetails): Observable<Object> {
    return this.httpClient.post(`http://localhost:8080/addHouseDetails`, houseDetails);
  }
  createFlatDetails(flatDetails: FlatDetails): Observable<Object> {
    return this.httpClient.post(`http://localhost:8080/addFlatDetails`, flatDetails);
  }
  createRoomDetails(roomDetails: RoomDetails): Observable<Object> {
    return this.httpClient.post(`http://localhost:8080/addRoomDetails`, roomDetails);
  }
  createAnnouncementDetails(announcementDetails: AnnouncementDetails): Observable<Object> {
    return this.httpClient.post(`http://localhost:8080/addAnnouncementDetails`, announcementDetails);
  }

  createAnnouncementByDto(announcementDto: AnnouncementCreateDto): Observable<any> {
    return this.httpClient.post(`http://localhost:8080/addAnnouncementByDto`, announcementDto);
  }

  updateAnnouncementByDto(announcementDto: AnnouncementCreateDto): Observable<Object> {
    return this.httpClient.post(`http://localhost:8080/updateAnnouncementByDto`, announcementDto);
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
    if (announcementParams.flatParking != undefined) {
      params = params.set('flatParking', announcementParams.livingSpace)
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

    if (announcementParams.basement === true) mustHave += "basement,";
    if (announcementParams.parking === true) mustHave += "parking,";

    if (mustHave != "") params = params.set('mustHave', mustHave);



    return this.httpClient.get<Announcement[]>(`http://localhost:8080/free/searchAnnouncement`, { params });

  }

  getAnnouncementDetailsById(id: number): Observable<AnnouncementDetails> {
    return this.httpClient.get<AnnouncementDetails>(`http://localhost:8080/free/announcementDetails/` + id);
  }
  getHouseDetailsById(id: number): Observable<HouseDetails> {
    return this.httpClient.get<HouseDetails>(`http://localhost:8080/free/houseDetails/` + id);
  }
  getFlatDetailsById(id: number): Observable<FlatDetails> {
    return this.httpClient.get<FlatDetails>(`http://localhost:8080/free/flatDetails/` + id);
  }
  getRoomDetailsById(id: number): Observable<RoomDetails> {
    return this.httpClient.get<RoomDetails>(`http://localhost:8080/free/roomDetails/` + id);
  }

  getFavouriteAnnouncementsList(): Observable<Announcement[]> {
    return this.httpClient.get<Announcement[]>("http://localhost:8080/announcements/favourite");
  }


  getAnnouncementCreateDtoById(id: number): Observable<AnnouncementCreateDto> {
    return this.httpClient.get<AnnouncementCreateDto>("http://localhost:8080/announcement/announcementDto/" + id);
  }
}
