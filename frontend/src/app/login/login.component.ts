import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthTokenService } from '../services/auth-token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  model:LoginViewModel = {
    username: '',
    password: ''
  }

  paramActivated: string;
  currentUser: string = "currentUser";

  constructor(private http: HttpClient, private route: ActivatedRoute, private authToken: AuthTokenService,
    private router: Router) {
  }

  ngOnInit() {
    if(this.route.snapshot.queryParams['activation_id']) {
      this.route.queryParams.subscribe(params => {
        this.paramActivated = params['activation_id'];
      });

      this.sendActivationId();
    }
  }

  sendActivationId() : void {
    let url = "http://localhost:8836/auth/activateAcc";

    this.http.post(url, this.paramActivated).subscribe(
      res => {
        alert("Account activated!");
      },
      err => {
        alert("Error has occured while activating account!");
      }
    );
  }

  sendLogin() : void{
    let url = "http://localhost:8836/auth/login";

    this.http.post(url, this.model).subscribe(
      (res : LoginStatus) => {
        this.authToken.setJwtToken(res.jwt);
        localStorage.setItem(this.currentUser, res.username);
        alert("Logged in!");
        this.router.navigate(['/']);
      },
      err => {
        alert("Error has occured while logging in!");
      }
    );
  }

}

export interface LoginViewModel {
  username: string;
  password: string;
}

export interface LoginStatus {
  username : string;
  jwt : string;
  expiresIn: number;
}