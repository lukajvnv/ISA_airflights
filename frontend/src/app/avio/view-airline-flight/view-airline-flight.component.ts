import { Location } from '@angular/common';
import { Component, OnInit, Input } from '@angular/core';
import { Flight } from 'src/app/models/flight.model';

@Component({
  selector: 'app-view-airline-flight',
  templateUrl: './view-airline-flight.component.html',
  styleUrls: ['./view-airline-flight.component.css']
})
export class ViewAirlineFlightComponent implements OnInit {

  @Input()
  currentFlight: Flight;

  constructor() { }

  ngOnInit() {
  }

}
