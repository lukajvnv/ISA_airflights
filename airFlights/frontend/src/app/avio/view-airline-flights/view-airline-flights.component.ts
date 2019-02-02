import { Flight } from './../../models/flight.model';
import { AirlineService } from './../../services/airline.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-airline-flights',
  templateUrl: './view-airline-flights.component.html',
  styleUrls: ['./view-airline-flights.component.css']
})
export class ViewAirlineFlightsComponent implements OnInit {

  constructor(private airlineService: AirlineService, private router: Router, private activatedRoute: ActivatedRoute) { }

  airlineFlights: Flight[] = [];
  airlineId: string;

  isRightAdmin: boolean;

  selectedFlight: Flight;

  ngOnInit() {
    this.isRightAdmin = true;
    this.activatedRoute.paramMap.subscribe(params => {
      this.airlineId = params.get('airlineId');
      this.airlineService.getAirlineFlights(this.airlineId).subscribe(data => {
        this.airlineFlights = data;
      });
    });
  }

  pogledajDetalje( flight: Flight) {
    this.selectedFlight = flight;
  }

  noviLet() {
    this.router.navigate(['airline/newFlight', this.airlineId]);
  }

  izmeniLet() {
    if (this.selectedFlight) {
      this.router.navigate(['airline/newFlight/update', this.airlineId, this.selectedFlight.flightId]);
    }
  }

}
