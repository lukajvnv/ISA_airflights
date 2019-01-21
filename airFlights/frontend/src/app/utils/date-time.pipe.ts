import { Flight } from './../models/flight.model';
import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'dateTimeFilter'
})
export class DateTimePipe implements PipeTransform {
  transform(value: Flight, depOrArr: string) {
    let time;
    let date;

    if ( depOrArr === 'd' ) {
      time = value.departureTime.toString();
      date = value.departureDate.toString();
    } else {
      time = value.arrivalTime.toString();
      date = value.arrivalDate.toString();
    }

    const hour = time.split(':')[0];
    const minute = time.split(':')[1];
    const day = time.split(':')[2];
    const month = time.split(':')[1];
    const year = time.split(':')[0];

    console.log(date);
    return date + ' ' + hour + ':' + minute;
  }
}
