import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vehicle } from '../Interfaces/vehicle';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  private getVehicleListUrl: string = "http://localhost:9090/getVehicleList";

  constructor(private http: HttpClient) { }

  getVehicleList(): Observable<Vehicle[]>{
    return this.http.get<Vehicle[]>(this.getVehicleListUrl);
  }

}
