import { BookingService } from './../services/booking.service';
import { User } from './../models/user.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  constructor(private bookingService: BookingService) { }


  activeTab = 'profile';
  currentUser: User;

  ngOnInit() {
    // this.currentUser = new User('pass1');
    const username: string = localStorage.getItem('currentUser');
    if (username) {
      // this.currentUser =  new User(username);
      this.bookingService.getUser(username).subscribe(data => {
        this.currentUser = data;
      });
    }
  }

}
