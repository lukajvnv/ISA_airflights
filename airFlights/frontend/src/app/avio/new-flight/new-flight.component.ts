import { Pricelist } from './../../models/pricelist.model';
import { AirlineService } from './../../services/airline.service';
import { Flight } from './../../models/flight.model';
import { Airline } from './../../models/airline.model';
import { ActivatedRoute, Router } from '@angular/router';
import { FlightService } from './../../services/flight.service';
import { Destination } from './../../models/destination.model';
import { Component, OnInit, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { NgbTimeStruct } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-new-flight',
  templateUrl: './new-flight.component.html',
  styleUrls: ['./new-flight.component.css']
})
export class NewFlightComponent implements OnInit {

  flightId: number;

  luggage: number;
  departureDestination: Destination;
  arrivalDestination: Destination;
  stops: Destination[] = [];

  departureDate: Date;
  arrivalDate: Date;
  departureTime: NgbTimeStruct;
  arrivalTime: NgbTimeStruct;

  seatNum: number;
  seatEconomy: number;
  seatBusiness: number;
  seatFirst: number;
  distance: number;
  airplane: string;
  additionalService: string;

  airline: Airline;
  selectedPricelist: Pricelist;

  destinations: Destination[];
  unassignedStops: Destination[] = [];
  allPricelist: Pricelist[] = [];

  isCollapsed: boolean;
  isUpdate;

  submitText: string;

  constructor(private flightService: FlightService, private airlineService: AirlineService, private activatedRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.departureTime = {hour: 0, minute: 1, second: 0};
    this.arrivalTime = {hour: 0, minute: 1, second: 0};

    this.activatedRoute.paramMap.subscribe(params => {
      this.isUpdate = false;

      const airline: string = params.get('airlineId');
      if (airline) {
        this.airlineService.getAirline(airline).subscribe(data => {
          this.airline = data;
        });
      }

      const flightId: string = params.get('flightId');
      if (flightId) {
        this.isUpdate = true;
        this.flightService.getFlight(flightId).subscribe(data => {
          const flight: Flight = data;
          this.inicijalizujVrednostiPolja(flight);
        });
      }

    });
    this.flightService.getDestinations().subscribe(data => {
      this.destinations = data;
      this.unassignedStops = data;
    });
    this.flightService.getAllPricelist().subscribe(data => {
      this.allPricelist = data;
    });

    this.isCollapsed = true;
    this.isUpdate ? this.submitText = 'Izmeni' : this.submitText = 'Dodaj';
  }

  inicijalizujVrednostiPolja(flight: Flight) {
    console.log(flight);
    this.arrivalDate = new Date();
    this.departureDate = new Date();

    let day = flight.departureDate/* .split('-') */[2];
    let month = flight.departureDate/* .split('-') */[1];
    let year = flight.departureDate/* .split('-') */[0];

    this.departureDate['year'] = +year;
    this.departureDate['month'] = +month;
    this.departureDate['day'] = +day;

    day = flight.arrivalDate/* .split('-') */[2];
    month = flight.arrivalDate/* .split('-') */[1];
    year = flight.arrivalDate/* .split('-') */[0];

    this.arrivalDate['year'] = +year;
    this.arrivalDate['month'] = +month;
    this.arrivalDate['day'] = +day;

    let h = flight.departureTime/*.split(',')*/[0];
    let min = flight.departureTime/*.split(',')*/[1];
    this.departureTime = {hour: +h, minute: +min, second: 0};

    h = flight.arrivalTime/*.split(',')*/[0];
    min = flight.arrivalTime/*.split(',')*/[1];
    this.arrivalTime = {hour: +h, minute: +min, second: 0};

    this.distance = flight.flightDistance;
    this.luggage = flight.luggage;
    this.seatNum = flight.numberOfSeats;
    this.seatEconomy = flight.numberOfEconomyAvailableSeats;
    this.seatFirst = flight.numberOfFirstAvailableSeats;
    this.seatBusiness = flight.numberOfBusinessAvailableSeats;
    this.stops = flight.stops;
    this.selectedPricelist = flight.pricelist;

    this.airplane = flight.airplaneName;
    this.additionalService = flight.additionalService;

    this.flightId = flight.flightId;

    this.departureDestination = flight.departureDestination;
    this.arrivalDestination = flight.arrivalDestination;

  }

  dodajPresedanje(stop: Destination) {
    const filter: Destination[] = this.stops.filter(s => s.destinationId === stop.destinationId);
    if ( filter.length === 0) {
      this.stops.push(stop);
    }
    const index = this.unassignedStops.indexOf(stop);
    this.unassignedStops.splice(index, 1);
  }

  ukloniPresedanje(stop: Destination) {
    const filter: Destination[] = this.unassignedStops.filter(s => s.destinationId === stop.destinationId);
    if (filter.length === 0) {
      this.unassignedStops.push(stop);
    }
    const index = this.stops.indexOf(stop);
    this.stops.splice(index, 1);
  }

  dodajLet(f: NgForm) {
    console.log(f.form);
    if (f.form.status === 'INVALID') {
      alert('Molimo popunite obavezne paremetre[NEADEKVATAN UNOS]');
      return;
    }
    if (isNaN(Number(this.luggage)) && this.luggage) {
      console.log(this.luggage);
      alert('Uneta količina prtljaga nevalidna');
      return;
    }
    if (isNaN(Number(this.distance)) && this.distance) {
      alert('Nevalidan unos rastojanja');
      return;
    }
    // isNaN(Number(this.seatBusiness)) || isNaN(Number(this.seatEconomy)) || isNaN(Number(this.seatFirst))
    if ( this.seatFirst || this.seatBusiness || this.seatEconomy) {
      const equal: boolean = +this.seatNum === +this.seatBusiness + +this.seatEconomy + +this.seatFirst;
      if (!equal) {
        alert('Ukupan broj sedista kao i sedista po kategorijama mora biti odgovarajuci');
        return;
      }
    }

    const newFlight: Flight = this.generateNewFlight();
    if (!this.isUpdate) {
      this.flightService.addNewFlight(newFlight).subscribe( ()  => {
         this.router.navigate(['airline', this.airline.airlineId]);
      });
    } else {
      this.flightService.updateFlight(newFlight).subscribe( ()  => {
         this.router.navigate(['airline', this.airline.airlineId]);
      });
    }
  }

  generateNewFlight() {
    const newFlight: Flight = new Flight(this.departureDestination, this.arrivalDestination, this.stops, this.luggage, this.seatNum,
      this.seatEconomy, this.seatBusiness, this.seatFirst, this.airplane, this.distance, this.additionalService, this.flightId);
    newFlight.airline = this.airline;
    newFlight.pricelist = this.selectedPricelist;
    newFlight.initComplexData(this.departureDate, this.arrivalDate, this.departureTime, this.arrivalTime);
    return newFlight;
  }

  povratakNaProfilAvioKompanije() {
    this.router.navigate(['airline', this.airline.airlineId]);
  }

  /*compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }*/
}
