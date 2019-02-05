import { Flight } from './flight.model';
export class FlightSeat {

  id: number;
  reserved: boolean;
  discountTicket: boolean;

  flight: Flight;

}
