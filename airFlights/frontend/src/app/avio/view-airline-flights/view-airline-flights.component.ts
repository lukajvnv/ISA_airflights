import { BookingService } from './../../services/booking.service';
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

  constructor(private airlineService: AirlineService, private router: Router, private activatedRoute: ActivatedRoute,
    private bookingService: BookingService) { }

  airlineFlights: Flight[] = [];
  airlineId: string;

  isRightAdmin: boolean;

  selectedFlight: Flight;

  currentUser: User;

  ngOnInit() {
    this.isRightAdmin = false;

    const username: string = localStorage.getItem('currentUser');
    if (username) {
      // this.currentUser =  new User(username);
      this.bookingService.getUser(username).subscribe(data => {
        this.currentUser = data;
      });
    }


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

  profilKompanije() {
    this.router.navigate(['airline', this.airlineId]);
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
