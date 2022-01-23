import { NgModule } from '@angular/core';
import { BrowserModule, HammerModule } from '@angular/platform-browser';

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
// import { UserProfileComponent } from './user-profile/user-profile.component';
// import { AdminComponent } from './admin/admin.component';
import { MatInputModule } from '@angular/material/input';
import { StartPageComponent } from './start-page/start-page.component';
// Kod Wodnika
import { RegisterComponent } from './auth/register/register.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterSuccessComponent } from './auth/register-success/register-success.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
//import {Ng2Webstorage} from 'ngx-webstorage';
import { HttpClientInterceptor } from './http-client-interceptor';
import { NgxWebstorageModule } from 'ngx-webstorage';
// Koniec kodu Wodnika
import { OwlCarousel, OwlModule } from 'ngx-owl-carousel';
import { GalleryComponent } from './gallery/gallery.component';
import { CarouselModule } from 'ngx-owl-carousel-o';
// import { CarouselHolderComponent } from './carousel-holder/carousel-holder.component';
import { NgxGalleryModule } from '@kolkov/ngx-gallery';
import { NgImageSliderModule } from 'ng-image-slider';
import { MdbAccordionModule } from 'mdb-angular-ui-kit/accordion';
import { MdbCarouselModule } from 'mdb-angular-ui-kit/carousel';
import { MdbCheckboxModule } from 'mdb-angular-ui-kit/checkbox';
import { MdbCollapseModule } from 'mdb-angular-ui-kit/collapse';
import { MdbDropdownModule } from 'mdb-angular-ui-kit/dropdown';
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms';
import { MdbModalModule } from 'mdb-angular-ui-kit/modal';
import { MdbPopoverModule } from 'mdb-angular-ui-kit/popover';
import { MdbRadioModule } from 'mdb-angular-ui-kit/radio';
import { MdbRangeModule } from 'mdb-angular-ui-kit/range';
import { MdbRippleModule } from 'mdb-angular-ui-kit/ripple';
import { MdbScrollspyModule } from 'mdb-angular-ui-kit/scrollspy';
import { MdbTabsModule } from 'mdb-angular-ui-kit/tabs';
import { MdbTooltipModule } from 'mdb-angular-ui-kit/tooltip';
import { MdbValidationModule } from 'mdb-angular-ui-kit/validation';
import { SidebarComponent } from './sidebar/sidebar.component';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatDividerModule } from '@angular/material/divider';
import { MatListModule } from '@angular/material/list'
import { MatFormFieldModule } from '@angular/material/form-field';
import { SearchComponent } from './search/search.component';
// import { BoxComponent } from './box/box.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { AnnoucementActiveListComponent } from './annoucement-active-list/annoucement-active-list.component';
import { AnnouncementInactiveListComponent } from './announcement-inactive-list/announcement-inactive-list.component';
import { FileUploadComponent } from './file-upload/file-upload.component';
import { FileBase64Component } from './file-base64/file-base64.component';
import { NgxGalleryImageComponent } from '@kolkov/ngx-gallery/lib/ngx-gallery-image/ngx-gallery-image.component';
import { NgxImageCompressorModule } from 'ngx-image-compressor';
import { NgxImageCompressService } from 'ngx-image-compress';
// import { SidebarComponent } from './sidebar/sidebar.component';
// import { NgImageSliderModule } from 'ng-image-slider';
// import { SidebarComponent } from './sidebar/sidebar.component';


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
    // UserProfileComponent,
    // AdminComponent,
    StartPageComponent,
    GalleryComponent,
    // CarouselHolderComponent,
    // SidebarComponent
    RegisterComponent,
    LoginComponent,
    RegisterSuccessComponent,
    SidebarComponent,
    SearchComponent,
    // BoxComponent,

    UserProfileComponent,
    AnnoucementActiveListComponent,
    AnnouncementInactiveListComponent,
    FileUploadComponent,
    FileBase64Component
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
    CarouselModule,
    OwlModule,
    // OwlCarousel,
    CarouselModule,
    NgxGalleryModule,
    HammerModule,
    NgImageSliderModule,
    MdbAccordionModule,
    MdbCarouselModule,
    MdbCheckboxModule,
    MdbCollapseModule,
    MdbDropdownModule,
    MdbFormsModule,
    MdbModalModule,
    MdbPopoverModule,
    MdbRadioModule,
    MdbRangeModule,
    MdbRippleModule,
    MdbScrollspyModule,
    MdbTabsModule,
    MdbTooltipModule,
    MdbValidationModule,
    MdbCarouselModule,
    //Kod Wodnika
    ReactiveFormsModule,
    NgxWebstorageModule.forRoot(),
    //Koniec kodu Wodnika
    MdbCarouselModule,
    CommonModule,
    RouterModule,
    // SharedModule,
    MatSidenavModule,
    MatSliderModule,
    FlexLayoutModule,
    MatCardModule,
    MatPaginatorModule,
    MatTableModule,
    MatToolbarModule,
    MatDividerModule,
    MatListModule,
    MatFormFieldModule,
    NgxImageCompressorModule


  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: HttpClientInterceptor, multi: true }, HttpClientModule, NgxImageCompressService],

  // vvv Tak było "wcześniej"
  //providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
//comment
