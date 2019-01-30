import { Flight } from './../../models/flight.model';
import { FlightService } from './../../services/flight.service';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from './../../models/user.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-friend-to-flight',
  templateUrl: './add-friend-to-flight.component.html',
  styleUrls: ['./add-friend-to-flight.component.css']
})
export class AddFriendToFlightComponent implements OnInit {

  korisnici: User[] = [];
  filtriraniKorisnici: User[] = [];
  currentFlight: Flight;

  constructor(private activatedRoute: ActivatedRoute, private router: Router,
    private flightService: FlightService) { }

  ngOnInit() {
    this.korisnici.push(new User('Luka', 'Jovanovic', '', '', ''));
    this.korisnici.push(new User('Mladen', 'Jovanovic', '', '', ''));
    this.korisnici.push(new User('Luka', 'Ivanovic', '', '', ''));
    this.korisnici.push(new User('Luka', 'Jokic', '', '', ''));
    this.korisnici.push(new User('Nenad', 'Hajduk', '', '', ''));
    this.filtriraniKorisnici = this.korisnici;
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
      this.filtriraniKorisnici.filter( k => k.ime.toLowerCase().includes(ime.toLowerCase())) :
      this.korisnici;
  }

  filterPrezime(prezime: string) {
    this.filtriraniKorisnici = (prezime) ?
    this.filtriraniKorisnici.filter( k => k.prezime.toLowerCase().includes(prezime.toLowerCase())) :
    this.korisnici;
  }

  enterPassengerDetails() {
    /* if (this.brojeviZeljenihSedista.length !== this.searchFlightObject.personNum) {
      alert('Selektujte odgovarajuci broj sedista');
    } else {
      console.log('usao u rezervisi');
      this.router.navigate(['/flight/addFriendToFlight',  this.currentFlight.flightId]);
    } */
    this.router.navigate(['/flight/addPassengerDetails',  this.currentFlight.flightId]);

  }
}
