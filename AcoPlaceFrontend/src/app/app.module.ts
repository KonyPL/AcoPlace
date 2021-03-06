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
import { AnnouncementDetailsDetailsComponent } from './announcement-details-details/announcement-details-details.component';
import { HouseDetailsComponent } from './house-details/house-details.component';
import { RoomDetailsComponent } from './room-details/room-details.component';
import { FlatDetailsComponent } from './flat-details/flat-details.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import { MatIconModule } from '@angular/material/icon';
import { MatSelectModule } from '@angular/material/select';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatInputModule } from '@angular/material/input';
import { RegisterComponent } from './auth/register/register.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterSuccessComponent } from './auth/register-success/register-success.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpClientInterceptor } from './http-client-interceptor';
import { NgxWebstorageModule } from 'ngx-webstorage';
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
import { UserProfileComponent } from './user-profile/user-profile.component';
import { AnnoucementActiveListComponent } from './annoucement-active-list/annoucement-active-list.component';
import { AnnouncementInactiveListComponent } from './announcement-inactive-list/announcement-inactive-list.component';
import { AnnouncementFavouriteListComponent } from './announcement-favourite-list/announcement-favourite-list.component';
import { FileBase64Component } from './file-base64/file-base64.component';
import { NgxGalleryImageComponent } from '@kolkov/ngx-gallery/lib/ngx-gallery-image/ngx-gallery-image.component';
import { NgxImageCompressorModule } from 'ngx-image-compressor';
import { NgxImageCompressService } from 'ngx-image-compress';
import { EditAnnouncementComponent } from './edit-announcement/edit-announcement.component';
import { UserProfileEditComponent } from './user-profile-edit/user-profile-edit.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap'
import { MAT_DATE_LOCALE } from '@angular/material/core';
import { AllInfoAnnouncementComponent } from './all-info-announcement/all-info-announcement.component';
import { OtherUserProfileComponent } from './other-user-profile/other-user-profile.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatGridTileHarness } from '@angular/material/grid-list/testing';
import { MatButtonModule } from '@angular/material/button';
import { FooterComponent } from './footer/footer.component';
import { PrivacyPolicyComponent } from './privacy-policy/privacy-policy.component';
import { NgxImageGalleryModule } from 'ngx-image-gallery';
import { NotFoundComponent } from './not-found/not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    AnnouncementListComponent,
    HeaderComponent,
    AnnouncementDetailsComponent,
    AddAnnouncementComponent,
    AnnouncementDetailsListComponent,
    AnnouncementDetailsDetailsComponent,
    HouseDetailsComponent,
    RoomDetailsComponent,
    FlatDetailsComponent,
    GalleryComponent,
    RegisterComponent,
    LoginComponent,
    RegisterSuccessComponent,
    SidebarComponent,
    UserProfileComponent,
    AnnoucementActiveListComponent,
    AnnouncementInactiveListComponent,
    AnnouncementFavouriteListComponent,
    FileBase64Component,
    EditAnnouncementComponent,
    UserProfileEditComponent,
    AllInfoAnnouncementComponent,
    OtherUserProfileComponent,
    FooterComponent,
    PrivacyPolicyComponent,
    NotFoundComponent
  ],
  imports: [
    NgbModule,
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
    NgxImageCompressorModule,
    MatGridListModule,
    MatButtonModule,
    NgxImageGalleryModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: HttpClientInterceptor, multi: true }, HttpClientModule, NgxImageCompressService,
  { provide: MAT_DATE_LOCALE, useValue: 'en-GB' },
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }