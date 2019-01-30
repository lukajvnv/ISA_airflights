import { DateTimePipe } from './utils/date-time.pipe';
import { DepTimeArrTimePipe } from './utils/dep-time-arr-time.pipe';
import { AirlineService } from './services/airline.service';
import { FlightService } from './services/flight.service';
import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { NgxBootstrapSliderModule } from 'ngx-bootstrap-slider';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ViewAirlineComponent } from './avio/view-airline/view-airline.component';
import { SearchFlightComponent } from './avio/search-flight/search-flight.component';
import { ViewFlightComponent } from './avio/view-flight/view-flight.component';
import { BookFlightComponent } from './avio/book-flight/book-flight.component';

import { TextInputAutocompleteModule } from 'angular-text-input-autocomplete';
import { ViewFlightResultComponent } from './avio/view-flight-result/view-flight-result.component';
import { SearchFlightParams } from './models/search-flight-params.model';
import { OneWayFlightResultComponent } from './avio/one-way-flight-result/one-way-flight-result.component';
import { FlightPricePipe } from './utils/flight-price.pipe';
import { StopDestinationPipe } from './utils/stop-destination.pipe';
import { AddFriendToFlightComponent } from './avio/add-friend-to-flight/add-friend-to-flight.component';
import { AddPassengerDetailsComponent } from './avio/add-passenger-details/add-passenger-details.component';


@NgModule({
  declarations: [
    AppComponent,
    ViewAirlineComponent,
    SearchFlightComponent,
    ViewFlightComponent,
    BookFlightComponent,
    ViewFlightResultComponent,
    DepTimeArrTimePipe,
    FlightPricePipe,
    DateTimePipe,
    StopDestinationPipe,
    OneWayFlightResultComponent,
    AddFriendToFlightComponent,
    AddPassengerDetailsComponent
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
    NgxBootstrapSliderModule,
    HttpClientModule,
    TextInputAutocompleteModule,
    RouterModule.forRoot([
      {path : '', component : SearchFlightComponent},
      {path : 'viewFlightResults', component : ViewFlightResultComponent},
      {path : 'viewFlightResults/viewFlight/:flightId', component : ViewFlightComponent},
      {path : 'viewFlightResults/viewFlight/:flightId/bookFlight/:flightId', redirectTo: 'bookFlight/:flightId',  pathMatch: 'full'},
      {path : 'bookFlight/:flightId', component : BookFlightComponent},
      {path : 'bookFlight/:flightId/flight/:flightId/addFriendToFlight',
      redirectTo: 'flight/:flightId/addFriendToFlight',  pathMatch: 'full'},
      {path : 'flight/addFriendToFlight/:flightId', component : AddFriendToFlightComponent},
      {path : 'flight/addPassengerDetails/:flightId', component : AddPassengerDetailsComponent}
    ])

  ],
  providers: [FlightService, AirlineService, SearchFlightParams],
  bootstrap: [AppComponent]
})
export class AppModule {}
