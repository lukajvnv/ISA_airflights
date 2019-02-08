import { Component, OnInit, Input } from '@angular/core';
import { RentacarService } from 'src/app/services/rentacar.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Rentacar } from 'src/app/models/rentacar.model';
import { HttpClient } from '@angular/common/http';
import { Car } from 'src/app/models/car.model';
import { modelGroupProvider } from '@angular/forms/src/directives/ng_model_group';
import { CarService } from 'src/app/services/car.service';

@Component({
  selector: 'app-view-rentacar',
  templateUrl: './view-rentacar.component.html',
  styleUrls: ['./view-rentacar.component.css']
})
export class ViewRentacarComponent implements OnInit {

  isRightAdmin: boolean;
  isCollapsed: true;
  isCollapsed2: true;
  pDate: string;
  dDate: string;

  @Input()
  currentRentacar: Rentacar;

  private _id: number;
  private _pickupLocation: string;
  private _dropofLocation: string;
  private _pickupDate: Date;
  private _dropofDate: Date;
  private _type: string;
  private _numberOfSeats: number;
  private _fromPrice: number;
  private _toPrice: number;

  model: SearchCarModel = {
    id: 0,
    pickupLocation: '',
    dropofLocation: '',
    pickupDate: '',
    dropofDate: '',
    type: '',
    numberOfSeats: 0,
    fromPrice: 0,
    toPrice: 0,
    carId: 0
  }

  private allCars: Car[];
  private filteredCars: Car[];

  types = ['Kombi', 'Karavan', 'Kupe'];

  constructor(private rentacarService: RentacarService, private router: Router, private activatedRoute: ActivatedRoute,
    private http: HttpClient, private carService: CarService) { }

  ngOnInit() {
    this.isRightAdmin = true;
    this.isCollapsed = true;
    this.isCollapsed2 = true;
    this.filteredCars = [];
    this.activatedRoute.paramMap.subscribe(
      params => {
        const rentacarId = params.get('rentacarId');
        this.rentacarService.getRentacar(Number(rentacarId)).subscribe(
         (data : Rentacar) => {
          this.currentRentacar = data;
         });
      });
  }

  showBranches() {
    return this.router.navigate(['rentacar/branches', this.currentRentacar.rentacarId])
  }

  newBranch() {
    this.router.navigate(['rentacar/newBranch', this.currentRentacar.rentacarId]);
  }

  updateRentacar() {
    this.router.navigate(['rentacar/update', this.currentRentacar.rentacarId]);
  }

  newCar() {
    this.router.navigate(['rentacar/newCar', this.currentRentacar.rentacarId]);
  }

  /*
  get pickupLocation(): string {
    return this._pickupLocation;
  }

  set pickupLocation(value: string) {
    this._pickupLocation = value;
    this.filteredCars = this.filterCars(value,"",null,null,"",0,0,0);
  }

  get dropofLocation(): string {
    return this._dropofLocation;
  }

  set dropofLocation(value: string){
    this._dropofLocation = value;
    this.filteredCars = this.filterCars("",value,null,null,"",0,0,0);
  } 

  get pickupDate(): Date {
    return this._pickupDate;
  }

  set pickupDate(value: Date){
    this._pickupDate = value;
    this.filteredCars = this.filterCars("","",value,null,"",0,0,0);
  } 

  get dropofDate(): Date {
    return this._dropofDate;
  }

  set dropofDate(value: Date){
    this._dropofDate = value;
    this.filteredCars = this.filterCars("","",null,value,"",0,0,0);
  } 

  get type(): string {
    return this._type;
  }

  set type(value: string) {
    this._type = value;
    this.filteredCars = this.filterCars("","",null,null,value,0,0,0);
  }

  get numberOfSeats(): number {
    return this._numberOfSeats;
  }

  set numberOfSeats(value: number) {
    this._numberOfSeats = value;
    this.filteredCars = this.filterCars("","",null,null,"",value,0,0);
  }

  get fromPrice() {
    return this._fromPrice;
  }

  set fromPrice(value: number) {
    this._fromPrice = value;
    this.filteredCars = this.filterCars("","",null,null,"",0,value,0);
  }

  get toPrice() {
    return this._toPrice;
  }

  set toPrice(value: number) {
    this._toPrice = value;
    this.filteredCars = this.filterCars("","",null,null,"",0,0,value);
  }

  filterCars(pLocation: string, dLocation: string, pDate: Date, dDate: Date, 
    type: string, numberOfSeats: number, fromPrice: number, toPrice: number) {
      return this.allCars.filter(
        car => car.pickupLocation.toLowerCase().indexOf(pLocation.toLowerCase()) !== -1 &&
        car.dropofLocation.toLowerCase().indexOf(dLocation.toLowerCase()) !== -1 &&
        car.pickupDate >
      )
    }
    */

  searchCars(): void {
    this.model.id = this.currentRentacar.rentacarId;

    const url = 'http://localhost:8836/car/getReservationCars?parameters=' + encodeURI(JSON.stringify(this.model));
    this.http.get(url).subscribe(
      (res : Car[]) => {
        alert('Pretraga uspesna');
        this.filteredCars = res;
      },
      err => {
        alert('Pretraga neuspesna');
      },
    );
    
  }

  reserveCar(carId: number) {
    const url = 'http://localhost:8836/reservation/car/' + localStorage.getItem('currentUser');
    this.model.carId = carId;

    this.http.post(url, this.model).subscribe(
      res => {
        alert("Uspesno rezervisano!");
      },
      err => {
        alert("Neuspesna rezervacija");
      }
    );
  }

}

export interface SearchCarModel {
  id: number;
  pickupLocation: string;
  dropofLocation: string;
  pickupDate: string;
  dropofDate: string;
  type: string;
  numberOfSeats: number;
  fromPrice: number;
  toPrice: number;
  carId: number;
}

/*export interface SearchCarModel2 {
  id: number;
  pickupLocation: string;
  dropofLocation: string;
  pickupDate: string;
  dropofDate: string;
  type: string;
  numberOfSeats: number;
  fromPrice: number;
  toPrice: number;
}*/