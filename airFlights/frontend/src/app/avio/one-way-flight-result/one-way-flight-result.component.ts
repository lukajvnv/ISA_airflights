import { Flight } from './../../models/flight.model';
import { Component, OnInit, Input } from '@angular/core';
import { SearchFlightParams } from './../../models/search-flight-params.model';

@Component({
  selector: 'app-one-way-flight-result',
  templateUrl: './one-way-flight-result.component.html',
  styleUrls: ['./one-way-flight-result.component.css']
})
export class OneWayFlightResultComponent implements OnInit {

  @Input()
  flight: Flight;
  flightClass;

  constructor(private searchFlightObject: SearchFlightParams) { }

  ngOnInit() {
    this.flightClass =  this.searchFlightObject.ticketClass;
  }

  renderFlightDuration(flight: Flight): string {
    const hour = Math.floor(flight.flightDuration);
    const decimal = flight.flightDuration - hour;
    const minutes = Math.round(decimal * 60);
    return hour + 'h '  + minutes + 'min';
  }

}
