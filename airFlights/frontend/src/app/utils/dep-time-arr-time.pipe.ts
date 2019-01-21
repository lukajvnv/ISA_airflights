import { Flight } from './../models/flight.model';
import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'timeFilter'
})
export class DepTimeArrTimePipe implements PipeTransform {
  transform(value: Flight, args?: any) {
    const dep = value.departureTime.toString();
    const arr = value.arrivalTime.toString();

     const hoursD = dep.split(':')[0];
     const minutesD = dep.split(':')[1];
     const hoursA = arr.split(':')[0];
     const minutesA = arr.split(':')[1];
     return hoursD + ':' + minutesD + ' - ' + hoursA + ':' + minutesA;
  }
}
