import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reservation } from '../models/reservation.model';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  private getAllSeatsByFlightBase = 'http://localhost:8836/book/seats/flight/';

  private getFriendsUrl = 'http://localhost:8836/book/friends';
  private getAllUsersUrl = 'http://localhost:8836/book/users';

  private addFriendUrlBase = 'http://localhost:8836/book/friend/add/';
  private removeFriendUrlBase = 'http://localhost:8836/book/friend/remove/';

  private refuseFriendUrlBase = 'http://localhost:8836/book/friend/refuse/';
  private acceptFriendUrlBase = 'http://localhost:8836/book/friend/accept/';

  private getFriendRequestUrl = 'http://localhost:8836/book/friend/request';

  private inviteFriendsToFlightUrlBase = 'http://localhost:8836/book/friend/flight/invite/';


  private makeReservationUrl = 'http://localhost:8836/book/newReservation';
  private getReservationsUrl = 'http://localhost:8836/book/user/reservations';
  private getFlightInvitationUrl = 'http://localhost:8836/book/user/flightInvitations';
  private acceptFlightUrl = 'http://localhost:8836/book/user/accept';
  private declineFlightUrl = 'http://localhost:8836/book/user/refuse';

  private getReservationByIdUrlBase = 'http://localhost:8836/book/getReservation/';

  constructor(private http: HttpClient) { }

  getAllSeats(flightId: string): Observable<any> {
    return this.http.get(this.getAllSeatsByFlightBase + flightId);
  }

  makeReservation(reservation: Reservation): Observable<any> {
    return this.http.post(this.makeReservationUrl, reservation);
  }

  getFriends(user: User): Observable<any> {
    return this.http.post(this.getFriendsUrl, user);
  }

  getAllUsers(): Observable<any> {
    return this.http.get(this.getAllUsersUrl);
  }

  addFriend(currentUserId: string, person: User ): Observable<any> {
    return this.http.post(this.addFriendUrlBase + currentUserId, person);
  }

  removeFriend(currentUserId: string, person: User ): Observable<any> {
    return this.http.post(this.removeFriendUrlBase + currentUserId, person);
  }

  refuseFriend(currentUserId: string, person: User ): Observable<any> {
    return this.http.post(this.refuseFriendUrlBase + currentUserId, person);
  }

  acceptFriend(currentUserId: string, person: User ): Observable<any> {
    return this.http.post(this.acceptFriendUrlBase + currentUserId, person);
  }

  getFriendRequets(user: User): Observable<any> {
    return this.http.post(this.getFriendRequestUrl, user);
  }

  inviteFriendsToFlight(currentUser: User, reservations: Reservation[]): Observable<any> {
    return this.http.post(this.inviteFriendsToFlightUrlBase + currentUser.username, reservations);
  }

  getReservations(currentUser: User): Observable<any> {
    return this.http.post(this.getReservationsUrl, currentUser);
  }

  getFlightInvitations(currentUser: User): Observable<any> {
    return this.http.post(this.getFlightInvitationUrl, currentUser);
  }

  acceptFlight(reservation: Reservation): Observable<any> {
    return this.http.post(this.acceptFlightUrl, reservation);
  }

  refuseFlight(reservation: Reservation): Observable<any> {
    return this.http.post(this.declineFlightUrl, reservation);
  }

  getReservationById(reservationId: string): Observable<any> {
    return this.http.get(this.getReservationByIdUrlBase + reservationId);
  }

}
