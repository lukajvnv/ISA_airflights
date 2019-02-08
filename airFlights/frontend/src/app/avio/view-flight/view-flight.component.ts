import { Flight } from './../../models/flight.model';
import { FlightService } from './../../services/flight.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit, Input } from '@angular/core';
import { Observable, combineLatest } from 'rxjs';

import { Location } from '@angular/common';

@Component({
  selector: 'app-view-flight',
  templateUrl: './view-flight.component.html',
  styleUrls: ['./view-flight.component.css']
})
export class ViewFlightComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute, private flightService: FlightService, private router: Router,
    private location: Location) { }

  @Input()
  currentFlight: Flight;

  loggedUser: boolean;

  ngOnInit() {
    this.loggedUser = true;
    this.activatedRoute.paramMap.subscribe(params => {
      const flightId: string = params.get('flightId');
      this.flightService.getFlight(flightId).subscribe(data => {
        this.currentFlight = data;
        console.log(this.currentFlight);
      });
    });
  }

  backClick() {
     // this.router.navigate(['../viewFlightResults'], { relativeTo: this.activatedRoute });
     this.location.back();
  }
}
