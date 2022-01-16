import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AnnouncementListComponent } from './announcement-list/announcement-list.component';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './header/header.component';

import { AppRoutingModule } from './app-routing.module';
import { AnnouncementDetailsComponent } from './announcement-details/announcement-details.component';
import { AddAnnouncementComponent } from './add-announcement/add-announcement.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AnnouncementDetailsListComponent } from './announcement-details-list/announcement-details-list.component';
import { SearchAnnouncementComponent } from './search-announcement/search-announcement.component';
import { AnnouncementDetailsDetailsComponent } from './announcement-details-details/announcement-details-details.component';
import { HouseDetailsComponent } from './house-details/house-details.component';
import { RoomDetailsComponent } from './room-details/room-details.component';
import { FlatDetailsComponent } from './flat-details/flat-details.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import { MatIconModule } from '@angular/material/icon';
import { MatSelectModule } from '@angular/material/select';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { AdminComponent } from './admin/admin.component';
import { MatInputModule } from '@angular/material/input';
import { StartPageComponent } from './start-page/start-page.component';
import { RegisterComponent } from './auth/register/register.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterSuccessComponent } from './auth/register-success/register-success.component';
import {HTTP_INTERCEPTORS} from '@angular/common/http';
//import {Ng2Webstorage} from 'ngx-webstorage';
import { HttpClientInterceptor } from './http-client-interceptor';
import { NgxWebstorageModule } from 'ngx-webstorage';
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
    FlatDetailsComponent,
    UserProfileComponent,
    AdminComponent,
    StartPageComponent, 
    RegisterComponent,
    LoginComponent,
    RegisterSuccessComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatIconModule,
    MatSelectModule,
    MatCheckboxModule,
    MatInputModule, 
    ReactiveFormsModule,
    NgxWebstorageModule.forRoot()
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: HttpClientInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
//comment
