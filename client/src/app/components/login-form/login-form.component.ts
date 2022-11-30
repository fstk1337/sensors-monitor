import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthRequest } from 'src/app/interfaces/auth-request';
import { AuthResponse } from 'src/app/interfaces/auth-response';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})

export class LoginFormComponent {
  message: string = 'enter login and password for access';
  login = new FormControl('');
  password = new FormControl('');
  token = '';
  user: AuthRequest = {
    username: null,
    password: null
  };

  constructor(private authService: AuthService, private router: Router) {}

  Login(event: SubmitEvent) {
    event.preventDefault();
    this.user.username = this.login.value;
    this.user.password = this.password.value;
    
    this.authService.auth(this.user).subscribe(
      (response: AuthResponse) => this.token = response.token,
      (error: any) => console.log(error),
      () => {
        localStorage.setItem('token', this.token);
        const result = this.authService.parseToken(this.token); 
        console.log(result);
        this.router.navigate(['/sensors']);
      }
    );

    this.login.setValue('');
    this.password.setValue('');
  }
}
