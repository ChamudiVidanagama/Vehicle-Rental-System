import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { EnquiryComponent } from './enquiry/enquiry.component';
import { CarComponent } from './car/car.component';
import { MotorbikeComponent } from './motorbike/motorbike.component';
import { VehicleComponent } from './vehicle/vehicle.component';
import { BookingComponent } from './booking/booking.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'enquiry', component: EnquiryComponent },
  { path: 'vehicle', component: VehicleComponent },
  { path: 'car', component: CarComponent },
  { path: 'motorbike', component: MotorbikeComponent },
  { path: 'booking/:plateNo', component: VehicleComponent },
  { path: 'booking', component: BookingComponent },
  { path: 'booking/plateNo', component: BookingComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
