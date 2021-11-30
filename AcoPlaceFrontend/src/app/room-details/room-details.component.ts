import { Component, Input, OnInit } from '@angular/core';
import { RoomDetails } from '../model/room-details';
import { RoomService } from './room.service';

@Component({
  selector: 'app-room-details',
  templateUrl: './room-details.component.html',
  styleUrls: ['./room-details.component.css']
})
export class RoomDetailsComponent implements OnInit {

  @Input('id') id: number; 
  roomDetails: RoomDetails;

  constructor(private roomService: RoomService) { }

  ngOnInit(): void {
    this.getRoomDetails();
  }



  public getRoomDetails(){
    this.roomService.getRoomByAnnouncementId(this.id).subscribe(
      data => {
        this.roomDetails = data;
        console.log("DATA from endpoint" + data);
      }
    )  }

}
