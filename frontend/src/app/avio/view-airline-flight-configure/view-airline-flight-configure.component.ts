import { AirlineService } from './../../services/airline.service';
import { FlightTicket } from './../../models/flight-ticket';
import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SearchFlightParams } from 'src/app/models/search-flight-params.model';
import { BookingService } from 'src/app/services/booking.service';
import { FlightService } from 'src/app/services/flight.service';
import { Flight } from 'src/app/models/flight.model';
import { FlightSeat } from 'src/app/models/seat.model';
import { Location } from '@angular/common';

@Component({
  selector: 'app-view-airline-flight-configure',
  templateUrl: './view-airline-flight-configure.component.html',
  styleUrls: ['./view-airline-flight-configure.component.css']
})
export class ViewAirlineFlightConfigureComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute, private flightService: FlightService,
     private router: Router, private bookingService: BookingService, private location: Location,
     private airlineService: AirlineService) { }

  @Input()
  currentFlight: Flight;

  // svaSedistaAviona: number[] = [];
  // brojeviZeljenihSedista: number[] = [];
  selectDiv: boolean[] = [];

  flightSeats: FlightSeat[] = [];
  // zeljenaSedista: FlightSeat[] = [];

  selectedSeat: FlightSeat;
  // lastSelectedIndex: number;

  brzaKartaForm: boolean;
  novoSedisteForm: boolean;
  brojSedista: number;
  popust: number;

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params => {
      const flightId: string = params.get('flightId');
      this.flightService.getFlight(flightId).subscribe(data => {
        this.currentFlight = data;
      });
      this.bookingService.getAllSeats(flightId).subscribe(data => {
        this.flightSeats = data;
        console.log('booking: seats');
        this.selectDiv = new Array<boolean>(this.flightSeats.length);
        // this.svaSedistaAviona = new Array<number>(this.flightSeats.length);
        for (let i = 0; i < this.selectDiv.length; i++) {
          this.selectDiv[i] = false;
        }
      });
    });
  }

  selektuj(index: number, seat: FlightSeat) {
    console.log('usao u selektuj');

    if (this.selectDiv[index]) {
     // const i = this.zeljenaSedista.indexOf(seat);
      // this.zeljenaSedista.splice(i, 1);

      this.selectedSeat = undefined;

    } else {
      this.selectedSeat = seat;
    }
    this.selectDiv[index] = !this.selectDiv[index];
  }

  brzaKarta() {
    if ( !this.selectedSeat ) {
      alert('Selektujte sediste');
    } else {
      this.brzaKartaForm = true;
    }
  }

  ukloni() {
    if ( !this.selectedSeat ) {
      alert('Selektujte sediste');
    } else {
      this.airlineService.removeSeat(this.selectedSeat).subscribe(data => {
        console.log('uklonjeno sediste');
        for (let i = 0; i < this.selectDiv.length; i++) {
          this.selectDiv[i] = false;
        }
        this.selectedSeat = undefined;
        this.flightSeats = data;
      },
      err => {
        alert('Greska pri uklanjanju sedista');
      });
    }
  }

  dodaj() {
    this.novoSedisteForm = true;
  }

  brzaKartaPotvrda() {
    if ( !this.selectedSeat || !this.popust ) {
      alert('Nevalidno');
    } else {
      const updateSeat = this.selectedSeat;
      updateSeat.reserved = true;
      const newTicket: FlightTicket = new FlightTicket(this.selectedSeat.flight, updateSeat
        , 'ECONOMY');
      newTicket.discount = this.popust;
      if (newTicket.discount !== 0) {
        newTicket.sellingPrice = newTicket.basePrice * (1 - newTicket.discount / 100);
      }

      this.airlineService.addQuickTicket(newTicket).subscribe(data => {
        console.log('Dodata brza karta');
        for (let i = 0; i < this.selectDiv.length; i++) {
          this.selectDiv[i] = false;
        }
        this.selectedSeat = undefined;

        this.flightSeats = data;
        this.brzaKartaForm = false;
      },
      err => {
        alert('Greska pri dodavanju brze karte');
      });

    }
  }

  dodajPotvrda() {
    if (!this.brojSedista) {
      alert('Unesite broj sedista');

    } else {
      const newSeat = new FlightSeat();
      newSeat.discountTicket = true;
      newSeat.reserved = false;
      newSeat.flight = this.currentFlight;
      newSeat.seatNumber = this.brojSedista;

      this.airlineService.addNewSeat(newSeat).subscribe(data => {
        console.log('dodato sediste');
        for (let i = 0; i < this.selectDiv.length; i++) {
          this.selectDiv[i] = false;
        }
        this.selectedSeat = undefined;

        this.flightSeats = data;
        this.novoSedisteForm = false;
      },
      err => {
        alert('Greska pri dodavanju:sediste sa tim brojem vec postoji');
      });
    }
  }

  backClick() {
    // this.router.navigate(['../viewFlightResults'], { relativeTo: this.activatedRoute });
    this.location.back();
 }

}
