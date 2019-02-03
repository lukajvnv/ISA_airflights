import { Airline } from './../../models/airline.model';
import { AirlineService } from './../../services/airline.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Flight } from 'src/app/models/flight.model';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-avio-analytics-marks',
  templateUrl: './avio-analytics-marks.component.html',
  styleUrls: ['./avio-analytics-marks.component.css']
})
export class AvioAnalyticsMarksComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute, private airlineService: AirlineService, private router: Router) { }

  @Input()
  currentAirline: Airline;

  airlineFlights: Flight[];

  ngOnInit() {
    /* this.activatedRoute.paramMap.subscribe(params => {
      const airlineId = params.get('airlineId');
      this.airlineService.getAirline(airlineId).subscribe(data => {
        this.currentAirline = data;
      });
      this.airlineService.getAirlineFlights(airlineId).subscribe(data => {
        this.airlineFlights = data;
      });
    }); */
    if (this.currentAirline) {
      const airlineId: string = this.currentAirline.airlineId.toString();
      this.airlineService.getAirline(airlineId).subscribe(data => {
        this.currentAirline = data;
      });
      this.airlineService.getAirlineFlights(airlineId).subscribe(data => {
        this.airlineFlights = data;
      });
    }
  }

  pogledajOcenu( selectedFlight: Flight) {
    console.log('usao');
  }

  povratakNaProfilAvioKompanije() {
    this.router.navigate(['airline', this.currentAirline.airlineId]);
  }

}
