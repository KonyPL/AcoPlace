import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddAnnouncementComponent } from './add-announcement/add-announcement.component';
import { AdminComponent } from './admin/admin.component';
import { AnnouncementDetailsListComponent } from './announcement-details-list/announcement-details-list.component';
import { AnnouncementDetailsComponent } from './announcement-details/announcement-details.component';
import { AnnouncementListComponent } from './announcement-list/announcement-list.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterSuccessComponent } from './auth/register-success/register-success.component';
import { RegisterComponent } from './auth/register/register.component';
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
    {path: 'register1', component: RegisterComponent},
    {path: 'login1', component: LoginComponent},
     {path: 'register-success', component: RegisterSuccessComponent},

];

@NgModule({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
