import { BookingService } from 'src/app/services/booking.service';
import { FlightTicket } from './../../models/flight-ticket';
import { AirlineService } from './../../services/airline.service';
import { Airline } from 'src/app/models/airline.model';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit, Input } from '@angular/core';
import { Reservation } from 'src/app/models/reservation.model';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-view-airline-tickets',
  templateUrl: './view-airline-tickets.component.html',
  styleUrls: ['./view-airline-tickets.component.css']
})
export class ViewAirlineTicketsComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute, private airlineService: AirlineService,
    private bookingService: BookingService, private router: Router) { }

  quickTickets: FlightTicket[] = [];

  @Input()
  selectedTicket: FlightTicket;

  currentUser: User;
  passportInfo: string;

  isCollapsed: boolean;

  airlineId: string;

  loggedUser: boolean;

  ngOnInit() {
    this.isCollapsed = true;
    // this.loggedUser = true;
    // this.currentUser = new User('Luka', 'Jovanovic', 'Novi SAd', 'lukajvnv@gmail.com', 45, 'pass1');
    const username: string = localStorage.getItem('currentUser');
    if (username) {
      this.currentUser =  new User(username);
      this.loggedUser = true;
    }

    this.activatedRoute.paramMap.subscribe(params => {
      this.airlineId = params.get('airlineId');
      this.airlineService.getQuickTickets(this.airlineId).subscribe(data => {
        this.quickTickets = data;
      });

    });
  }

  detail( r: FlightTicket) {
    this.selectedTicket = r;
  }

  profilKompanije() {
    this.router.navigate(['airline', this.airlineId]);
  }

  makeReservation() {
    if (!this.passportInfo) {
      alert('Unesite podatke za pasos');
    }

    const reservation = new Reservation(this.selectedTicket, this.currentUser, this.passportInfo);
    this.airlineService.bookQuickTicket(reservation).subscribe(data => {
      alert('Uspesno uradjeno rezervacija');
      this.selectedTicket = undefined;
      this.isCollapsed = true;
      this.airlineService.getQuickTickets(this.airlineId).subscribe(d => {
        this.quickTickets = d;
      });
    });
  }

}
