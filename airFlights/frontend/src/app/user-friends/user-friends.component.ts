import { Component, OnInit, Input } from '@angular/core';
import { User } from '../models/user.model';

@Component({
  selector: 'app-user-friends',
  templateUrl: './user-friends.component.html',
  styleUrls: ['./user-friends.component.css']
})
export class UserFriendsComponent implements OnInit {

  @Input()
  currentUser: User;

  prijatelji: User[] = [];
  filtriraniKorisnici: User[] = [];


  constructor(/*private activatedRoute: ActivatedRoute, private router: Router,
    private flightService: FlightService*/) { }

  ngOnInit() {
    this.prijatelji.push(new User('Luka', 'Jovanovic', '', '', ''));
    this.prijatelji.push(new User('Mladen', 'Jovanovic', '', '', ''));
    this.prijatelji.push(new User('Luka', 'Ivanovic', '', '', ''));
    this.prijatelji.push(new User('Luka', 'Jokic', '', '', ''));
    this.prijatelji.push(new User('Nenad', 'Hajduk', '', '', ''));
    this.filtriraniKorisnici = this.prijatelji;

  }

  submit() {

  }

  filterIme(ime: string) {
    this.filtriraniKorisnici = (ime) ?
      this.filtriraniKorisnici.filter( k => k.firstName.toLowerCase().includes(ime.toLowerCase())) :
      this.prijatelji;
  }

  filterPrezime(prezime: string) {
    this.filtriraniKorisnici = (prezime) ?
    this.filtriraniKorisnici.filter( k => k.lastName.toLowerCase().includes(prezime.toLowerCase())) :
    this.prijatelji;
  }

  dodajPrijatelja(prijatelj: User) {

  }

  ukloniPrijatelja(prijatelj: User) {

  }

}
