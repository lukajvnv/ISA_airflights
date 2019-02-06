import { BookingService } from './../services/booking.service';
import { Component, OnInit, Input } from '@angular/core';
import { User } from '../models/user.model';

@Component({
  selector: 'app-user-friend-request',
  templateUrl: './user-friend-request.component.html',
  styleUrls: ['./user-friend-request.component.css']
})
export class UserFriendRequestComponent implements OnInit {

  @Input()
  currentUser: User;

  zahtevi: User[] = [];

  constructor(private bookingService: BookingService) { }

  ngOnInit() {
    /*this.zahtevi.push(new User('Luka', 'Jovanovic', '', '', 0, ''));
    this.zahtevi.push(new User('Mladen', 'Jovanovic', '', '', 0, ''));
    this.zahtevi.push(new User('Luka', 'Ivanovic', '', '', 0, ''));
    this.zahtevi.push(new User('Luka', 'Jokic', '', '', 0, ''));
    this.zahtevi.push(new User('Nenad', 'Hajduk', '', '', 0, ''));*/
    this.currentUser = new User('Luka', 'Jovanovic', '', '', 0, 'pass2');


    this.bookingService.getFriendRequets(this.currentUser).subscribe(data => {
      this.zahtevi = data;
    });
  }

  prihvatiPrijatelja(prijatelj: User) {
    this.bookingService.acceptFriend(this.currentUser.username, prijatelj).subscribe(data => {
      alert('Uspesno uspostavljeno prijateljsvo sa:' + prijatelj.firstName);
      this.zahtevi = data;
    },
    err => {
      alert('Selektovana osoba vec postoji u prijateljima');
    });
  }

  odbijPrijatelja(prijatelj: User) {
    this.bookingService.refuseFriend(this.currentUser.username, prijatelj).subscribe(data => {
      alert('Osoba kojoj ste odbili prijateljstvo:' + prijatelj.firstName);
      this.zahtevi = data;
    },
    err => {
      alert('Greska prilikom odbijanja prijateljstva');
    });
  }

}
