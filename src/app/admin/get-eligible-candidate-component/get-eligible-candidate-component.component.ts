import { Component} from '@angular/core';
import { AdminService } from '../../admin.service';
import { Candidate } from '../../candidate';
import { Router } from '@angular/router';



@Component({
  selector: 'app-get-eligible-candidate-component',
  templateUrl: './get-eligible-candidate-component.component.html',
  styleUrls: ['./get-eligible-candidate-component.component.css']
})
export class GetEligibleCandidateComponent   {
candidate : Candidate[];
  constructor(private adminService:AdminService ,private router: Router) {
    
    this.adminService.getAllcandidates().subscribe((data : any) => 
    {
      this.candidate = data;
      console.log(this.candidate);});
      
  }



   }

  

