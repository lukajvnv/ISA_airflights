import { Component, OnInit, Input } from '@angular/core';
import { Airline } from 'src/app/models/airline.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-avio-analytics-income',
  templateUrl: './avio-analytics-income.component.html',
  styleUrls: ['./avio-analytics-income.component.css']
})
export class AvioAnalyticsIncomeComponent implements OnInit {

  @Input()
  currentAirline: Airline;

  from: Date;
  to: Date;

  income: number;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  povratakNaProfilAvioKompanije() {
    this.router.navigate(['airline', this.currentAirline.airlineId]);
  }

  generisiIzvestaj() {
    this.income = 500000;
  }

}
