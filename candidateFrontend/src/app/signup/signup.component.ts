import { Component, OnInit } from '@angular/core';
import { LoginSignupServiceService } from '../login-signup.service';

import { Router, ActivatedRoute } from '../../../node_modules/@angular/router';
import { Candidate } from '../candidate';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  candidate: Candidate;
  
 ngOnInit() {}

constructor(private loginSignupServiceService: LoginSignupServiceService, private route: ActivatedRoute, private router: Router,
) { }

 addCandidate():void {
   this.candidate= {
    'firstName': this.candidate.firstName,
    'lastName' : this.candidate.lastName,
    'email': this.candidate.email,
    'idProof' : this.candidate.idProof,
    'primarySkills': this.candidate.primarySkills,
    'secondarySkills': this.candidate.secondarySkills,
    'experience' : this.candidate.experience,
    'designation': this.candidate.designation,
    'noticePeriod': this.candidate.noticePeriod,
    'eligibility': this.candidate.eligibility,
    'password' : this.candidate.password
};

   this.loginSignupServiceService.addCandidate(this.candidate)
  .subscribe((data: any) => {
    this.candidate = data;
    console.log(this.candidate);
  });
console.log();  
 }
}

  
