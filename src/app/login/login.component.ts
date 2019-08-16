import { Component, OnInit } from '@angular/core';
import { LoginSignupService } from '../login-signup.service';

import { first } from 'rxjs/operators';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { Candidate } from '../candidate';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  
  email:string;
  cpassword :string;
  candidate: Candidate;
  returnUrl: string;
 isLoadingResults = true;
  
  ngOnInit() {
  }
  constructor(private loginSignupServiceService: LoginSignupService, private route: ActivatedRoute, private router: Router,
  ) {

   }
   
   login():void {
     this.loginSignupServiceService.login(this.email,this.cpassword)
    .subscribe((data: any) => {
      this.candidate = data;
      console.log(this.candidate);
      this.isLoadingResults = false;
      
    });
console.log();  
   }
}


