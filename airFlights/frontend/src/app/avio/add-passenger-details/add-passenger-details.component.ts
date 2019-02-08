import { BookingService } from './../../services/booking.service';
import { FlightTicket } from './../../models/flight-ticket';
import { FlightSeat } from './../../models/seat.model';
import { SearchFlightParams } from './../../models/search-flight-params.model';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Flight } from './../../models/flight.model';
import { FlightService } from './../../services/flight.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { Reservation } from 'src/app/models/reservation.model';

@Component({
  selector: 'app-add-passenger-details',
  templateUrl: './add-passenger-details.component.html',
  styleUrls: ['./add-passenger-details.component.css']
})
export class AddPassengerDetailsComponent implements OnInit {

  currentFlight: Flight;
  currentUser: User;

  passengerForm = new FormGroup({
    passengerName: new FormControl(''),
    passengerLastName: new FormControl(''),
    passengerAddress: new FormControl(''),
    passengerTelephone: new FormControl(''),
    passengerMail: new FormControl(''),
    passengerPassportNum: new FormControl('', Validators.required)
  });

  seats: FlightSeat[] = [];

  constructor(private activatedRoute: ActivatedRoute, private flightService: FlightService,
    private searchFlightObject: SearchFlightParams, private bookingService: BookingService,
    private router: Router) { }

  ngOnInit() {
    this.seats = JSON.parse(sessionStorage.getItem('seats'));
    if (!this.seats || this.seats.length > 1) {
      console.log('greska');
      return;
    }
    if (!this.searchFlightObject.flightType) {
      this.searchFlightObject = JSON.parse(sessionStorage.getItem('searchFilterObject'));
    }
    this.activatedRoute.paramMap.subscribe(params => {
      const flightId: string = params.get('flightId');
      this.flightService.getFlight(flightId).subscribe(data => {
        this.currentFlight = data;
      });
    });
    const username: string = localStorage.getItem('currentUser');
    if (username) {
      // this.currentUser =  new User(username);
      this.bookingService.getUser(username).subscribe(data => {
        this.currentUser = data;
        this.passengerName.setValue(this.currentUser.firstName);
        this.passengerLastName.setValue(this.currentUser.lastName);
        this.passengerAddress.setValue(this.currentUser.city);
        this.passengerMail.setValue(this.currentUser.email);
        this.passengerTelephone.setValue(this.currentUser.phone_number);
      });
    }
    /* this.passengerName.setValue(this.currentUser.firstName);
    this.passengerLastName.setValue(this.currentUser.lastName);
    this.passengerAddress.setValue(this.currentUser.city);
    this.passengerMail.setValue(this.currentUser.email);
    this.passengerTelephone.setValue(this.currentUser.phone_number); */
  }

  potvrdi() {
    if (!this.passengerForm.valid) {
      alert('Unesite broj pasosa');
      return;
    } else {
      console.log('validno');

      const seat: FlightSeat = this.seats[0];
      const ticket = new FlightTicket(this.currentFlight, seat, this.searchFlightObject.ticketClass);
      const passport = this.passengerPassportNum.value;
      const reservation = new Reservation(ticket, this.currentUser, passport);

      this.bookingService.makeReservation(reservation).subscribe( () => {
        alert('Uspesno uradjeno rezervacija');
        this.router.navigate(['']);
      });
    }
  }

  get passengerName() {
    return this.passengerForm.get('passengerName');
  }
  get passengerLastName() {
    return this.passengerForm.get('passengerLastName');
  }
  get passengerAddress() {
    return this.passengerForm.get('passengerAddress');
  }
  get passengerTelephone() {
    return this.passengerForm.get('passengerTelephone');
  }
  get passengerMail() {
    return this.passengerForm.get('passengerMail');
  }
  get passengerPassportNum() {
    return this.passengerForm.get('passengerPassportNum');
  }
}
