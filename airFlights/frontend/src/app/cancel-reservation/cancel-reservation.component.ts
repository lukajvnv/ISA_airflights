import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CarService } from '../services/car.service';
import { CarReservation } from '../models/car-reservation.model';

@Component({
  selector: 'app-cancel-reservation',
  templateUrl: './cancel-reservation.component.html',
  styleUrls: ['./cancel-reservation.component.css']
})
export class CancelReservationComponent implements OnInit {

  constructor(private router: Router, private route: ActivatedRoute, private carService: CarService) { }

  carReservations: CarReservation[];

  ngOnInit() {
    /*this.carService.getAllCarReservations().subscribe(
      data => {
        this.carReservations = data;
      });*/
  }

}
