import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { CarService } from 'src/app/services/car.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Car } from 'src/app/models/car.model';

@Component({
  selector: 'app-new-car',
  templateUrl: './new-car.component.html',
  styleUrls: ['./new-car.component.css']
})
export class NewCarComponent implements OnInit {

  carForm = new FormGroup({
    carName: new FormControl('', Validators.required),
    carBrand: new FormControl('', Validators.required),
    carModel: new FormControl('', Validators.required),
    carYear: new FormControl('', Validators.required),
    carNumberOfSeats: new FormControl(),
    carPrice: new FormControl('', Validators.required),
    carType: new FormControl('', Validators.required)
  });

  rentacarId: string;

  types = ['Karavan','Kombi','Kupe'];

  constructor(private carService: CarService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(
      params => {
        this.rentacarId = params.get('rentacarId');
      });
  }

  confirm() {
    if(!this.carForm.valid) {
      alert('Wrong input!');
      return;
    }

    const newCar: Car = new Car();
    newCar.carName = this.carName.value;
    newCar.carBrand = this.carBrand.value;
    newCar.carModel = this.carModel.value;
    newCar.carYear = this.carYear.value;
    newCar.numberOfSeats = this.carNumberOfSeast.value;
    newCar.price = this.carPrice.value;
    newCar.dropofDate = '1111-11-11';
    newCar.pickupDate = '1111-11-11';
    newCar.pickupLocation = 'lok1';
    newCar.dropofLocation = 'lok1';
    newCar.tip = this.carType.value;

    this.carService.getRentaCarId(this.rentacarId);

    this.carService.addNewCar(newCar).subscribe(
      () => {
        this.router.navigate(['rentacar', this.rentacarId]);
      });
  }

  backToProfileRentacar() {
    this.router.navigate(['rentacar', this.rentacarId]);
  }

  get carName() {
    return this.carForm.get('carName');
  }

  get carBrand() {
    return this.carForm.get('carBrand');
  }

  get carModel() {
    return this.carForm.get('carModel');
  }

  get carYear() {
    return this.carForm.get('carYear');
  }

  get carNumberOfSeast() {
    return this.carForm.get('carNumberOfSeats');
  }

  get carPrice() {
    return this.carForm.get('carPrice');
  }

  get carType() {
    return this.carForm.get('carType');
  }
}
