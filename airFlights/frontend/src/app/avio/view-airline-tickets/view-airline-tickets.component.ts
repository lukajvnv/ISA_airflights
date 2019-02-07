import { BookingService } from 'src/app/services/booking.service';
import { FlightTicket } from './../../models/flight-ticket';
import { AirlineService } from './../../services/airline.service';
import { Airline } from 'src/app/models/airline.model';
import { ActivatedRoute } from '@angular/router';
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
    private bookingService: BookingService) { }

  quickTickets: FlightTicket[] = [];

  @Input()
  selectedTicket: FlightTicket;

  currentUser: User;
  passportInfo: string;

  isCollapsed: boolean;

  airlineId: string;

  ngOnInit() {
    this.isCollapsed = true;
    this.currentUser = new User('Luka', 'Jovanovic', 'Novi SAd', 'lukajvnv@gmail.com', 45, 'pass1');
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

  makeReservation() {
    if (!this.passportInfo) {
      alert('Unesite podatke za pasos');
    }

    const reservation = new Reservation(this.selectedTicket, this.currentUser, this.passportInfo);
    this.airlineService.bookQuickTicket(reservation).subscribe(data => {
      alert('Uspesno uradjeno rezervacija');
      this.airlineService.getQuickTickets(this.airlineId).subscribe(d => {
        this.quickTickets = d;
      });
    });
  }

}
