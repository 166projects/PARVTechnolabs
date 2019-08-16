import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';  


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GetEligibleCandidateComponent } from './admin/get-eligible-candidate-component/get-eligible-candidate-component.component';
import { AdminService } from './admin.service';
import { HttpClientModule } from '@angular/common/http';
import { GetAllInterviewSchedulesComponent } from './admin/get-all-interview-schedules/get-all-interview-schedules.component';
import { AdminComponent } from './admin/admin.component';
import { GetAllLeavesComponent } from './admin/get-all-leaves/get-all-leaves.component';
import { ScheduleInterviewComponent } from './admin/schedule-interview/schedule-interview.component';
import { UpdateRatingsComponent } from './tech/update-ratings/update-ratings.component';
import { UpdateStatusComponent } from './tech/update-status/update-status.component';
import { AddLeaveComponent } from './tech/add-leave/add-leave.component';
import { TechComponent } from './tech/tech.component';
import { GetInterviewByTypeComponent } from './tech/get-interview-by-type/get-interview-by-type.component';
import { TechService } from './tech.service';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    GetEligibleCandidateComponent,
    GetAllInterviewSchedulesComponent,
    AdminComponent,
    GetAllLeavesComponent,
    ScheduleInterviewComponent,
    UpdateRatingsComponent,
    UpdateStatusComponent,
    AddLeaveComponent,
    TechComponent,
    GetInterviewByTypeComponent,
    LoginComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [AdminService, TechService],
  bootstrap: [AppComponent]
})
export class AppModule { }
