import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-rentabranch',
  templateUrl: './rentabranch.component.html',
  styleUrls: ['./rentabranch.component.css']
})
export class RentabranchComponent implements OnInit {

  model: RentaBranchViewModel = {
    name: '',
    location: ''
  }

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  sendRentaBranch(): void {
    const url = 'http://localhost:8836/rentacar/addRentaBranch';
    this.http.post(url, this.model).subscribe(
      res => {
        alert('Successful');
      },
      err => {
        alert('Error has occured while adding new Renta Branch');
      }
    );
  }

}

export interface RentaBranchViewModel {
  name: string;
  location: string;
}
