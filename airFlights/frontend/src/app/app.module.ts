import { DestinationService } from './services/destination.service';
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
import { NewFlightComponent } from './avio/new-flight/new-flight.component';
import { NewDestinationComponent } from './avio/new-destination/new-destination.component';
import { NewPricelistComponent } from './avio/new-pricelist/new-pricelist.component';
import { UpdateAirlineComponent } from './avio/update-airline/update-airline.component';
import { AvioAnalyticsComponent } from './avio/avio-analytics/avio-analytics.component';
import { ViewAirlineFlightsComponent } from './avio/view-airline-flights/view-airline-flights.component';
import { ViewAirlineFlightComponent } from './avio/view-airline-flight/view-airline-flight.component';
import { AvioAnalyticsMarksComponent } from './avio/avio-analytics-marks/avio-analytics-marks.component';
import { AvioAnalyticsReportComponent } from './avio/avio-analytics-report/avio-analytics-report.component';
import { AvioAnalyticsIncomeComponent } from './avio/avio-analytics-income/avio-analytics-income.component';


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
    AddPassengerDetailsComponent,
    NewFlightComponent,
    NewDestinationComponent,
    NewPricelistComponent,
    UpdateAirlineComponent,
    AvioAnalyticsComponent,
    ViewAirlineFlightsComponent,
    ViewAirlineFlightComponent,
    AvioAnalyticsMarksComponent,
    AvioAnalyticsReportComponent,
    AvioAnalyticsIncomeComponent
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
      {path : 'analytics/:airlineId', component: AvioAnalyticsComponent,  },
      {path : 'analytics/marks/:airlineId', component: AvioAnalyticsMarksComponent },
      {path : 'analytics/report/:airlineId', component: AvioAnalyticsReportComponent },
      {path : 'analytics/income/:airlineId', component: AvioAnalyticsIncomeComponent },
      {path : 'airline/:airlineId', component: ViewAirlineComponent},
      {path : 'airline/flights/:airlineId', component: ViewAirlineFlightsComponent},
      {path : 'airline/update/:airlineId', component: UpdateAirlineComponent},
      {path : 'airline/newFlight/:airlineId', component: NewFlightComponent},
      {path : 'airline/newFlight/update/:airlineId/:flightId', component: NewFlightComponent},
      {path : 'viewFlightResults', component : ViewFlightResultComponent},
      {path : 'viewFlightResults/viewFlight/:flightId', component : ViewFlightComponent},
      {path : 'viewFlightResults/viewFlight/:flightId/bookFlight/:flightId', redirectTo: 'bookFlight/:flightId',  pathMatch: 'full'},
      {path : 'bookFlight/:flightId', component : BookFlightComponent},
      {path : 'bookFlight/:flightId/flight/:flightId/addFriendToFlight',
      redirectTo: 'flight/:flightId/addFriendToFlight',  pathMatch: 'full'},
      {path : 'flight/addFriendToFlight/:flightId', component : AddFriendToFlightComponent},
      {path : 'flight/addPassengerDetails/:flightId', component : AddPassengerDetailsComponent},
      {path: 'destination/new', component: NewDestinationComponent},
      {path: 'pricelist/new', component: NewPricelistComponent}

    ])

  ],
  providers: [FlightService, AirlineService, SearchFlightParams, DestinationService],
  bootstrap: [AppComponent]
})
export class AppModule {}
