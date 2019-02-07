import { AirlineAnalyticsOneValue } from './../../models/airline-analytics-one-value.model';
import { AirlineService } from './../../services/airline.service';
import { Chart } from 'chart.js';
import { Component, OnInit, Input } from '@angular/core';
import { Airline } from 'src/app/models/airline.model';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { AirlineAnalyticsQuery } from 'src/app/models/airline-analytics-query.model';

@Component({
  selector: 'app-avio-analytics-report',
  templateUrl: './avio-analytics-report.component.html',
  styleUrls: ['./avio-analytics-report.component.css']
})
export class AvioAnalyticsReportComponent implements OnInit {

  @Input()
  currentAirline: Airline;

  from: Date;
  to: Date;
  reportType: string;

  // title = 'Ng7ChartJs By DotNet Techy';

  LineDayChart = [];
  BarWeekChart = [];
  BarMonthChart = [];

  graphLabels: any[] = [];
  graphData: number[] = [];

  answer: AirlineAnalyticsOneValue[] = [];

  constructor(private router: Router, private airlineService: AirlineService) {}

  ngOnInit() {
     // Line chart:
     this.LineDayChart = [];
     this.BarWeekChart = [];
     this.BarMonthChart = [];
  }

  povratakNaProfilAvioKompanije() {
    this.router.navigate(['airline', this.currentAirline.airlineId]);
  }

  generisiIzvestaj(f: NgForm) {
    if (f.form.status === 'INVALID') {
      alert('Molimo popunite obavezne paremetre[NEADEKVATAN UNOS]');
      return;
    }

    const id: string = this.currentAirline.airlineId.toString();
    const query: AirlineAnalyticsQuery = new AirlineAnalyticsQuery(this.from, this.to, this.reportType);
    this.airlineService.getAirlineReport(id, query).subscribe(data => {
      this.answer = data;
      switch (this.reportType) {
        case 'DAILY': this.createDailyGraph(this.answer); break;
        case 'WEEKLY': this.createWeeklyGraph(this.answer); break;
        case 'MONTHLY': this.createMonthlyGraph(this.answer); break;

      }

    });
  }

  createDailyGraph(data: AirlineAnalyticsOneValue[]) {
    const graphLabels: string[] = new Array<string>(data.length);
    const graphData: number[] = new Array<number>(data.length);
    let oneValue: AirlineAnalyticsOneValue;
    for (let i = 0; i < data.length; i++) {
      oneValue = data[i];
      graphLabels[i] = oneValue.label;
      graphData[i] = oneValue.value;
    }

    this.LineDayChart = [];
     this.LineDayChart = new Chart('lineDayChart', {
      type: 'line',
    data: {
     labels: graphLabels,
     datasets: [{
         label: '# broj prodatih karata',
         data: graphData,
         fill: true,
         lineTension: 0.4,
         borderColor: 'blue',
         borderWidth: 2,
     }]
    },
    options: {
     title: {
         text: 'Dnevni izvestaj',
         display: true
     },
     scales: {
         yAxes: [{
             ticks: {
                 beginAtZero: true
             }
         }]
     }
    }
    });
  }

  createWeeklyGraph(data: AirlineAnalyticsOneValue[]) {
    const graphLabels: string[] = new Array<string>(data.length);
    const graphData: number[] = new Array<number>(data.length);
    let oneValue: AirlineAnalyticsOneValue;
    for (let i = 0; i < data.length; i++) {
      oneValue = data[i];
      graphLabels[i] = oneValue.label;
      graphData[i] = oneValue.value;
    }

    this.BarWeekChart = [];
    this.BarWeekChart = new Chart('barWeekChart', {
      type: 'bar',
    data: {
     labels: graphLabels,
     datasets: [{
         label: '# broj prodatih karata',
         data: graphData, /*
         backgroundColor: [
             'rgba(255, 99, 132, 0.2)',
             'rgba(54, 162, 235, 0.2)',
             'rgba(255, 206, 86, 0.2)',
             'rgba(75, 192, 192, 0.2)',
             'rgba(153, 102, 255, 0.2)',
             'rgba(255, 159, 64, 0.2)'
         ],
         borderColor: [
             'rgba(255,99,132,1)',
             'rgba(54, 162, 235, 1)',
             'rgba(255, 206, 86, 1)',
             'rgba(75, 192, 192, 1)',
             'rgba(153, 102, 255, 1)',
             'rgba(255, 159, 64, 1)'
         ], */
         borderWidth: 1
     }]
    },
    options: {
     title: {
         text: 'Nedeljni izvestaj ',
         display: true
     },
     scales: {
         yAxes: [{
             ticks: {
                 beginAtZero: true
             }
         }]
     }
    }
    });
  }

  createMonthlyGraph(data: AirlineAnalyticsOneValue[]) {
    const graphLabels: string[] = new Array<string>(data.length);
    const graphData: number[] = new Array<number>(data.length);
    let oneValue: AirlineAnalyticsOneValue;
    for (let i = 0; i < data.length; i++) {
      oneValue = data[i];
      graphLabels[i] = oneValue.label;
      graphData[i] = oneValue.value;
    }

    // Bar chart:
    this.BarMonthChart = new Chart('barMonthChart', {
      type: 'bar',
    data: {
     labels: graphLabels,
     datasets: [{
         label: '# broj prodatih karata',
         data: graphData,
         /* backgroundColor: [
             'rgba(255, 99, 132, 0.2)',
             'rgba(54, 162, 235, 0.2)',
             'rgba(255, 206, 86, 0.2)',
             'rgba(75, 192, 192, 0.2)',
             'rgba(153, 102, 255, 0.2)',
             'rgba(255, 159, 64, 0.2)'
         ],
         borderColor: [
             'rgba(255,99,132,1)',
             'rgba(54, 162, 235, 1)',
             'rgba(255, 206, 86, 1)',
             'rgba(75, 192, 192, 1)',
             'rgba(153, 102, 255, 1)',
             'rgba(255, 159, 64, 1)'
         ], */
         borderWidth: 1
     }]
    },
    options: {
     title: {
         text: 'Mesecni izvestaj ',
         display: true
     },
     scales: {
         yAxes: [{
             ticks: {
                 beginAtZero: true
             }
         }]
     }
    }
    });
}

}
