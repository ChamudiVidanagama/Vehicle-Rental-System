import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatButtonModule, MatMenuModule } from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { RouterModule } from '@angular/router';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { EnquiryComponent } from './enquiry/enquiry.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { CarComponent } from './car/car.component';
import { MotorbikeComponent } from './motorbike/motorbike.component';
import { VehicleComponent } from './vehicle/vehicle.component';
import { VehicleService } from './Services/vehicle.service';
import { BookingComponent } from './booking/booking.component';
import { FilterPipe } from './filter.pipe';
import { BookingService } from './Services/booking.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    EnquiryComponent,
    NavBarComponent,
    CarComponent,
    MotorbikeComponent,
    VehicleComponent,
    BookingComponent,
    FilterPipe
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatMenuModule, MatButtonModule, 
    FormsModule,
    ReactiveFormsModule,
    RouterModule
  ],
  providers: [VehicleService, BookingService],
  bootstrap: [AppComponent]
})
export class AppModule { }
