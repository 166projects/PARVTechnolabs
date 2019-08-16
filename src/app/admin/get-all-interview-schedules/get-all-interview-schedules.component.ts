import { Component } from '@angular/core';
import { InterviewSchedule } from 'src/app/interview-schedule';
import { AdminService } from 'src/app/admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-all-interview-schedules',
  templateUrl: './get-all-interview-schedules.component.html',
  styleUrls: ['./get-all-interview-schedules.component.css']
})

export class GetAllInterviewSchedulesComponent {
  interviewSchedules : InterviewSchedule[];
  constructor(private adminService:AdminService ,private router: Router) {
    
    this.adminService.getAllInterviewSchedules().subscribe((data : any) => {
      this.interviewSchedules = data;
      console.log(this.interviewSchedules);

    });
      
  }

}
