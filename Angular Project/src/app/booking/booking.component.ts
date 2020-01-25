import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Vehicle } from '../Interfaces/vehicle';
import { NgForm } from '@angular/forms';
import { BookingService } from '../Services/booking.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {
  private selectedVehiclePlateNo: number;

  @Input() vehicle:Vehicle;
 

  constructor(private _route:ActivatedRoute, private _router: Router, private BookingService: BookingService) { }

  ngOnInit() {
    this.selectedVehiclePlateNo = +this._route.snapshot.queryParamMap.get("plateNo");
    console.log(this.selectedVehiclePlateNo);
  }
  
  onSubmit(form: NgForm) {
      this.insertRecord(form);
  }

  insertRecord(form: NgForm) {
    this.BookingService.postBooking(form.value).subscribe(res => { });
  }

}
