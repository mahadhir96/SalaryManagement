import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL = "http://localhost:8002/api/csv/employees"

  constructor(private httpclient: HttpClient) { }

  getEmployeesList(): Observable<Employee[]>{
    return this.httpclient.get<Employee[]>(`${this.baseURL}`);
  }

  getEmployeeById(id: String): Observable<Employee>{
    return this.httpclient.get<Employee>(`${this.baseURL}/${id}`);
  }

  updateEmployee(id: String, employee: Employee): Observable<Object>{
    return this.httpclient.put(`${this.baseURL}/${id}`, employee);
  }

  deleteEmployee(id: String): Observable<Object>{
    return this.httpclient.delete(`${this.baseURL}/${id}`);
  }
}
