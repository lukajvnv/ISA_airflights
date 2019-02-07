import { BookingService } from './../services/booking.service';
import { Component, OnInit, Input } from '@angular/core';
import { User } from '../models/user.model';
import { Reservation } from '../models/reservation.model';

@Component({
  selector: 'app-user-reservations',
  templateUrl: './user-reservations.component.html',
  styleUrls: ['./user-reservations.component.css']
})
export class UserReservationsComponent implements OnInit {

  @Input()
  currentUser: User;

  reservations: Reservation[] = [];

  @Input()
  selectedReservation: Reservation;

  isCollapsed: boolean;
  mark: number;

  constructor(private bookingService: BookingService) { }

  ngOnInit() {
    this.isCollapsed = true;
    this.bookingService.getReservations(this.currentUser).subscribe(data => {
      this.reservations = data;
    });
  }

  detail( r: Reservation) {
    this.selectedReservation = r;
  }

  evaluate () {
    /*if (this.selectedReservation && this.mark) {
      this.selectedReservation.passportNum = this.passportNum;
      this.bookingService.acceptFlight(this.selectedReservation).subscribe(data => {
        this.invitation = data;
        this.selectedReservation = undefined;
      });
    }*/
  }

}
