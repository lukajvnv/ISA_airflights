import { Flight } from './../models/flight.model';
import {Pipe, PipeTransform} from '@angular/core';
import { Destination } from '../models/destination.model';

@Pipe({
  name: 'stopDestinationsFilter'
})
export class StopDestinationPipe implements PipeTransform {
  transform(stops: Destination[], args?: any) {
    if (stops.length === 0) {
      return 'Nema presedanja';
    } else {
      let ret = '';
      for (let _i = 0; _i < stops.length; _i++) {
        ret += stops[_i].destinationName;
        if (_i < stops.length - 1) {
          ret += ', ';
        }
      }
      return ret;
    }
  }
}
