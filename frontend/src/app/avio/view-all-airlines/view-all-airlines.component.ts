import { Airline } from './../../models/airline.model';
import { AirlineService } from './../../services/airline.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-all-airlines',
  templateUrl: './view-all-airlines.component.html',
  styleUrls: ['./view-all-airlines.component.css']
})
export class ViewAllAirlinesComponent implements OnInit {

  constructor(private airlineService: AirlineService, private router: Router) { }

  airlines: Airline[] = [];

  sortType: string;

  ngOnInit() {
    this.airlineService.getAirlines().subscribe(data => {
      this.airlines = data;
    });
  }

  viewAirline(airlineId: string) {
    this.router.navigate(['airline', airlineId]);
  }

  sortTypeChanged() {
    switch (this.sortType) {
      case 'ByName': this.airlines.sort(this.sortByName); break;
      case 'ByCity': this.airlines.sort(this.sortByCity); break;
      default: return;
    }
  }

  sortByName(airline1: Airline, airline2: Airline) {
    if (airline1.name > airline2.name) {
      return 1;
    }
    if (airline1.name < airline2.name) {
      return -1;
    }
    return 0;
  }

  sortByCity(airline1: Airline, airline2: Airline) {
    if (airline1.city > airline2.city) {
      return 1;
    }
    if (airline1.city < airline2.city) {
      return -1;
    }
    return 0;
  }

}
