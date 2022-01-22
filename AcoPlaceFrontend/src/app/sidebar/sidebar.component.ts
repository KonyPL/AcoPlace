import { Component, Input, OnInit, SimpleChanges } from '@angular/core';
import { WebUser } from '../model/WebUser';
import { UserService } from './user.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  
  @Input() authenticated: boolean; 
  webUser: WebUser = new WebUser;

  constructor( private userService: UserService) { }

  ngOnInit(): void {
    //console.log("ngOnInit sidebar="+this.authenticated); 
  }
  
  ngOnChanges(changes: SimpleChanges) { //ladnie wywoulje sie podczas zmian w authenticated
    console.log("ng on changes sidebar CALLED---------------------------------------------------------------------------------------------------")
    this.getCurrentUser();

  }

  public getCurrentUser(){
    this.userService.getCurrentUser().subscribe(
      data => {
        this.webUser = data;
        console.log("DATA from endpoint"+ data.id +data.email +data.userName +data.password);
      }
    )  }


}
