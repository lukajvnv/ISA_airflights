import { Component, OnInit } from '@angular/core';
import { RentabranchService } from 'src/app/services/rentabranch.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Rentabranch } from 'src/app/models/rentabranch.model';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-new-rentabranch',
  templateUrl: './new-rentabranch.component.html',
  styleUrls: ['./new-rentabranch.component.css']
})
export class NewRentabranchComponent implements OnInit {

  rentabranchForm = new FormGroup({
    rentabranchName: new FormControl('',Validators.required),
    rentabranchLocation: new FormControl('', Validators.required),
  });

  rentacarId: string;

  constructor(private rentabranchService: RentabranchService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(
      params => {
        this.rentacarId = params.get('rentacarId');
      });
  }

  confirm() {
    if(!this.rentabranchForm.valid) {
      alert('Wrong input!');
      return;
    }

    const newRentabranch: Rentabranch = new Rentabranch();
    newRentabranch.name = this.rentabranchName.value;
    newRentabranch.location = this.rentabranchLocation.value;

    this.rentabranchService.getRentacarId(this.rentacarId);

    this.rentabranchService.addNewRentaBranch(newRentabranch).subscribe(
      () => {
        this.router.navigate(['rentacar', this.rentacarId]);
      });
  }

  backToProfileRentacar() {
    this.router.navigate(['rentacar', this.rentacarId]);
  }

  get rentabranchName() {
    return this.rentabranchForm.get('rentabranchName');
  }

  get rentabranchLocation() {
    return this.rentabranchForm.get('rentabranchLocation');
  }

}
