import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  constructor(private http:HttpClient) { }

  ngOnInit(): void {
  }

  filename='';

  onFileSelected(event:any){
    const file:File = event.target.files[0];

    if(file){
      this.filename= file.name;

      const formData= new FormData();
      formData.append("file",file);
      const upload$= this.http.post("http://localhost:8002/employees/upload", formData);
      upload$.subscribe((responseData: any)=>{
        console.log(responseData)
      })
    }
  }

}


