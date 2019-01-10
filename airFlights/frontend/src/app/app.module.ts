import { FlightService } from './services/flight.service';
import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ViewAirlineComponent } from './avio/view-airline/view-airline.component';
import { SearchFlightComponent } from './avio/search-flight/search-flight.component';
import { ViewFlightComponent } from './avio/view-flight/view-flight.component';
import { BookFlightComponent } from './avio/book-flight/book-flight.component';

import { TextInputAutocompleteModule } from 'angular-text-input-autocomplete';


@NgModule({
  declarations: [
    AppComponent,
    ViewAirlineComponent,
    SearchFlightComponent,
    ViewFlightComponent,
    BookFlightComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AngularFontAwesomeModule,
    MatFormFieldModule,
    MatDatepickerModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
    HttpClientModule,
    TextInputAutocompleteModule,
    RouterModule.forRoot([
      {path : '', component : SearchFlightComponent}
    ])
  ],
  providers: [FlightService],
  bootstrap: [AppComponent]
})
export class AppModule {}
