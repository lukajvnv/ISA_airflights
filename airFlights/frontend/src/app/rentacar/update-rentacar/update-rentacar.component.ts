import { Component, OnInit } from '@angular/core';
import { Rentabranch } from 'src/app/models/rentabranch.model';
import { Validators, FormGroup, FormControl } from '@angular/forms';
import { Rentacar } from 'src/app/models/rentacar.model';
import { ActivatedRoute, Router } from '@angular/router';
import { RentacarService } from 'src/app/services/rentacar.service';
import { RentabranchService } from 'src/app/services/rentabranch.service';

@Component({
  selector: 'app-update-rentacar',
  templateUrl: './update-rentacar.component.html',
  styleUrls: ['./update-rentacar.component.css']
})
export class UpdateRentacarComponent implements OnInit {

  rentaBranches: Rentabranch[] = [];
  nonAssignedBranches: Rentabranch[] = [];

  rentacarForm = new FormGroup({
    rentacarName: new FormControl('',
      Validators.required),
    rentacarAdress: new FormControl('',
      Validators.required),
    rentacarDescription: new FormControl(),
  });

  isCollapsed: boolean;
  rentacar: Rentacar;
  rentacarId: string;

  constructor(private activatedRoute: ActivatedRoute, private rentacarService: RentacarService,
    private router: Router, private rentaBranchService: RentabranchService) { }

  ngOnInit() {
    this.isCollapsed = true;

    this.activatedRoute.paramMap.subscribe(
      params => {
        const rentacar: string = params.get('rentacarId');
        this.rentacarId = rentacar;
        if(rentacar) {
          this.rentacarService.getRentacar(Number(rentacar)).subscribe(
            data => {
              this.rentacar = data;
              this.initFields(this.rentacar);
            });
        }
      });
      this.rentaBranchService.getBranches().subscribe(
        data => {
          this.nonAssignedBranches = data;
        });
  }

  get rentacarName() {
    return this.rentacarForm.get('rentacarName');
  }

  get rentacarAdress() {
    return this.rentacarForm.get('rentacarAdress');
  }

  get rentacarDescription() {
    return this.rentacarForm.get('rentacarDescription');
  }

  initFields(rentacar: Rentacar) {
    this.rentacarName.setValue(rentacar.name);
    this.rentacarAdress.setValue(rentacar.adress);
    this.rentacarDescription.setValue(rentacar.promoDescription);
    this.rentaBranches = this.rentacar.branches;
  }

  confirm() {
    if(!this.rentacarForm.valid) {
      alert('Wrong input!');
      return;
    }

    this.rentacar.rentacarId = Number(this.rentacarId);
    this.rentacar.name = this.rentacarName.value;
    this.rentacar.adress = this.rentacarAdress.value;
    this.rentacar.promoDescription = this.rentacarDescription.value;
    this.rentacar.branches = this.rentaBranches;

    this.rentacarService.updateRentacar(this.rentacar).subscribe(
      () => {
        this.router.navigate(['rentacar', this.rentacar.rentacarId]);
    });
  }

  /*addRentaBranch(rentabranch: Rentabranch) {
    const filter: Rentabranch[] = this.rentaBranches.filter(s => s.branchId === rentabranch.branchId);
    if(filter.length === 0) {
      this.rentaBranches.push(rentabranch);
    }
    const id = this.nonAssignedBranches.indexOf(rentabranch);
    this.nonAssignedBranches.splice(id,1);
  }*/

  removeRentaBranch(rentabranch: Rentabranch) {
    const filter: Rentabranch[] = this.nonAssignedBranches.filter(s => s.branchId === rentabranch.branchId);
    if(filter.length === 0) {
      this.nonAssignedBranches.push(rentabranch);
    }
    const id = this.rentaBranches.indexOf(rentabranch);
    this.rentaBranches.splice(id,1);
  }
}
