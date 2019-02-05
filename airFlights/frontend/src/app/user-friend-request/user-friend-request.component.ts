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

  constructor() { }

  ngOnInit() {
    this.zahtevi.push(new User('Luka', 'Jovanovic', '', '', 0, ''));
    this.zahtevi.push(new User('Mladen', 'Jovanovic', '', '', 0, ''));
    this.zahtevi.push(new User('Luka', 'Ivanovic', '', '', 0, ''));
    this.zahtevi.push(new User('Luka', 'Jokic', '', '', 0, ''));
    this.zahtevi.push(new User('Nenad', 'Hajduk', '', '', 0, ''));
  }

}
