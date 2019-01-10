import { Destination } from './destination.model';
import { tick } from '@angular/core/src/render3';
import { initDomAdapter } from '@angular/platform-browser/src/browser';

export class SearchFlightParams {
departureDate: string;
arrivalDate: string;
ticketClass: string;
personNum: number;
flightType: string;
luggage: number;

// private Airline airlineFilter;
// flightDurationFilter: number;
// arrivalTimeFilterLower;
// arrivalTimeFilterUpper;
// departureTimeFilterLower;
// departureTimeFilterUpper;

departureDestinations: Destination[];
arrivalDestinations: Destination[];
// departureDestinations: Destination;
// arrivalDestinations: Destination;

constructor(/*departureDate: Date, arrivalDate: Date, flightType: string,  ticketClass: string, personNum: number, luggage: number,
  departureDest: Destination, arrivaDest: Destination*/) {
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
  this.departureDate = departureDate['year'] + '-' + departureDate['month'] + '-' + departureDate['day'];
  console.log(this.departureDate);
  if (arrivalDate) {  this.arrivalDate = arrivalDate['year'] + '-' + arrivalDate['month'] + '-' + arrivalDate['day']; }
  this.flightType = flightType;
  this.ticketClass = ticketClass;
  this.personNum = personNum;
  this.luggage = luggage;
  this.departureDestinations = new Array(5);
  this.departureDestinations.splice(0, 0, departureDest);
  console.log(departureDest);
  console.log(this.departureDestinations);

  this.arrivalDestinations = new Array(5);
  this.arrivalDestinations.splice(0, 0, arrivalDest);
}

}
