import { Component, OnInit } from '@angular/core';
import { InterviewSchedule } from 'src/app/interview-schedule';
import { TechService } from 'src/app/tech.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-interview-by-type',
  templateUrl: './get-interview-by-type.component.html',
  styleUrls: ['./get-interview-by-type.component.css']
})
export class GetInterviewByTypeComponent {

  interviewSchedules : InterviewSchedule[];

  constructor(private techservice:TechService ,private router: Router) {
    
    this.techservice.getInterviewByType().subscribe((data : any) => {
      this.interviewSchedules = data;
      console.log(this.interviewSchedules);

    });
      
  }
  // getInterviewByType():void {
  //   this.techservice.getInterviewByType(this.interviewType)
  //   .subscribe((data: any) => {
  //    this.interviewSchedules = data;
  //    console.log(this.interviewSchedules);
     
  //  });

  //}
}
