import { AirlineService } from './../../services/airline.service';
import { AirlineAnalyticsQuery } from './../../models/airline-analytics-query.model';
import { Component, OnInit, Input } from '@angular/core';
import { Airline } from 'src/app/models/airline.model';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

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

  income: string;

  constructor(private router: Router, private airlineService: AirlineService) { }

  ngOnInit() {
  }

  povratakNaProfilAvioKompanije() {
    this.router.navigate(['airline', this.currentAirline.airlineId]);
  }

  generisiIzvestaj(f: NgForm) {
    console.log(f);
    if (f.form.status === 'INVALID') {
      alert('Molimo popunite obavezne paremetre[NEADEKVATAN UNOS]');
      return;
    }

    const id: string = this.currentAirline.airlineId.toString();
    const query: AirlineAnalyticsQuery = new AirlineAnalyticsQuery(this.from, this.to, 'DEFAULT');
    this.airlineService.getAirlineProfit(id, query).subscribe(data => {
      this.income = data;
    });
  }
}
