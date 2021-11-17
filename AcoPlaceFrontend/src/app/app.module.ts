import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AnnouncementListComponent } from './announcement-list/announcement-list.component';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './header/header.component';

import { AppRoutingModule } from './app-routing.module';
import { AnnouncementDetailsComponent } from './announcement-details/announcement-details.component';
import { AddAnnouncementComponent } from './add-announcement/add-announcement.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    AnnouncementListComponent,
    HeaderComponent,
    AnnouncementDetailsComponent,
    AddAnnouncementComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule

  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
