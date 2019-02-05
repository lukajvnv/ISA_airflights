import { FlightTicket } from './flight-ticket';
import { User } from './user.model';
export class Reservation {

  reservationId: number;
  ticket: FlightTicket;
  user: User;
  passportNum: string;

  constructor(ticket: FlightTicket, user: User, passport: string) {
    this.ticket = ticket;
    this.user = user;
    this.passportNum = passport;
  }
}
