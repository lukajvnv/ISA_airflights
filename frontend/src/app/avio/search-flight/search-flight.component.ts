import { FlightService } from './../../services/flight.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, NgForm} from '@angular/forms';
import { NgbDatepicker } from '@ng-bootstrap/ng-bootstrap';
import { Observable, from } from 'rxjs';
import { Destination } from 'src/app/models/destination.model';
import { SearchFlightParams } from 'src/app/models/search-flight-params.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-flight',
  templateUrl: './search-flight.component.html',
  styleUrls: ['./search-flight.component.css']
})
export class SearchFlightComponent implements OnInit {

  persons: number;
  luggage: number;
  departureDate: Date;
  arrivalDate: Date;
  type;
  class;
  private p: Observable<any>;
   destinations: Destination[];
   departureDestination: Destination;
   arrivalDestination: Destination;
   isArrivalDateDisabled: boolean;
   flightTypes = [{id: 'ONE_WAY', name: 'One-way'}, {id: 'ROUND_TRIP', name: 'Round-trip'}, {id: 'MULTI_CITY', name: 'Multi-city'}];
   flightClasses = [{id: 'ECONOMY', name: 'Economy'}, {id: 'BUSINESS', name: 'Business'}, {id: 'FIRST', name: 'First'}];


  constructor(private flightService: FlightService, private router: Router, private searchFlightObject: SearchFlightParams) {}

  ngOnInit() {
     this.flightService.getDestinations().subscribe(data => {this.destinations = data;
     });
     this.isArrivalDateDisabled = true;
     this.type = this.flightTypes[0].id;
     this.class = this.flightClasses[0].id;
     this.persons = 1;
  }

  fligthTypeChanged() {
    console.log(this.isArrivalDateDisabled);
    console.log(this.type);

    (this.type === this.flightTypes[0].id) ? this.isArrivalDateDisabled = true : this.isArrivalDateDisabled = false;
}

test(f) {// console.log(this.departureDate + this.type); const ps = this.destinations;
  console.log(this.destinations);
}
  submit(f: NgForm) {
    console.log(f);
    if (f.form.status === 'INVALID') {
      alert('Molimo popunite obavezne paremetre[NEADEKVATAN UNOS]');
      return;
    }
    // provera da li je broj i ako jeste da li je int
    /* if (!(Number(this.persons) === this.persons && this.persons % 1 !== 0)) {
      console.log(this.persons);
      alert('Molimo unesite BROJ osoba');
    } */

    console.log(this.arrivalDate);
    if (isNaN(Number(this.luggage)) && this.luggage) {
      console.log(this.luggage);
      alert('Uneta količina prtljaga nevalidna');
      return;
    }

    if ( this.type !== 'ONE_WAY' && !this.arrivalDate) {
      alert('Molimo unesite datum dolaska');
      return;
    }

    this.type = this.type === 'MULTI_CITY' ? 'ONE_WAY' : this.type;

      // const searchFlightParams: SearchFlightParams = new SearchFlightParams();
    this.searchFlightObject.init(this.departureDate, this.arrivalDate, this.type, this.class,
    this.persons, this.luggage, this.departureDestination, this.arrivalDestination);
    console.log(this.searchFlightObject);

    sessionStorage.setItem('searchFilterObject', JSON.stringify(this.searchFlightObject));
    this.router.navigate(['/viewFlightResults']);

    /* this.flightService.searchFlights(searchFlightParams).subscribe(data => {
      console.log('prosao');
      console.log(data);
    }); */

  }


}
