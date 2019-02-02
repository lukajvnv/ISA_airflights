import { Airline } from './../../models/airline.model';
import { FlightService } from './../../services/flight.service';
import { AirlineService } from './../../services/airline.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Destination } from 'src/app/models/destination.model';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-update-airline',
  templateUrl: './update-airline.component.html',
  styleUrls: ['./update-airline.component.css']
})
export class UpdateAirlineComponent implements OnInit {

  businessDestinations: Destination[] = [];
  unassignedDestinations: Destination[] = [];


  airlineForm = new FormGroup({
    airlineName: new FormControl('',
      Validators.required),
    airlineAddress: new FormControl('',
      Validators.required),
    airlineCity: new FormControl('',
      Validators.required),
    airlinePromoDescription: new FormControl(),
    airlineLuggageInfo: new FormControl(),
  });

  isCollapsed: boolean;

  airline: Airline;

  constructor(private activatedRoute: ActivatedRoute, private airlineService: AirlineService, private flightService: FlightService,
    private router: Router) { }

  ngOnInit() {
    this.isCollapsed = true;

    this.activatedRoute.paramMap.subscribe(params => {
      const airline: string = params.get('airlineId');
      if (airline) {
        this.airlineService.getAirline(airline).subscribe(data => {
          this.airline = data;
          this.initFields(this.airline);
        });
      }
    });
    this.flightService.getDestinations().subscribe(data => {
      this.unassignedDestinations = data;
    });
  }

  get airlineName() {
    return this.airlineForm.get('airlineName');
  }
  get airlineAddress() {
    return this.airlineForm.get('airlineAddress');
  }
  get airlineCity() {
    return this.airlineForm.get('airlineCity');
  }
  get airlinePromoDescription() {
    return this.airlineForm.get('airlinePromoDescription');
  }
  get airlineLuggageInfo() {
    return this.airlineForm.get('airlineLuggageInfo');
  }

  initFields(airline: Airline) {
    this.airlineName.setValue(airline.name);
    this.airlineAddress.setValue(airline.address);
    this.airlineCity.setValue(airline.city);
    this.airlineLuggageInfo.setValue(airline.luggageInfo);
    this.airlinePromoDescription.setValue(airline.promoDescription);
    this.businessDestinations = this.airline.flightDestinations;
  }

  potvrdi() {
    if (!this.airlineForm.valid) {
      alert('Nevalidno unosenje podataka');
      return;
    }

    this.airline.name = this.airlineName.value;
    this.airline.address = this.airlineAddress.value;
    this.airline.city = this.airlineCity.value;
    this.airline.luggageInfo = this.airlineLuggageInfo.value;
    this.airline.promoDescription = this.airlinePromoDescription.value;
    this.airline.flightDestinations = this.businessDestinations;

    this.airlineService.updateAirline(this.airline).subscribe(() => {
      this.router.navigate(['airline', this.airline.airlineId]);
    });

  }

  dodajDestinacijuPoslovanja(destination: Destination) {
    const filter: Destination[] = this.businessDestinations.filter(s => s.destinationId === destination.destinationId);
    if ( filter.length === 0) {
      this.businessDestinations.push(destination);
    }
    const index = this.unassignedDestinations.indexOf(destination);
    this.unassignedDestinations.splice(index, 1);
  }

  ukloniDestinacijuPoslovanja(destination: Destination) {
    const filter: Destination[] = this.unassignedDestinations.filter(s => s.destinationId === destination.destinationId);
    if (filter.length === 0) {
      this.unassignedDestinations.push(destination);
    }
    const index = this.businessDestinations.indexOf(destination);
    this.businessDestinations.splice(index, 1);
  }
}
