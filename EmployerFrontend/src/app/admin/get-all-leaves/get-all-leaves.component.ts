import { Component } from '@angular/core';
import { Leaves } from 'src/app/leaves';
import { AdminService } from 'src/app/admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-all-leaves',
  templateUrl: './get-all-leaves.component.html',
  styleUrls: ['./get-all-leaves.component.css']
})
export class GetAllLeavesComponent {

  leaves : Leaves[];
  constructor(private adminService:AdminService ,private router: Router) {
    
    this.adminService.getAllLeaves().subscribe((data : any) => {
      this.leaves = data;
      console.log(this.leaves);

    });
      
  }

}
