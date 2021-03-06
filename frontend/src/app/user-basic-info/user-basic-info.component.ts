import { LoggedUserService } from './../services/logged-user.service';
import { Component, OnInit, Input, Output } from '@angular/core';
import { User } from '../models/user.model';
import { NgForm } from '@angular/forms';
import { EventEmitter } from 'protractor';

@Component({
  selector: 'app-user-basic-info',
  templateUrl: './user-basic-info.component.html',
  styleUrls: ['./user-basic-info.component.css']
})
export class UserBasicInfoComponent implements OnInit {

  @Input()
  currentUser: User;

 /*  @Output()
  change: EventEmitter; */

  constructor(private userService: LoggedUserService) { }

  ngOnInit() {
  }

  izmeniPodatke(f: NgForm) {
    if (f.form.status === 'INVALID') {
      alert('Molimo popunite obavezne paremetre[NEADEKVATAN UNOS]');
      return;
    }

    this.userService.updateUser(this.currentUser).subscribe(() => {
      console.log('Azuriran korisnik');
    });
  }

}
