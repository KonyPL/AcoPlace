import { Component, OnInit } from '@angular/core';
import { Place } from '../model/place';
import { PlaceService } from './place.service';

@Component({
  selector: 'app-places-list',
  templateUrl: './places-list.component.html',
  styleUrls: ['./places-list.component.css']
})
export class PlacesListComponent implements OnInit {


  places: Place[];

  constructor(private placeService: PlaceService) { }

  ngOnInit(): void {
    this.getPlaces();
  }

  private getPlaces() {
    this.placeService.getPlacesList().subscribe(
      data => {
        this.places = data;
        console.log("DATA from endpoint for places" + data);
      }
    )
  }
}
