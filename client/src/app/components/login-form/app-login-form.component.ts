import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { AuthRequest } from 'src/app/interface/auth-request';
import { AuthResponse } from 'src/app/interface/auth-response';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './app-login-form.component.html',
  styleUrls: ['./app-login-form.component.css']
})

export class AppLoginFormComponent {
  message: string = 'enter login and password for access';
  login = new FormControl('');
  password = new FormControl('');
  token = '';
  user: AuthRequest = {
    username: null,
    password: null
  };

  constructor(private authService: AuthService) {}

  Login(event: SubmitEvent) {
    event.preventDefault();
    this.user.username = this.login.value;
    this.user.password = this.password.value;
    
    this.authService.auth(this.user).subscribe(
      (response: AuthResponse) => this.token = response.token,
      (error: any) => console.log(error),
      () => {
        console.log('Success.');
        localStorage.setItem('token', this.token);
        const result = this.authService.parseToken(this.token); 
        console.log(result);
      }
    );

    this.login.setValue('');
    this.password.setValue('');
  }
}
