import { BookingService } from './../services/booking.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Reservation } from '../models/reservation.model';

@Component({
  selector: 'app-user-flight-comfirmation',
  templateUrl: './user-flight-comfirmation.component.html',
  styleUrls: ['./user-flight-comfirmation.component.css']
})
export class UserFlightComfirmationComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute, private bookingService: BookingService,
    private router: Router) { }

  reservationId: string;

  reservation: Reservation;
  passportNum: string;

  isCollapsed: boolean;

  ngOnInit() {
    this.isCollapsed = true;
    this.activatedRoute.paramMap.subscribe(params => {
      this.reservationId = params.get('reservationId');
      this.bookingService.getReservationById(this.reservationId).subscribe(data => {
        this.reservation = data;
      });
    });
  }

  accept() {
    if (this.passportNum) {
      this.reservation.passportNum = this.passportNum;
      this.bookingService.acceptFlight(this.reservation).subscribe(data => {
        alert('Uspesno prihvacen let');
        this.router.navigate(['search']);
      });
    }
  }

  decline() {
      this.bookingService.refuseFlight(this.reservation).subscribe(data => {
        alert('Uspesno otkazan let');
        this.router.navigate(['search']);
      });
  }

}
