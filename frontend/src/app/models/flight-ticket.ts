import { FlightSeat } from './seat.model';
import { Flight } from './flight.model';
import { Airline } from './airline.model';
/*public enum TicketStatus{
  FREE, INVITED, RESERVED, CANCELLED, REDUCED_PRICE, FINISHED_FLIGHT
}

public enum TicketClass{
  ECONOMY, BUSINESS, FIRST
}

public enum FlightType{
  ROUND_TRIP, ONE_WAY, MULTI_CITY
}*/

export class FlightTicket {

  ticketClass: string;
  ticketStatus: string;

  ticketId: number;

  // airline: Airline;
  flight: Flight;

  basePrice: number;
  // seatNumber: number;
  seat: FlightSeat;
  discount: number;
  sellingPrice: number;
  markedFlight: boolean;

  constructor(flight: Flight, seatNumber: FlightSeat, ticketClass: string) {

    this.flight = flight;
    this.seat = seatNumber;

    this.ticketClass = ticketClass;
    switch (ticketClass) {
      case 'ECONOMY': this.basePrice = this.flight.pricelist.economyPrice; break;
      case 'BUSINESS': this.basePrice = this.flight.pricelist.businessPrice; break;
      case 'FIRST': this.basePrice = this.flight.pricelist.firstPrice; break;
      default: this.basePrice = this.flight.pricelist.economyPrice; this.ticketClass = ticketClass;
    }

    this.ticketStatus = 'RESERVED';

    this.discount = 0;
    this.sellingPrice = this.basePrice;
    this.markedFlight = false;
  }

}
