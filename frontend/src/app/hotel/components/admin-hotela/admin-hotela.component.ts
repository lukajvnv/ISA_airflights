import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
//import { ProfileService } from 'src/app/aviokompanije/services/profile.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-hotela',
  templateUrl: './admin-hotela.component.html',
  styleUrls: ['./admin-hotela.component.css']
})
export class AdminHotelaComponent implements OnInit {

  constructor(private router : Router) { }

  izmenaPodatakaVar : boolean = false;
  showLicniPodaci : boolean = true;
  showSifra : boolean = false;
  // korisnik : Korisnik;

  izmeniSifruClick() : void{
    this.showLicniPodaci = false;
    this.showSifra = true;
  }

  ngOnInit() {
    // this.korisnik = JSON.parse(localStorage.getItem('ulogovaniKorisnik'));
    // if(this.korisnik == null || this.korisnik.tipKorisnika != "ADMINHOTEL"){
    //   this.router.navigate(['/home ']);
    // }
    // this.izmeniPodatke.get('ime').setValue(this.korisnik.firstname);
    // this.izmeniPodatke.get('prezime').setValue(this.korisnik.lastname);
    // this.izmeniPodatke.get('adresa').setValue(this.korisnik.grad);
    // this.izmeniPodatke.get('brojTelefona').setValue(this.korisnik.brojTelefona);
  }

  odustani() : void{
    this.izmenaPodatakaVar = false;
    this.showLicniPodaci = true;
    this.showSifra = false;
  }

  sifra = new FormGroup({
    sifra1 : new FormControl('', Validators.required),
    sifra2 : new FormControl('', Validators.required)
  })

  izmeniPodatke = new FormGroup({
    ime : new FormControl('', Validators.required),
    prezime : new FormControl('', Validators.required),
    adresa : new FormControl('', Validators.required),
    brojTelefona : new FormControl('', Validators.required)
  });

  sacuvajIzmeneSifre() : void{
    let s1 = this.sifra.get('sifra1').value;
    let s2 = this.sifra.get('sifra2').value;
    if(s1 != s2){
      alert('Sifre se moraju poklapati');
      return;
    }
    if(s1.length < 6){
      alert('Sifra mora imati najmanje 6 karaktera');
      return;
    }
    // let k = new Korisnik();
    //k.password = s1;
    // this.profileService.izmeniSifruKorisnika(this.korisnik.mail, k).subscribe(
    //   (data)=>{
    //     this.showSifra = false;
    //     this.showLicniPodaci = true;
    //   },
    //   error => console.log(error)
    // )

  }

  izmeni() : void{
    // let user = new Korisnik();
    // user.firstname = this.izmeniPodatke.get('ime').value;
    // user.lastname = this.izmeniPodatke.get('prezime').value;
    // user.grad = this.izmeniPodatke.get('adresa').value;
    // user.brojTelefona = this.izmeniPodatke.get('brojTelefona').value;
    // user.mail = this.korisnik.mail;
    // this.profileService.izmenaAdminaHotela(user).subscribe(
    //   (data) => {
    //     localStorage.setItem('ulogovaniKorisnik', JSON.stringify(user));
    //     this.izmenaPodatakaVar = false;
    //     this.showLicniPodaci = true;
    //     this.korisnik.firstname = user.firstname;
    //     this.korisnik.lastname = user.lastname;
    //     this.korisnik.grad = user.grad;
    //     this.korisnik.brojTelefona = user.brojTelefona;
    //   },
    //   error => console.log(error)
    // )
    
}

  showIzmeniPodatkeFormu(){
    this.izmenaPodatakaVar = true;
    this.showLicniPodaci = false;
  }

}
