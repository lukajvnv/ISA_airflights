import { Component, OnInit, Input } from '@angular/core';
import { Airline } from 'src/app/models/airline.model';

@Component({
  selector: 'app-avio-analytics-income',
  templateUrl: './avio-analytics-income.component.html',
  styleUrls: ['./avio-analytics-income.component.css']
})
export class AvioAnalyticsIncomeComponent implements OnInit {

  @Input()
  currentAirline: Airline;

  constructor() { }

  ngOnInit() {
  }

}
