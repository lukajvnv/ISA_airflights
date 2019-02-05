import { FlightSeat } from './../../models/seat.model';
import { Location } from '@angular/common';
import { Flight } from './../../models/flight.model';
import { FlightService } from './../../services/flight.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit, Input } from '@angular/core';
import { SearchFlightParams } from 'src/app/models/search-flight-params.model';

@Component({
  selector: 'app-book-flight',
  templateUrl: './book-flight.component.html',
  styleUrls: ['./book-flight.component.css']
})
export class BookFlightComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute, private flightService: FlightService,
    private searchFlightObject: SearchFlightParams, private router: Router, private location: Location) { }

  @Input()
  currentFlight: Flight;

  // svaSedistaAviona: number[] = [];
  // brojeviZeljenihSedista: number[] = [];
  selectDiv: boolean[] = [];

  flightSeats: FlightSeat[] = [];
  zeljenaSedista: FlightSeat[] = [];


  ngOnInit() {
    if (!this.searchFlightObject.flightType) {
      this.searchFlightObject = JSON.parse(sessionStorage.getItem('searchFilterObject'));
    }
    this.activatedRoute.paramMap.subscribe(params => {
      const flightId: string = params.get('flightId');
      this.flightService.getFlight(flightId).subscribe(data => {
        this.currentFlight = data;
        console.log('booking:');
        console.log(this.currentFlight);
        console.log(this.searchFlightObject);
        /*this.selectDiv = new Array<boolean>(this.currentFlight.numberOfSeats);
        this.svaSedistaAviona = new Array<number>(this.currentFlight.numberOfSeats);
        for (let i = 0; i < this.selectDiv.length; i++) {
          this.selectDiv[i] = false;
        }*/
        /*this.selectDiv.forEach(function(value) {
          this.value = false;
        });*/

      });
      this.flightService.getAllSeats(flightId).subscribe(data => {
        this.flightSeats = data;
        console.log('booking: seats');
        this.selectDiv = new Array<boolean>(this.flightSeats.length);
        // this.svaSedistaAviona = new Array<number>(this.flightSeats.length);
        for (let i = 0; i < this.selectDiv.length; i++) {
          this.selectDiv[i] = false;
        }
      });
    });
  }

  /*arrayOne(): any[] {
    return new Array(this.currentFlight.numberOfSeats);
  }*/

  selektuj(index: number, seat: FlightSeat) {
    console.log('usao u selektuj');

    if (this.selectDiv[index]) {
      const i = this.zeljenaSedista.indexOf(seat);
      this.zeljenaSedista.splice(i, 1);
    } else {
      this.zeljenaSedista.push(seat);
    }
    this.selectDiv[index] = !this.selectDiv[index];
  }

  rezervisi() {
    if (this.zeljenaSedista.length !== this.searchFlightObject.personNum) {
      alert('Selektujte odgovarajuci broj sedista');
    } else {
      console.log('usao u rezervisi');
      sessionStorage.setItem('seats', JSON.stringify(this.zeljenaSedista));
      if (this.searchFlightObject.personNum > 1) {
        this.router.navigate(['/flight/addFriendToFlight',  this.currentFlight.flightId]);
      } else {
        this.router.navigate(['/flight/addPassengerDetails',  this.currentFlight.flightId]);
      }
    }
  }

  backClick() {
    // this.router.navigate(['../viewFlightResults'], { relativeTo: this.activatedRoute });
    this.location.back();
 }

  /*getDestinationsa(): any {
    this.flightService.getDestinations().subscribe(data => data.pipe(x => x.filter(ddestinationId)));
    return this.flightService.getDestinations().pipe(map(x => x.filter(dest => dest.destinationId === 5)));
  }*/



}
