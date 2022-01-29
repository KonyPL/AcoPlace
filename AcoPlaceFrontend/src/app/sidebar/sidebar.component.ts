import { Component, Input, OnInit, SimpleChanges } from '@angular/core';
import { WebUser } from '../model/WebUser';
import { UserService } from './user.service';
import { DomSanitizer } from '@angular/platform-browser';
import { MatIconRegistry } from '@angular/material/icon';
import { UserProfileDto } from '../model/user-profile-dto';
@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  @Input() authenticated: boolean;
  webUser: WebUser = new WebUser;

  userProfileDto: UserProfileDto = new UserProfileDto;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getCurrentUserPicture();
  }

  ngOnChanges(changes: SimpleChanges) { //ladnie wywoulje sie podczas zmian w authenticated
    console.log("ng on changes sidebar CALLED---------------------------------------------------------------------------------------------------") // do wyrzucenia to
    this.getCurrentUser();
    this.getCurrentUserPicture();
  }

  public getCurrentUser() {
    this.userService.getCurrentUser().subscribe(
      data => {
        this.webUser = data;
      }
    )
  }

  public getCurrentUserPicture(){
    this.userService.getCurrentUserDetails().subscribe(
    data => {
      this.userProfileDto.b64image = data.b64image;
    }
    )
  }
}
