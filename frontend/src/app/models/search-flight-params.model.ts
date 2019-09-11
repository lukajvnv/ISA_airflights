import { NgbTimeStruct } from '@ng-bootstrap/ng-bootstrap';
import { Airline } from './airline.model';
import { Destination } from './destination.model';
import { Injectable } from '@angular/core';

@Injectable()
export class SearchFlightParams {
departureDate: string;
arrivalDate: string;
ticketClass: string;
personNum: number;
flightType: string;
luggage: number;

priceFilter: number;

airlineFilter: Airline;
flightDurationFilter: number;
arrivalTimeFilterLower: string;
arrivalTimeFilterUpper: string;
departureTimeFilterLower: string;
departureTimeFilterUpper: string;

departureDestinations: Destination[];
arrivalDestinations: Destination[];
// departureDestinations: Destination;
// arrivalDestinations: Destination;

constructor(/*searchFlightParams: SearchFlightParams*/) {
  /*this.departureDate = departureDate;
  this.arrivalDate = arrivalDate;
  this.flightType = flightType;
  this.ticketClass = ticketClass;
  this.personNum = personNum;
  this.luggage = luggage;
  this.departureDestinations = new Array(5);
  this.departureDestinations.push(departureDest);
  this.arrivalDestinations = new Array(5);
  this.arrivalDestinations.push(arrivaDest);*/
  }


init ( departureDate: Date, arrivalDate: Date, flightType: string,  ticketClass: string, personNum: number, luggage: number,
  departureDest: Destination, arrivalDest: Destination) {
  // this.departureDate = new Date(departureDate).toISOString().split('T')[0];

  let trueMonth = ('0' + departureDate['month']).slice(-2);
  let trueDay = ('0' + departureDate['day']).slice(-2);

  this.departureDate = departureDate['year'] + '-' + trueMonth + '-' + trueDay;
  if (arrivalDate) {
    trueMonth = ('0' + arrivalDate['month']).slice(-2);
    trueDay = ('0' + arrivalDate['day']).slice(-2);
    this.arrivalDate = arrivalDate['year'] + '-' + trueMonth + '-' + trueDay;
  }

  this.flightType = flightType;
  this.ticketClass = ticketClass;
  this.personNum = personNum;
  this.luggage = luggage;
  this.departureDestinations = new Array(4);
  this.departureDestinations.splice(0, 0, departureDest);
  this.arrivalDestinations = new Array(4);
  this.arrivalDestinations.splice(0, 0, arrivalDest);
}

initAdditionalFilter ( flightDurationFilter: number, departureFilterLower: NgbTimeStruct, departureFilterUpper: NgbTimeStruct,
  arrivalFilterLower: NgbTimeStruct, arrivalFilterUpper: NgbTimeStruct, price: number) {
    this.flightDurationFilter = flightDurationFilter;
    this.priceFilter = price;
    console.log(this.departureDate);

    let trueHour = ('0' + departureFilterLower['hour']).slice(-2);
    let trueMinute = ('0' + departureFilterLower['minute']).slice(-2);
    this.departureTimeFilterLower = trueHour + ':' + trueMinute + ':' + '00.000';

    trueHour = ('0' + departureFilterUpper['hour']).slice(-2);
    trueMinute = ('0' + departureFilterUpper['minute']).slice(-2);
    this.departureTimeFilterUpper = trueHour + ':' + trueMinute + ':' + '00.000';

    trueHour = ('0' + arrivalFilterLower['hour']).slice(-2);
    trueMinute = ('0' + arrivalFilterLower['minute']).slice(-2);
    this.arrivalTimeFilterLower = trueHour + ':' + trueMinute + ':' + '00.000';

    trueHour = ('0' + arrivalFilterUpper['hour']).slice(-2);
    trueMinute = ('0' + arrivalFilterUpper['minute']).slice(-2);
    this.arrivalTimeFilterUpper = trueHour + ':' + trueMinute + ':' + '00.000';
}

/*clone(searchFlightParams: SearchFlightParams) {
  this.init(searchFlightParams.departureDate, searchFlightParams.arrivalDate, searchFlightParams.type, searchFlightParams.class,
    searchFlightParams.persons, searchFlightParams.luggage, searchFlightParams.departureDestination, searchFlightParams.arrivalDestination);
    console.log(searchFlightParams);
}*/

}
