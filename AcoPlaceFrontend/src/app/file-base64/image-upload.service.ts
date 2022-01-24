import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ImageStorage } from '../model/image-storage';
@Injectable({
    providedIn: 'root'
})
export class ImageUploadService {

    constructor(private httpClient: HttpClient) { }

    // Returns an observable
    addImages(announcementId: string, images: ImageStorage[]): Observable<any> {
        return this.httpClient.post(`http://localhost:8080/announcement/${announcementId}/addImages`, images);
      }

    getImages(announcement_id: number): Observable<any> {
        let params = new HttpParams().set("id", announcement_id) 
        return this.httpClient.get<ImageStorage[]>(`http://localhost:8080/announcementImages`, { params });
      }
    
}