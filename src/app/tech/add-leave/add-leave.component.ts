import { Component, OnInit } from '@angular/core';

import { Leaves } from 'src/app/leaves';
import { TechService } from 'src/app/tech.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Employer } from 'src/app/employer';
import { DatePipe } from '@angular/common';
import { formatDate } from "@angular/common";


@Component({
  selector: 'app-add-leave',
  templateUrl: './add-leave.component.html',
  styleUrls: ['./add-leave.component.css'],
  providers: [DatePipe]
})
export class AddLeaveComponent implements OnInit {

  leave = new Leaves();
  employs: Employer[];
  emp_id: string;
  lDate: string;

  constructor(private techService: TechService, private route: ActivatedRoute, private router: Router,
 private datePipe: DatePipe) { }

  ngOnInit() { }

 

  addLeave(): void {
    const format = 'dd-MMM-yy';
   // formatDate(this.leave.leaveDate,'dd-MMM-yy');
const myDate = this.leave.leaveDate;
const locale = 'en-IN';
const formattedDate = formatDate(myDate, format, locale);
console.log('formatted date'+formattedDate);
//let pDate= Date.parse(formattedDate);
    //var datePipe = new DatePipe('en-IN');
    //console.log(pDate+' date format');
   // this.lDate = this.leave.leaveDate.toISOString().slice(0,8);
    // let llDate = this.datePipe.transform(this.leave.leaveDate, 'dd-MMM-yy');
    // let pDate=new Date(llDate);
    // console.log(pDate);
    this.leave = {

      'leaveId': this.leave.leaveId,
      'employer': {
        'employer_Id': this.emp_id,
        'name': 'rahul',
        'skills': 'FINANCE',
        'experience': 4,
        'designation': 'admin'
      },
      'leaveDate': this.leave.leaveDate,
      'reason': this.leave.reason,
      'leaveApproval': 'not approved'
    };
    console.log(this.leave);
    this.techService.addLeave(this.leave)
      .subscribe((data: any) => {
        this.leave = data;
        console.log(this.leave);

      });

  }
}

