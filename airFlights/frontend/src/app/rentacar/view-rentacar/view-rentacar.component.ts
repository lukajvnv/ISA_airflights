import { Component, OnInit, Input } from '@angular/core';
import { RentacarService } from 'src/app/services/rentacar.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Rentacar } from 'src/app/models/rentacar.model';

@Component({
  selector: 'app-view-rentacar',
  templateUrl: './view-rentacar.component.html',
  styleUrls: ['./view-rentacar.component.css']
})
export class ViewRentacarComponent implements OnInit {

  isRightAdmin: boolean;
  isCollapsed: true;

  @Input()
  currentRentacar: Rentacar;

  constructor(private rentacarService: RentacarService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.isRightAdmin = true;
    this.isCollapsed = true;
    this.activatedRoute.paramMap.subscribe(
      params => {
        const rentacarId = params.get('rentacarId');
        this.rentacarService.getRentacar(Number(rentacarId)).subscribe(
         data => {
          this.currentRentacar = data;
         });
      });
  }

  showBranches() {
    return this.router.navigate(['rentacar/branches', this.currentRentacar.rentacarId])
  }

}
