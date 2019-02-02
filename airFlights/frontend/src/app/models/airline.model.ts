import { Destination } from './destination.model';
import { Flight } from './flight.model';
export interface Airline {
  airlineId: number;
  name: string;
  address: string;
  city: string;
  promoDescription: string;
  luggageInfo: string;
  ratingSum: number;
  ratingNumber: number;

  flightDestinations: Destination[];
  // discountTickets: any[];
}
