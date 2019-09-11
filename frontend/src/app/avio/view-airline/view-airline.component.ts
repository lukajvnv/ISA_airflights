import { BookingService } from 'src/app/services/booking.service';
import { Airline } from './../../models/airline.model';
import { AirlineService } from './../../services/airline.service';
import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-view-airline',
  templateUrl: './view-airline.component.html',
  styleUrls: ['./view-airline.component.css']
})
export class ViewAirlineComponent implements OnInit {

  isRightAdmin: boolean;
  isCollapsed: boolean;

  @Input()
  currentAirline: Airline;

  currentUser: User;

  constructor(private airlineServie: AirlineService, private router: Router, private activatedRoute: ActivatedRoute,
    private bookingService: BookingService) { }

  ngOnInit() {
    // this.isRightAdmin = true;
    this.isCollapsed = true;
    // this.currentUser = new User('airSerbia');

    const username: string = localStorage.getItem('currentUser');
    if (username) {
      // this.currentUser =  new User(username);
      this.bookingService.getUser(username).subscribe(data => {
        this.currentUser = data;
      });
    }

    this.activatedRoute.paramMap.subscribe(params => {
      const airlineId = params.get('airlineId');
      this.airlineServie.getAirline(airlineId).subscribe(data => {
        this.currentAirline = data;
        if (this.currentAirline.adminForThisAirline.username === this.currentUser.username) {
          this.isRightAdmin = true;
        }
      });
    });
  }

  prikaziLetove() {
    return this.router.navigate(['airline/flights', this.currentAirline.airlineId]);
  }

  prikaziSnizeneKarte() {
    return this.router.navigate(['airline/tickets', this.currentAirline.airlineId]);

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
