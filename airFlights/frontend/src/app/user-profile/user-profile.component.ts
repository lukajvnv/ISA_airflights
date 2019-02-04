import { User } from './../models/user.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  constructor() { }


  activeTab = 'profile';
  currentUser: User;

  ngOnInit() {
    this.currentUser = new User('Luka', 'Jovanovic', 'Drage Spasic', 'lukajvnv@gmail.com', '064/449-86-28');
  }

}
