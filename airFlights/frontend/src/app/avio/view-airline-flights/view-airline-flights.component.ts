import { Flight } from './../../models/flight.model';
import { AirlineService } from './../../services/airline.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from 'src/app/models/user.model';

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

  currentUser: User;

  ngOnInit() {
    this.isRightAdmin = true;

    this.currentUser = new User('Luka', 'Airline', 'lukajvnv@gmail.com', 'Novi Sad', 0, 'airSerbia');


    this.activatedRoute.paramMap.subscribe(params => {
      this.airlineId = params.get('airlineId');
      this.airlineService.getAirlineFlights(this.airlineId).subscribe(data => {
        this.airlineFlights = data;
      });
      this.airlineService.getAirline(this.airlineId).subscribe(data => {
        const currentAirline = data;
        if (currentAirline.adminForThisAirline.username === this.currentUser.username) {
          this.isRightAdmin = true;
        }
      });
    });
  }

  pogledajDetalje( flight: Flight) {
    this.selectedFlight = flight;
  }

  noviLet() {
    this.router.navigate(['airline/newFlight', this.airlineId]);
  }

  konfigurisi() {
    this.router.navigate(['airline/flight/configure/', this.selectedFlight.flightId]);
  }

  izmeniLet() {
    if (this.selectedFlight) {
      this.router.navigate(['airline/newFlight/update', this.airlineId, this.selectedFlight.flightId]);
    }
  }

}
