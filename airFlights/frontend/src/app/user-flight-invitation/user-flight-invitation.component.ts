import { BookingService } from './../services/booking.service';
import { Component, OnInit, Input } from '@angular/core';
import { User } from '../models/user.model';
import { Reservation } from '../models/reservation.model';

@Component({
  selector: 'app-user-flight-invitation',
  templateUrl: './user-flight-invitation.component.html',
  styleUrls: ['./user-flight-invitation.component.css']
})
export class UserFlightInvitationComponent implements OnInit {

  @Input()
  currentUser: User;

  invitation: Reservation[] = [];

  @Input()
  selectedReservation: Reservation;

  isCollapsed: boolean;
  passportNum: string;

  constructor(private bookingService: BookingService) { }

  ngOnInit() {
    this.isCollapsed = true;
    this.bookingService.getFlightInvitations(this.currentUser).subscribe(data => {
      console.log('ok');
      this.invitation = data;
    });
  }

  detail( r: Reservation) {
    this.selectedReservation = r;
  }

  accept() {
    if (this.selectedReservation && this.passportNum) {
      this.selectedReservation.passportNum = this.passportNum;
      this.bookingService.acceptFlight(this.selectedReservation).subscribe(data => {
        this.invitation = data;
        this.selectedReservation = undefined;
      });
    }
  }

  decline() {
    if (this.selectedReservation) {
      this.bookingService.refuseFlight(this.selectedReservation).subscribe(data => {
        this.invitation = data;
        this.selectedReservation = undefined;
      });
    }
  }

}
