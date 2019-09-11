import { DestinationService } from './services/destination.service';
import { DateTimePipe } from './utils/date-time.pipe';
import { DepTimeArrTimePipe } from './utils/dep-time-arr-time.pipe';
import { AirlineService } from './services/airline.service';
import { FlightService } from './services/flight.service';
import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
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
import { RegistrationComponent } from './registration/registration.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LoginComponent } from './login/login.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UserReservationsComponent } from './user-reservations/user-reservations.component';
import { UserFriendsComponent } from './user-friends/user-friends.component';
import { UserFriendRequestComponent } from './user-friend-request/user-friend-request.component';
import { UserBasicInfoComponent } from './user-basic-info/user-basic-info.component';
import { CarComponent } from './rentacar/car/car.component';
import { UserFlightInvitationComponent } from './user-flight-invitation/user-flight-invitation.component';
import { RentabranchComponent } from './rentacar/rentabranch/rentabranch.component';
import { ViewRentacarComponent } from './rentacar/view-rentacar/view-rentacar.component';
import { NewRentabranchComponent } from './rentacar/new-rentabranch/new-rentabranch.component';
import { UpdateRentacarComponent } from './rentacar/update-rentacar/update-rentacar.component';

import { UserFlightComfirmationComponent } from './user-flight-comfirmation/user-flight-comfirmation.component';
import { ViewAirlineFlightConfigureComponent } from './avio/view-airline-flight-configure/view-airline-flight-configure.component';
import { ViewAirlineTicketsComponent } from './avio/view-airline-tickets/view-airline-tickets.component';
import { NewCarComponent } from './rentacar/new-car/new-car.component';

import { SearchRentacarComponent } from './rentacar/search-rentacar/search-rentacar.component';
import { ViewAllAirlinesComponent } from './avio/view-all-airlines/view-all-airlines.component';
import { CancelReservationComponent } from './cancel-reservation/cancel-reservation.component';
import { HotelModule } from './hotel/hotel.module';
import { SviHoteliComponent } from './hotel/components/svi-hoteli/svi-hoteli.component';
import { HotelComponent } from './hotel/components/hotel/hotel.component';
import { DodajUsluguComponent } from './hotel/components/dodaj-uslugu/dodaj-uslugu.component';
import { CeneNocenjaComponent } from './hotel/components/cene-nocenja/cene-nocenja.component';
import { HotelProfilnaComponent } from './hotel/components/hotel-profilna/hotel-profilna.component';
import { RezervacijaSobeComponent } from './hotel/components/rezervacija-sobe/rezervacija-sobe.component';
import { SobeNaPopustuComponent } from './hotel/components/sobe-na-popustu/sobe-na-popustu.component';
import { GrafikPosecenostiComponent } from './hotel/components/grafik-posecenosti/grafik-posecenosti.component';
import { DodajHotelComponent } from './hotel/components/dodaj-hotel/dodaj-hotel.component';
import { DodajSobuComponent } from './hotel/components/dodaj-sobu/dodaj-sobu.component';
import { AdminHotelaComponent } from './hotel/components/admin-hotela/admin-hotela.component';


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
    AvioAnalyticsIncomeComponent,
    RegistrationComponent,
    PageNotFoundComponent,
    LoginComponent,
    UserProfileComponent,
    UserReservationsComponent,
    UserFriendsComponent,
    UserFriendRequestComponent,
    UserBasicInfoComponent,
    CarComponent,
    UserFlightInvitationComponent,
    RentabranchComponent,
    ViewRentacarComponent,
    NewRentabranchComponent,
    UpdateRentacarComponent,
    UserFlightComfirmationComponent,
    ViewAirlineFlightConfigureComponent,
    ViewAirlineTicketsComponent,
    NewCarComponent,
    SearchRentacarComponent,
    ViewAllAirlinesComponent,
    CancelReservationComponent
  ],
  imports: [
    BrowserModule,
    HotelModule,
    AppRoutingModule,
    AngularFontAwesomeModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
    NgxBootstrapSliderModule,
    HttpClientModule,
    RouterModule.forRoot([
      {
        path: 'registration', component: RegistrationComponent
      },
      {
        path: '', component: CancelReservationComponent
      },
      {
        path: 'login',
        component: LoginComponent
      },
      {
        path: 'user',
        component: UserProfileComponent
      },
      {
        path: 'rentacar/addCar',
        component: CarComponent
      },
      {
        path: 'rentacar/addRentaBranch',
        component: RentabranchComponent
      },
      {
        path: 'rentacar/:rentacarId',
        component: ViewRentacarComponent
      },
      {
        path: 'rentacar/newBranch/:rentacarId',
        component: NewRentabranchComponent
      },
      {
        path: 'rentacar/newCar/:rentacarId',
        component: NewCarComponent
      },
      {
        path: 'rentacar/update/:rentacarId',
        component: UpdateRentacarComponent
      },
      {path : 'search', component : SearchFlightComponent},
      {
        path: 'searchRentacar',
        component: SearchRentacarComponent
      },
      {
        path: 'searchHotel',
        component: SviHoteliComponent
      },
      {
        path: 'hotel/:id',
        component: HotelProfilnaComponent
      },
      {
        path: 'hotelnk/:id',
        component: HotelComponent
      },
      {
        path: 'izmeniUslugu/:id',
        component: DodajUsluguComponent
      },
      {
        path: 'ceneNocenja/:id',
        component: CeneNocenjaComponent
      },
      {
        path: 'rezervacijaSoba/:id',
        component: RezervacijaSobeComponent
      },
      {
        path: 'sobeNaPopustu/:id',
        component: SobeNaPopustuComponent
      },
      {path: "dodajUslugu/:id", component: DodajUsluguComponent},
      {path: "dodajSobu/:id", component: DodajSobuComponent},
      {path: "izmeniSobu/:id", component: DodajSobuComponent},
      {path : "adminHotelProfile", component: AdminHotelaComponent},
      {path : "izmeniHotel/:id", component: DodajHotelComponent},
      {path : "grafikPosecenosti/:id", component: GrafikPosecenostiComponent},
      {path : 'flights/search', component : SearchFlightComponent},
      {path : 'analytics/:airlineId', component: AvioAnalyticsComponent},
      {path : 'analytics/marks/:airlineId', component: AvioAnalyticsMarksComponent },
      {path : 'analytics/report/:airlineId', component: AvioAnalyticsReportComponent },
      {path : 'analytics/income/:airlineId', component: AvioAnalyticsIncomeComponent },
      {path: 'airline/all', component: ViewAllAirlinesComponent},
      {path : 'airline/:airlineId', component: ViewAirlineComponent},
      {path : 'airline/flights/:airlineId', component: ViewAirlineFlightsComponent},
      {path : 'airline/tickets/:airlineId', component: ViewAirlineTicketsComponent},
      {path : 'airline/flight/configure/:flightId', component: ViewAirlineFlightConfigureComponent},
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
      {path: 'destination/new/:airlineId', component: NewDestinationComponent},
      {path: 'pricelist/new/:airlineId', component: NewPricelistComponent},
      {path:  'invitation/:reservationId', component: UserFlightComfirmationComponent},
      {
        path: '**',
        component: PageNotFoundComponent
      }
    ])
  ],
  providers: [FlightService, AirlineService, SearchFlightParams, DestinationService],
  bootstrap: [AppComponent]
})
export class AppModule {}
