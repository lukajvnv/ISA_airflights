import { AirlineService } from './../../services/airline.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Chart} from 'chart.js';
import { Airline } from 'src/app/models/airline.model';

@Component({
  selector: 'app-avio-analytics',
  templateUrl: './avio-analytics.component.html',
  styleUrls: ['./avio-analytics.component.css']
})
export class AvioAnalyticsComponent implements OnInit {

  activeTab = 'reports';
  currentAirline: Airline;

  constructor(private activatedRoute: ActivatedRoute, private airlineService: AirlineService) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params => {
      const airlineId = params.get('airlineId');
      this.airlineService.getAirline(airlineId).subscribe(data => {
        this.currentAirline = data;
      });
    });
  }

  /*changeActiveTab (newActive: string) {
    this.activeTab = newActive;
  }*/

}
