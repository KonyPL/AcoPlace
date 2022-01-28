import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { AnnouncementService } from '../announcement-list/announcement.service';
import { AuthService } from '../auth/auth.service';
import { Announcement } from '../model/announcement';
import { AnnouncementParams } from '../model/announcementParams';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public authService: AuthService, private breakpointObserver: BreakpointObserver, private announcementService: AnnouncementService) { }

  ngOnInit(): void {
  }

  logout() {
    this.authService.logout();
  }


  announcementParams: AnnouncementParams = new AnnouncementParams();

  announcements: Announcement[];

  // isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
  //   .pipe(
  //     map(result => result.matches),
  //     shareReplay()
  //   );

}
