import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { LoginSignupServiceService } from 'login-signup-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Employer } from '../employer';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  serialNumber: number;
  userType: string;
  loginStatus: string;
  password: string;
  employer: Employer;
  user: User;
  id: string;
  returnUrl: string;
  isLoadingResults = true;

  ngOnInit() {
  }
  constructor(private loginSignupServiceService: LoginSignupServiceService, private route: ActivatedRoute, private router: Router,
  ) {

  }

  login(): void {
    this.loginSignupServiceService.login(this.id, this.password)
      .subscribe((data: any) => {
        this.user = data;
        console.log(this.user);
        this.isLoadingResults = false;

      });
    console.log();
  }
}

