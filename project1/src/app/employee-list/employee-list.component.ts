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

  employees: Employee[];
  p:number = 1;
  minS: number = 0;
  maxS: number = 99999;
  offset: number = 0;
  limit: number = 30;

  constructor(private employeeService: EmployeeService,private http:HttpClient, private route: ActivatedRoute, private router:Router) { }

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


}