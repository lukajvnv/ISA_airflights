import { Component, OnInit } from '@angular/core';
import { RentacarService } from 'src/app/services/rentacar.service';
import { Rentacar } from 'src/app/models/rentacar.model';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-search-rentacar',
  templateUrl: './search-rentacar.component.html',
  styleUrls: ['./search-rentacar.component.css']
})
export class SearchRentacarComponent implements OnInit {

  constructor(private rentacarService: RentacarService, private router: Router, private activatedRoute: ActivatedRoute) { }

  rentacars: Rentacar[];
  filteredRentacars: Rentacar[];

  private _searchName: string;
  private _searchLocation: string;

  ngOnInit() {
   this.rentacarService.getRentacars().subscribe(
    data => {
      this.rentacars = data;
      this.filteredRentacars = data;
    });
  }

  get searchName(): string {
    return this._searchName;
  }

  set searchName(value: string) {
    this._searchName = value;
    this.filteredRentacars = this.filterRentacars(value,"");
  }
  
  get searchLocation(): string {
    return this._searchLocation;
  }

  set searchLocation(value: string) {
    this._searchLocation = value;
    this.filteredRentacars = this.filterRentacars("",value);
  } 

  /*get searchName(): string {
    return this._searchName;
  }

  set searchName(value: string) {
    this._searchName = value;
    this.filteredRentacars = this.filterRentacars(value);
  } 

  get searchName(): string {
    return this._searchName;
  }

  set searchName(value: string) {
    this._searchName = value;
    this.filteredRentacars = this.filterRentacars(value);
  } 
  */

  filterRentacars(searchName: string, searchLocation: string) {
    return this.rentacars.filter(
      rentacar => 
        rentacar.name.toLowerCase().indexOf(searchName.toLowerCase()) !== -1 && rentacar.adress.toLowerCase().indexOf(searchLocation.toLowerCase()) !== -1
        )
  }

  showRentacar(rentacar: Rentacar) {
    this.router.navigate(['rentacar', rentacar.rentacarId]);
  }

}
