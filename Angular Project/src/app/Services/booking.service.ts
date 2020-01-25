import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Booking } from './booking';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  formData = new Booking();

  booking : Booking[];
  
  readonly rootURL = "http://localhost:9090/saveBooking";

  constructor(private http : HttpClient) { }


  postBooking(formData: Booking){
    // console.log(formData);
    return this.http.post(this.rootURL,formData)
  }
}
