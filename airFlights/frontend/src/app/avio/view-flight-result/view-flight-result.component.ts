import { FlightReturn } from './../../models/flight-return.model';
import { DepTimeArrTimePipe } from './../../utils/dep-time-arr-time.pipe';
import { Flight } from './../../models/flight.model';
import { FormControl, MinLengthValidator } from '@angular/forms';
import { Airline } from './../../models/airline.model';
import { AirlineService } from './../../services/airline.service';
import { FlightService } from './../../services/flight.service';
import { SearchFlightParams } from './../../models/search-flight-params.model';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbTimeStruct } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-view-flight-result',
  templateUrl: './view-flight-result.component.html',
  styleUrls: ['./view-flight-result.component.css']
})
export class ViewFlightResultComponent implements OnInit {

  airlines: Airline[];
  selectedAirline: Airline;

  priceValue;
  durationValue;
  departureTimeLower: NgbTimeStruct;
  departureTimeUpper: NgbTimeStruct;
  arrivalTimeLower: NgbTimeStruct;
  arrivalTimeUpper: NgbTimeStruct;

  answer: any[];
  flightsResult: Flight[];
  flightsResultReturn: FlightReturn[];

  flightClass: string;
  flightType: string;


  constructor(private searchFlightObject: SearchFlightParams, private activatedRoute: ActivatedRoute,
     private flightService: FlightService, private airlineService: AirlineService, private router: Router) {

     }

  ngOnInit() {
    console.log(this.searchFlightObject);
    if (!this.searchFlightObject.flightType) {
      // const sessionObject: SearchFlightParams = JSON.parse(sessionStorage.getItem('searchFilterObject'));
      this.searchFlightObject = JSON.parse(sessionStorage.getItem('searchFilterObject'));
    }
    sessionStorage.setItem('searchFilterObject', JSON.stringify(this.searchFlightObject));
    this.flightService.searchFlights(this.searchFlightObject).subscribe(data => {
      console.log('prosao');
      console.log(data);
      this.flightClass = this.searchFlightObject.ticketClass;
      this.flightType = this.searchFlightObject.flightType;

      this.answer = data;
      if (this.searchFlightObject.flightType === 'ONE_WAY') {
        this.flightsResult = data;
      } else {
        this.flightsResultReturn = data;
      }
    });

    this.airlineService.getAirlines().subscribe(airlines => {
      this.airlines = airlines;
    });

    this.durationValue = 10;
    this.priceValue = 500;
    this.departureTimeLower = {hour: 0, minute: 1, second: 0};
    this.departureTimeUpper = {hour: 23, minute: 59, second: 0};
    this.arrivalTimeLower = {hour: 0, minute: 11, second: 0};
    this.arrivalTimeUpper = {hour: 23, minute: 59, second: 0};

    /*const s = new SliderComponent();
          s.selection = '#priceSlider';
       s.ticks  = [0, 100, 200, 300, 400];
        s.ticksLabels = ['$0', '$100', '$200', '$300', '$400'];*/
  }

  filterByAirline(airline: Airline) {
    // zbog pokazivanja active klase
    if (airline) {
      this.selectedAirline = airline;
    } else {
      this.selectedAirline = undefined;
    }

    console.log(airline);
    if (airline) {
      this.searchFlightObject.airlineFilter = airline;
    } else {
      this.searchFlightObject.airlineFilter = null;
    }
    sessionStorage.setItem('searchFilterObject', JSON.stringify(this.searchFlightObject));
    this.flightService.searchFlights(this.searchFlightObject).subscribe(data => {
      console.log('Nakon airline filtera');
      console.log(data);
      // this.flightsResult = data;
      this.answer = data;
      if (this.flightType === 'ONE_WAY') {
        this.flightsResult = data;
      } else {
        this.flightsResultReturn = data;
      }
    });
  }

  change() {

  }

  filter() {
    console.log(this.arrivalTimeLower);
    if (!this.validTimeFilters()) {
      alert('Ispravite vreme');
      return;
    }

    // const t: SearchFlightParams = this.searchFlightObject;
    // this.searchFlightObject.initAdditionalFilter();

    this.searchFlightObject.initAdditionalFilter(this.durationValue, this.departureTimeLower,
      this.departureTimeUpper, this.arrivalTimeLower, this.arrivalTimeUpper, this.priceValue);


    this.flightService.searchFlightsComplex(this.searchFlightObject).subscribe(data => {
      console.log('prosao');
      console.log(data);
      // this.flightsResult = data;

      this.answer = data;
      if (this.flightType === 'ONE_WAY') {
        this.flightsResult = data;
      } else {
        this.flightsResultReturn = data;
      }
    });

  }

  validTimeFilters(): boolean {
    if (!this.departureTimeLower || !this.departureTimeUpper || !this.arrivalTimeLower || !this.arrivalTimeUpper) {
      return false;
    }
    return true;
  }

  /*renderFlightDuration(flight: Flight): string {
    const hour = Math.floor(flight.flightDuration);
    const decimal = flight.flightDuration - hour;
    const minutes = Math.round(decimal * 60);
    return hour + 'h '  + minutes + 'min';
  }*/

  reset() {
    this.searchFlightObject.airlineFilter = null;
    this.flightService.searchFlights(this.searchFlightObject).subscribe(data => {
      console.log('prosao');
      console.log(data);
      // this.flightsResult = data;
      // this.flightClass = this.searchFlightObject.ticketClass;

      this.answer = data;
      if (this.flightType === 'ONE_WAY') {
        this.flightsResult = data;
      } else {
        this.flightsResultReturn = data;
      }
    });

  }

  back () {
    this.router.navigate(['search']);
  }
}
