import { Chart } from 'chart.js';
import { Component, OnInit, Input } from '@angular/core';
import { Airline } from 'src/app/models/airline.model';
import { Router } from '@angular/router';

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

  constructor(private router: Router) {}

  ngOnInit() {
     // Line chart:
    this.LineDayChart = new Chart('lineDayChart', {
      type: 'line',
    data: {
     labels: ['Jan', 'Feb', 'March', 'April', 'May', 'June', 'July', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
     datasets: [{
         label: 'Number of Items Sold in Months',
         data: [9, 7 , 3, 5, 2, 10, 15, 16, 19, 3, 1, 9],
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

    // Bar chart:
    this.BarWeekChart = new Chart('barWeekChart', {
      type: 'bar',
    data: {
     labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
     datasets: [{
         label: '# of Votes',
         data: [9, 7 , 3, 5, 2, 10],
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
         ],
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

    // Bar chart:
    this.BarMonthChart = new Chart('barMonthChart', {
      type: 'bar',
    data: {
     labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
     datasets: [{
         label: '# of Votes',
         data: [9, 7 , 3, 5, 2, 10],
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
         ],
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
    /* // pie chart:
    this.PieChart = new Chart('pieChart', {
      type: 'pie',
    data: {
     labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
     datasets: [{
         label: '# of Votes',
         data: [9, 7 , 3, 5, 2, 10],
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
         ],
         borderWidth: 1
     }]
    },
    options: {
     title: {
         text: 'Bar Chart',
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
    }); */
  }

  test() {
    this.LineDayChart = [];
    this.LineDayChart = new Chart('lineChart', {
      type: 'line',
    data: {
     labels: ['Jan', 'Feb', 'March', 'April', 'May', 'June', 'July', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
     datasets: [{
         label: 'Number of Items Sold in Months',
         data: [9, 7 , 3, 5, 2, 10, 15, 16, 19, 3, 1, 9],
         fill: false,
         lineTension: 0.4,
         borderColor: 'red',
         borderWidth: 2,
     }]
    },
    options: {
     title: {
         text: 'Line Chart',
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

  povratakNaProfilAvioKompanije() {
    this.router.navigate(['airline', this.currentAirline.airlineId]);
  }

  generisiIzvestaj() {
    if (this.reportType) {

    }
    console.log(this.reportType);
  }


}
