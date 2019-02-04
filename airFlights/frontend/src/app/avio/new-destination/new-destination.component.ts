import { ActivatedRoute, Router } from '@angular/router';
import { DestinationService } from './../../services/destination.service';
import { NgbTimeStruct } from '@ng-bootstrap/ng-bootstrap';
import { Destination } from 'src/app/models/destination.model';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-new-destination',
  templateUrl: './new-destination.component.html',
  styleUrls: ['./new-destination.component.css']
})
export class NewDestinationComponent implements OnInit {

  destinationForm = new FormGroup({
    destinationName: new FormControl('', Validators.required),
    destinationCode: new FormControl('', [
      Validators.required,
      /*Validators.minLength(3),
      Validators.maxLength(3),*/
      Validators.pattern('[a-zA-Z]{3}')]),
    destinationAirport: new FormControl('', Validators.required),
    destinationDescription: new FormControl(),
  });

  airlineId: string;

  constructor(private destinationService: DestinationService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params => {
      this.airlineId = params.get('airlineId');
    });

  }

  potvrdi() {
    if (!this.destinationForm.valid) {
      alert('Nevalidno unosenje podataka');
      return;
    }

    const newDestination: Destination = new Destination();
    newDestination.destinationName = this.destinationName.value;
    newDestination.destinationCode = this.destinationCode.value.toString().toUpperCase();
    newDestination.destinationCode.toUpperCase();
    newDestination.destinationAirport = this.destinationAirport.value;
    newDestination.destinationDescription = this.destinationDescription.value;

    this.destinationService.addNewDestination(newDestination).subscribe(() => {
      this.router.navigate(['airline', this.airlineId]);
    });

  }

  povratakNaProfilAvioKompanije() {
    this.router.navigate(['airline', this.airlineId]);
  }

  get destinationName() {
    return this.destinationForm.get('destinationName');
  }

  get destinationCode() {
    return this.destinationForm.get('destinationCode');
  }

  get destinationAirport() {
    return this.destinationForm.get('destinationAirport');
  }

  get destinationDescription() {
    return this.destinationForm.get('destinationDescription');
  }
}
