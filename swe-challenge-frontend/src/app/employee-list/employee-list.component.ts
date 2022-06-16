import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  private apiUrl:string = "http://localhost:8002/employees/"; 
  employees: Employee[] = [];
  p:number = 1;
  minS: number = 0;
  maxS: number = 99999;
  offset: number = 0;
  limit: number = 6;

  constructor(private employeeService: EmployeeService,
              private http:HttpClient, 
              private route: ActivatedRoute, 
              private router:Router) {
  }

  ngOnInit(): void {
    this.getEmployees();
  }

  private getEmployees(){
    this.employeeService.getEmployeesList().subscribe(data => {
      this.employees = data;
    });
  }

  key ='id';
  reverse:boolean=false;
  sort(key: string){
    this.key=key;
    this.reverse = !this.reverse;
  }

  valChange() {
    this.router.navigate(['/employees'],{queryParams: {minSalary:this.minS, maxSalary:this.maxS, offset:this.offset, limit:this.limit}});
    this.http.get<Employee[]>(this.apiUrl+this.minS+"/"+this.maxS+"/"+this.offset+"/"+this.limit)
    .subscribe(data=>{
      if (data === null){
        this.employees=[];
      } else {
        this.employees=data.slice(this.offset,this.limit);
      }
    });
  }
 
  employeeDetails(id: string){
    this.router.navigate(['employee-details', id]);
  }

  updateEmployee(id: string){
    this.router.navigate(['update-employee', id]);
  }

  deleteEmployee(id: string){
    this.employeeService.deleteEmployee(id).subscribe( data => {
      console.log(data);
      this.getEmployees();
    })

}
}