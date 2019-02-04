import { Airline } from './../../models/airline.model';
import { AirlineService } from './../../services/airline.service';
import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-airline',
  templateUrl: './view-airline.component.html',
  styleUrls: ['./view-airline.component.css']
})
export class ViewAirlineComponent implements OnInit {

  isRightAdmin: boolean;
  isCollapsed: true;

  @Input()
  currentAirline: Airline;

  constructor(private airlineServie: AirlineService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.isRightAdmin = true;
    this.isCollapsed = true;
    this.activatedRoute.paramMap.subscribe(params => {
      const airlineId = params.get('airlineId');
      this.airlineServie.getAirline(airlineId).subscribe(data => {
        this.currentAirline = data;
      });
    });
  }

  prikaziLetove() {
    return this.router.navigate(['airline/flights', this.currentAirline.airlineId]);
  }

  prikaziSnizeneKarte() {

  }

  izmeniAvioKompaniju() {
    return this.router.navigate([ 'airline/update', this.currentAirline.airlineId ]);
  }

  pokreniAnalitiku() {
    this.router.navigate(['analytics', this.currentAirline.airlineId ]);
  }

  novaDestinacija() {
    this.router.navigate(['destination/new', this.currentAirline.airlineId ]);
  }

  noviCenovnik() {
    this.router.navigate(['pricelist/new', this.currentAirline.airlineId ]);
  }

}
