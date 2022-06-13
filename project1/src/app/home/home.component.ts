import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  http: any;

  constructor() { }

  ngOnInit(): void {
  }

  filename='';

  onFileSelect(event:any){
    const file:File = event.target.files[0];

    if(file){
      this.filename= file.name;

      const formData= new FormData();
      formData.append("file",file);
      const upload$= this.http.post("http://localhost:8002/api/csv/upload", formData);
      upload$.subscribe((responseData: any)=>{
        console.log(responseData)
      })
    }
  }

}
