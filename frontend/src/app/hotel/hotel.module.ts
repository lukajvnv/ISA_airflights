import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HotelComponent } from './components/hotel/hotel.component';
import { DodajUsluguComponent } from './components/dodaj-uslugu/dodaj-uslugu.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DodajSobuComponent } from './components/dodaj-sobu/dodaj-sobu.component';
import { CeneNocenjaComponent } from './components/cene-nocenja/cene-nocenja.component';
import { SviHoteliComponent } from './components/svi-hoteli/svi-hoteli.component';
import { RezervacijaSobeComponent } from './components/rezervacija-sobe/rezervacija-sobe.component';
import { DodajHotelComponent } from './components/dodaj-hotel/dodaj-hotel.component';
import { SobeNaPopustuComponent } from './components/sobe-na-popustu/sobe-na-popustu.component';
import { GrafikPosecenostiComponent } from './components/grafik-posecenosti/grafik-posecenosti.component';
import { MapModule } from '../map/map.module';
import { HotelProfilnaComponent } from './components/hotel-profilna/hotel-profilna.component';
import { AdminHotelaComponent } from './components/admin-hotela/admin-hotela.component';




@NgModule({
  declarations: [HotelComponent, DodajUsluguComponent, DodajSobuComponent, CeneNocenjaComponent, SviHoteliComponent, RezervacijaSobeComponent, DodajHotelComponent, SobeNaPopustuComponent, GrafikPosecenostiComponent, HotelProfilnaComponent, AdminHotelaComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MapModule
  ],
  exports: [DodajHotelComponent, SviHoteliComponent]
})
export class HotelModule { }
