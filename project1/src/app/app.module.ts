import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { Ng2SearchPipeModule} from 'ng2-search-filter';
import { Ng2OrderModule} from 'ng2-order-pipe';
import { NgxPaginationModule} from 'ngx-pagination';
import { HomeComponent } from './home/home.component'
 

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    HomeComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    Ng2SearchPipeModule,
    Ng2OrderModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
