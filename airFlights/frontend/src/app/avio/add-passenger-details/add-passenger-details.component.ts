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
    passengerName: new FormControl('', Validators.required),
    passengerLastName: new FormControl('', Validators.required),
    passengerAddress: new FormControl('', Validators.required),
    passengerTelephone: new FormControl('', Validators.required),
    passengerMail: new FormControl('', Validators.required),
    passengerPassportNum: new FormControl('', Validators.required)
  });

  seats: FlightSeat[] = [];

  constructor(private activatedRoute: ActivatedRoute, private flightService: FlightService,
    private searchFlightObject: SearchFlightParams, private bookingService: BookingService,
    private router: Router) { }

  ngOnInit() {
    this.seats = JSON.parse(sessionStorage.getItem('seats'));
    if (!this.seats || this.seats.length !== 1) {
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
    const user: User = new User('Luka', 'Jovanovic', 'Drage Spasic 7', 'lukajvnv@gmail.com', 644498628, 'pass1');
    this.currentUser = user;
    this.passengerName.setValue(user.firstName);
    this.passengerLastName.setValue(user.lastName);
    this.passengerAddress.setValue(user.city);
    this.passengerMail.setValue(user.email);
    this.passengerTelephone.setValue(user.phone_number);
    // this.passengerName.setValue(user.ime);
  }

  potvrdi() {
    if (!this.passengerForm.valid) {
      alert('Unesite broj pasosa');
      return;
    } else {
      console.log('validno');
      // this.passengerName.disable();
      /*this.passengerForm = new FormGroup({
        passengerName: new FormControl({value: 'a', disabled: true}, Validators.required),
        passengerLastName: new FormControl('b', Validators.required),
        passengerAddress: new FormControl('c', Validators.required),
        passengerTelephone: new FormControl('d', Validators.required),
        passengerMail: new FormControl('f', Validators.required),
        passengerPassportNum: new FormControl('g', Validators.required)
      });*/

      const seat = this.seats[0];
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
