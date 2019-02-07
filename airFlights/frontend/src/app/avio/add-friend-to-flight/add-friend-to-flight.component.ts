import { FlightTicket } from './../../models/flight-ticket';
import { FlightSeat } from './../../models/seat.model';
import { BookingService } from './../../services/booking.service';
import { SearchFlightComponent } from './../search-flight/search-flight.component';
import { Flight } from './../../models/flight.model';
import { FlightService } from './../../services/flight.service';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from './../../models/user.model';
import { Component, OnInit } from '@angular/core';
import { SearchFlightParams } from 'src/app/models/search-flight-params.model';
import { Reservation } from 'src/app/models/reservation.model';

@Component({
  selector: 'app-add-friend-to-flight',
  templateUrl: './add-friend-to-flight.component.html',
  styleUrls: ['./add-friend-to-flight.component.css']
})
export class AddFriendToFlightComponent implements OnInit {

  korisnici: User[] = [];
  filtriraniKorisnici: User[] = [];
  currentFlight: Flight;

  currentUser: User;
  friendsToInvite: User[] = [];
  seats: FlightSeat[] = [];

  constructor(private activatedRoute: ActivatedRoute, private router: Router,
    private flightService: FlightService, private searchFlightObject: SearchFlightParams,
    private bookingService: BookingService) { }

  ngOnInit() {
    this.searchFlightObject = JSON.parse(sessionStorage.getItem('searchFilterObject'));

    this.currentUser = new User('Luka', 'Jovanovic', '', '', 0, 'pass1');

    /*this.korisnici.push(new User('Luka', 'Jovanovic', '', '', 0, ''));
    this.korisnici.push(new User('Mladen', 'Jovanovic', '', '', 0, ''));
    this.korisnici.push(new User('Luka', 'Ivanovic', '', '', 0, ''));
    this.korisnici.push(new User('Luka', 'Jokic', '', '', 0, ''));
    this.korisnici.push(new User('Nenad', 'Hajduk', '', '', 0, ''));*/
    this.bookingService.getFriends(this.currentUser).subscribe(data => {
      this.korisnici = data;
      this.filtriraniKorisnici = this.korisnici;
    });

    // this.filtriraniKorisnici = this.korisnici;
    this.activatedRoute.paramMap.subscribe(params => {
      const flightId: string = params.get('flightId');
      this.flightService.getFlight(flightId).subscribe(data => {
        this.currentFlight = data;
        /*console.log('adding people:');
        this.selectDiv = new Array<boolean>(this.currentFlight.numberOfSeats);
        this.svaSedistaAviona = new Array<number>(this.currentFlight.numberOfSeats);
        for (let i = 0; i < this.selectDiv.length; i++) {
          this.selectDiv[i] = false;
        }*/
      });
    });
  }

  submit() {

  }

  filterIme(ime: string) {
    this.filtriraniKorisnici = (ime) ?
      this.filtriraniKorisnici.filter( k => k.firstName.toLowerCase().includes(ime.toLowerCase())) :
      this.korisnici;
  }

  filterPrezime(prezime: string) {
    this.filtriraniKorisnici = (prezime) ?
    this.filtriraniKorisnici.filter( k => k.lastName.toLowerCase().includes(prezime.toLowerCase())) :
    this.korisnici;
  }

  dodajPrijateljaNaLet(korisnik: User) {
    this.friendsToInvite.push(korisnik);
    alert(korisnik.firstName + ' ce biti pozvan/-a na let');
  }

  enterPassengerDetails() {
    const personNum: number = +this.searchFlightObject.personNum;
    if (personNum !== this.friendsToInvite.length + 1) {
      alert('Broj selektovanih broja se ne poklapa sa brojem osoba na letu');
      return;
    }

    this.seats = JSON.parse(sessionStorage.getItem('seats'));
    if (!this.seats || this.seats.length !== personNum) {
      console.log('Greska: broj sedista neodgovarajuci');
      return;
    }

    let ticket: FlightTicket;
    let reservation: Reservation;
    const friendReservations: Reservation[] = [];
    let userToInvite: User;
    for (let i = 0; i < this.friendsToInvite.length; i++) {
      ticket = new FlightTicket(this.currentFlight, this.seats[i], this.searchFlightObject.ticketClass);
      ticket.ticketStatus = 'INVITED';
      userToInvite = this.friendsToInvite[i];
      reservation = new Reservation(ticket, userToInvite, '');
      friendReservations.push(reservation);
    }
    // const friendsRess: string = JSON.stringify(friendReservations);

    this.bookingService.inviteFriendsToFlight(this.currentUser, friendReservations).subscribe( () => {
      alert('Uspesno uradjeno rezervacija');
      const lastSeatInd: number = this.seats.length - 1;
      const seatForCurrentUser = this.seats[lastSeatInd];
      sessionStorage.setItem('seats', JSON.stringify(seatForCurrentUser));
      this.router.navigate(['/flight/addPassengerDetails',  this.currentFlight.flightId]);
    }, err => {
        alert('Greska prilikom pozivanja na let');
    });



  }
}
