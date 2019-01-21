import { Pricelist } from './pricelist.model';
import { Airline } from './airline.model';
import { Destination } from 'src/app/models/destination.model';
import { Time } from '@angular/common';

export interface Flight {
  flightId: number;

  departureDate: string;
  arrivalDate: string;

  departureTime: string;
  arrivalTime: string;
  flightDuration: number;
  flightDistance: number;

  // rati
  // ratingSum;

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
}
