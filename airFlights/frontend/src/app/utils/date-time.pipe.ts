import { Flight } from './../models/flight.model';
import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'dateTimeFilter'
})
export class DateTimePipe implements PipeTransform {
  transform(value: Flight, depOrArr: string) {
    let time: string;
    let date: string;

    if (value) {
      if ( depOrArr === 'd' ) {
        time = value.departureTime.toString();
        date = value.departureDate.toString();
      } else {
        time = value.arrivalTime.toString();
        date = value.arrivalDate.toString();
      }

      /*const hour = time.split(',')[0];
      const minute = time.split(',')[1];*/

      console.log(date);
      return date + ' ' + time /*+ hour + ':' + minute*/;
    } else {
      return;
    }
  }
}
