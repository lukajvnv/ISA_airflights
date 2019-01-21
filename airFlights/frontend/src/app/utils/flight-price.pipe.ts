import { Flight } from './../models/flight.model';
import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'priceFilter'
})
export class FlightPricePipe implements PipeTransform {
  transform(flight: Flight, fligthClass: string) {
    if (fligthClass === 'ECONOMY') {
      return flight.pricelist.economyPrice;
    } else if (fligthClass === 'BUSINESS') {
      return flight.pricelist.businessPrice;
    } else if (fligthClass === 'FIRST') {
      return flight.pricelist.firstPrice;
    } else {
      return 'NON';
    }
  }
}
