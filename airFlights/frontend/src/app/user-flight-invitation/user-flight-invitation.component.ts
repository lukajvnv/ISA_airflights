import { Component, OnInit, Input } from '@angular/core';
import { User } from '../models/user.model';

@Component({
  selector: 'app-user-flight-invitation',
  templateUrl: './user-flight-invitation.component.html',
  styleUrls: ['./user-flight-invitation.component.css']
})
export class UserFlightInvitationComponent implements OnInit {

  @Input()
  currentUser: User;

  constructor() { }

  ngOnInit() {
  }

}
