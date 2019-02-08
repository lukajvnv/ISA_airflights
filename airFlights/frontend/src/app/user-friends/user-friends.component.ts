import { FriendShip } from './../models/friendship.model';
import { BookingService } from './../services/booking.service';
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


  constructor(private bookingService: BookingService) { }

  ngOnInit() {
    // this.currentUser = new User('pass1');

    /*this.prijatelji.push(new User('Luka', 'Jovanovic', '', '', 0, 'pass1'));
    this.prijatelji.push(new User('Mladen', 'Jovanovic', '', '', 0, ''));
    this.prijatelji.push(new User('Luka', 'Ivanovic', '', '', 0, ''));
    this.prijatelji.push(new User('Luka', 'Jokic', '', '', 0, ''));
    this.prijatelji.push(new User('Nenad', 'Hajduk', '', '', 0, ''));
    this.filtriraniKorisnici = this.prijatelji;*/

    this.bookingService.getFriends(this.currentUser).subscribe(data => {
      this.prijatelji = data;
    });
    this.bookingService.getAllUsers().subscribe(data => {
      this.filtriraniKorisnici = data;
    });

  }

  submit() {

  }

  sortIme() {
    console.log('ime');
    this.prijatelji.sort(this.sortByName);
  }

  sortPrezime() {
    console.log('prezime');
    this.prijatelji.sort(this.sortByLastName);
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
    if (this.currentUser.username === prijatelj.username) {
      return;
    }
    this.bookingService.addFriend(this.currentUser.username, prijatelj).subscribe(() => {
      alert('Osoba kojoj ste uspesno poslali zahtev za prijateljstvo:' + prijatelj.firstName);
    },
    err => {
      alert('Selektovana osoba vec postoji u prijateljima');
    });
  }

  ukloniPrijatelja(prijatelj: User) {
    this.bookingService.addFriend(this.currentUser.username, prijatelj).subscribe(data => {
      alert(prijatelj.firstName + 'uspesno uklonjen iz prijatelja');
      this.prijatelji = data;
    },
    err => {
      alert('Greska prilikom uklanjanja prijatelja');
    });
  }

  sortByName(user1: User, user2: User) {
    if (user1.firstName > user2.lastName) {
      return 1;
    }
    if (user1.firstName < user2.lastName) {
      return -1;
    }
    return 0;
  }

  sortByLastName(user1: User, user2: User) {
    if (user1.lastName > user2.lastName) {
      return 1;
    }
    if (user1.lastName < user2.lastName) {
      return -1;
    }
    return 0;
  }

}
