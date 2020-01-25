import { Component, OnInit } from '@angular/core';
import { VehicleService } from '../Services/vehicle.service';
import { Vehicle } from '../Interfaces/vehicle';
import {BookingComponent} from '../booking/booking.component'
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  providers:[BookingComponent],
  selector: 'app-vehicle',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.css']
})
export class VehicleComponent implements OnInit {

  public vehicles = [];

  public vehicle: Vehicle;

  searchText: string;

  constructor(private _vehicleService: VehicleService, private _router:Router, private _route: ActivatedRoute) {
    
    this.vehicles = this._route.snapshot.data['vehicles'];

   }
  
  ngOnInit() {
    this._vehicleService.getVehicleList()
    .subscribe(data => this.vehicles = data);
  }




  // getDetails(plateNo : string){
  //   // this.router.navigate(['vehicle', plateNo]); (1)
  // }

}
