import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddAnnouncementComponent } from './add-announcement/add-announcement.component';
import { AdminComponent } from './admin/admin.component';
import { AnnouncementDetailsListComponent } from './announcement-details-list/announcement-details-list.component';
import { AnnouncementDetailsComponent } from './announcement-details/announcement-details.component';
import { AnnouncementListComponent } from './announcement-list/announcement-list.component';
import { LoginComponent } from './login/login.component';
import { SearchAnnouncementComponent } from './search-announcement/search-announcement.component';
import { UserProfileComponent } from './user-profile/user-profile.component';



const appRoutes: Routes = [

    { path: 'announcements-list', component: AnnouncementListComponent },
    { path: 'announcement/:id', component: AnnouncementDetailsComponent },
    { path: 'add-announcement', component: AddAnnouncementComponent },
    { path: 'announcement-details-list', component: AnnouncementDetailsListComponent },
    { path: 'search-announcement', component: SearchAnnouncementComponent },
    { path: 'user-profile', component: UserProfileComponent },
    { path: 'admin', component: AdminComponent }, 
    { path: 'login', component: LoginComponent }

];

@NgModule({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
