import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { GetEligibleCandidateComponent } from './admin/get-eligible-candidate-component/get-eligible-candidate-component.component';
import { GetAllInterviewSchedulesComponent } from './admin/get-all-interview-schedules/get-all-interview-schedules.component';
import { GetAllLeavesComponent } from './admin/get-all-leaves/get-all-leaves.component';
import { GetInterviewByTypeComponent } from './tech/get-interview-by-type/get-interview-by-type.component';
import { AddLeaveComponent } from './tech/add-leave/add-leave.component';
import { LoginComponent } from './login/login.component';


const routes: Routes = [
  {path:`getallcandidates`,component:GetEligibleCandidateComponent},
  {path:`getAllInterviewSchedules`, component:GetAllInterviewSchedulesComponent},
  {path:`getAllLeaves`, component:GetAllLeavesComponent},
  {path:`getInterviewByType`, component:GetInterviewByTypeComponent},
  {path:`addLeave`, component: AddLeaveComponent},
  {path:`login`, component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
