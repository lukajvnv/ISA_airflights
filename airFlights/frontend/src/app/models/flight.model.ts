import { Pricelist } from './pricelist.model';
import { Airline } from './airline.model';
import { Destination } from 'src/app/models/destination.model';
import { Time } from '@angular/common';
import { NgbTimeStruct } from '@ng-bootstrap/ng-bootstrap';

export class Flight {
  flightId: number;

  departureDate: string;
  arrivalDate: string;

  departureTime: string;
  arrivalTime: string;
  flightDuration: number;
  flightDistance: number;

  ratingNum: number;
  ratingSum: number;

  numberOfSeats: number;
  numberOfEconomyAvailableSeats: number;
  numberOfBusinessAvailableSeats: number;
  numberOfFirstAvailableSeats: number;
  airplaneName: string;

  flightProfit: number;

  departureDestination: Destination;
  arrivalDestination: Destination;
  stops: Destination[];
  airline: Airline;

  tickets;
  pricelist: Pricelist;

  additionalService: string;
  luggage: number;

  constructor(depDest: Destination, arrDest: Destination, stops: Destination[], lug: number, seatNum: number, seatEconomy: number,
    seatBusiness: number, seatFirst: number, airplane: string, distance: number, additionalService: string, flightId: number) {
      this.departureDestination = depDest;
      this.arrivalDestination = arrDest;
      this.stops = stops;
      this.luggage = lug ? lug : 0;
      this.numberOfSeats = seatNum;
      this.numberOfEconomyAvailableSeats = seatEconomy ? seatEconomy : 0;
      this.numberOfFirstAvailableSeats = seatFirst ? seatFirst : 0;
      this.numberOfBusinessAvailableSeats = seatBusiness ? seatBusiness : 0;
      this.airplaneName = airplane ? airplane : '';
      this.additionalService = additionalService ? additionalService : '';
      this.flightDistance = distance ? distance : 0;

      this.ratingNum = 0;
      this.ratingSum = 0;

      this.flightId = flightId;
    }

  initComplexData(depDate: Date, arrDate: Date, depTime: NgbTimeStruct, arrTime: NgbTimeStruct) {
    let trueHour = ('0' + depTime['hour']).slice(-2);
    let trueMinute = ('0' + depTime['minute']).slice(-2);
    this.departureTime = trueHour + ':' + trueMinute + ':' + '00.000';

    trueHour = ('0' + arrTime['hour']).slice(-2);
    trueMinute = ('0' + arrTime['minute']).slice(-2);
    this.arrivalTime = trueHour + ':' + trueMinute + ':' + '00.000';

    let trueMonth = ('0' + depDate['month']).slice(-2);
    let trueDay = ('0' + depDate['day']).slice(-2);
    this.departureDate = depDate['year'] + '-' + trueMonth + '-' + trueDay;

    trueMonth = ('0' + arrDate['month']).slice(-2);
    trueDay = ('0' + arrDate['day']).slice(-2);
    this.arrivalDate = arrDate['year'] + '-' + trueMonth + '-' + trueDay;

  }
}
