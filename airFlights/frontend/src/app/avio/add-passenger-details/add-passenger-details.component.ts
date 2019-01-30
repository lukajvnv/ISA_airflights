import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Flight } from './../../models/flight.model';
import { FlightService } from './../../services/flight.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-add-passenger-details',
  templateUrl: './add-passenger-details.component.html',
  styleUrls: ['./add-passenger-details.component.css']
})
export class AddPassengerDetailsComponent implements OnInit {

  currentFlight: Flight;

  passengerForm = new FormGroup({
    passengerName: new FormControl('', Validators.required),
    passengerLastName: new FormControl('', Validators.required),
    passengerAddress: new FormControl('', Validators.required),
    passengerTelephone: new FormControl('', Validators.required),
    passengerMail: new FormControl('', Validators.required),
    passengerPassportNum: new FormControl('', Validators.required)
  });

  constructor(private activatedRoute: ActivatedRoute, private flightService: FlightService) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params => {
      const flightId: string = params.get('flightId');
      this.flightService.getFlight(flightId).subscribe(data => {
        this.currentFlight = data;
        /*console.log('adding people:');
        this.selectDiv = new Array<boolean>(this.currentFlight.numberOfSeats);
        this.svaSedistaAviona = new Array<number>(this.currentFlight.numberOfSeats);
        for (let i = 0; i < this.selectDiv.length; i++) {
          this.selectDiv[i] = false;
        }*/
      });
    });
    const user: User = new User('Luka', 'Jovanovic', 'Drage Spasic 7', 'lukajvnv@gmail.com', '064/449-86-28');
    this.passengerName.setValue(user.ime);
    this.passengerLastName.setValue(user.prezime);
    this.passengerAddress.setValue(user.adresa);
    this.passengerMail.setValue(user.mail);
    this.passengerTelephone.setValue(user.telefon);
    // this.passengerName.setValue(user.ime);
  }

  potvrdi() {
    if (!this.passengerForm.valid) {
      throw new Error;
    } else {
      console.log('validno');
      // this.passengerName.disable();
      /*this.passengerForm = new FormGroup({
        passengerName: new FormControl({value: 'a', disabled: true}, Validators.required),
        passengerLastName: new FormControl('b', Validators.required),
        passengerAddress: new FormControl('c', Validators.required),
        passengerTelephone: new FormControl('d', Validators.required),
        passengerMail: new FormControl('f', Validators.required),
        passengerPassportNum: new FormControl('g', Validators.required)
      });*/
    }
  }

  get passengerName() {
    return this.passengerForm.get('passengerName');
  }
  get passengerLastName() {
    return this.passengerForm.get('passengerLastName');
  }
  get passengerAddress() {
    return this.passengerForm.get('passengerAddress');
  }
  get passengerTelephone() {
    return this.passengerForm.get('passengerTelephone');
  }
  get passengerMail() {
    return this.passengerForm.get('passengerMail');
  }
  get passengerPassportNum() {
    return this.passengerForm.get('passengerPassportNum');
  }
}
