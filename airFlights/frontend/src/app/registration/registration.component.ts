import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  model:RegistrationViewModel = {
    username: '',
    password: '',
    passwordCheck: '',
    firstName: '',
    lastName: '',
    email: '',
    city: '',
    phone_number: 0
  }

  constructor(private http: HttpClient) { 
  }

  ngOnInit() {
  }

  sendRegistration() : void{
    let url = "http://localhost:8836/api/registration";

    if(this.model.password === this.model.passwordCheck)
    {
      this.http.post(url, this.model).subscribe(
        res => {
          alert("Successful");
        },
        err => {
          alert("Error has occured while registering!");
        }
      );
    } else {
      alert("Password is incorrect!");
    }
  }

}

export interface RegistrationViewModel {
  username: string;
  password: string;
  passwordCheck: string,
  firstName: string;
  lastName: string;
  email: string;
  city: string;
  phone_number: number;
}
