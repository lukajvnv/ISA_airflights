import { FlightService } from './../../services/flight.service';
import { Pricelist } from './../../models/pricelist.model';
import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-new-pricelist',
  templateUrl: './new-pricelist.component.html',
  styleUrls: ['./new-pricelist.component.css']
})
export class NewPricelistComponent implements OnInit {

  pricelistForm = new FormGroup({
    economyPrice: new FormControl('', [
      Validators.required,
      Validators.pattern(new RegExp('^[0-9]{1,4}(\.[0-9]{2})?$'))]),
    businessPrice: new FormControl('', [
      Validators.required,
    Validators.pattern('^[0-9]{1,4}(\.[0-9]{2})?$')]),
    firstPrice: new FormControl('', [
      Validators.required,
    Validators.pattern('^[0-9]{1,4}(\.[0-9]{2})?$')]),
  });

  constructor(private flightService: FlightService) { }

  ngOnInit() {
  }

  potvrdi() {
    if (!this.pricelistForm.valid) {
      alert('Nevalidno unosenje podataka');
      return;
    }

    const newPricelist: Pricelist = new Pricelist();
    newPricelist.economyPrice = this.economyPrice.value;
    newPricelist.businessPrice = this.businessPrice.value;
    newPricelist.firstPrice = this.firstPrice.value;

    this.flightService.addNewPricelist(newPricelist).subscribe(() => {

    });
  }

  get economyPrice() {
    return this.pricelistForm.get('economyPrice');
  }

  get businessPrice() {
    return this.pricelistForm.get('businessPrice');
  }

  get firstPrice() {
    return this.pricelistForm.get('firstPrice');
  }

}
