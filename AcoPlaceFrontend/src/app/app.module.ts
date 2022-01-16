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
import { AnnouncementDetailsListComponent } from './announcement-details-list/announcement-details-list.component';
import { SearchAnnouncementComponent } from './search-announcement/search-announcement.component';
import { AnnouncementDetailsDetailsComponent } from './announcement-details-details/announcement-details-details.component';
import { HouseDetailsComponent } from './house-details/house-details.component';
import { RoomDetailsComponent } from './room-details/room-details.component';
import { FlatDetailsComponent } from './flat-details/flat-details.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';

// import {
//   MatAutocompleteModule, MatButtonModule, MatCheckboxModule, MatDatepickerModule,
//   MatFormFieldModule, MatInputModule, MatRadioModule, MatSelectModule, MatSliderModule,
//   MatSlideToggleModule
// } from '@angular/material';

@NgModule({
  declarations: [
    AppComponent,
    AnnouncementListComponent,
    HeaderComponent,
    AnnouncementDetailsComponent,
    AddAnnouncementComponent,
    AnnouncementDetailsListComponent,
    SearchAnnouncementComponent,
    AnnouncementDetailsDetailsComponent,
    HouseDetailsComponent,
    RoomDetailsComponent,
    FlatDetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MatSliderModule

  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
//comment
