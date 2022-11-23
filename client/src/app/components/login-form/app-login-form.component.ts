import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';

interface User {
  username: string | null;
  password: string | null;
};

@Component({
  selector: 'app-login-form',
  templateUrl: './app-login-form.component.html',
  styleUrls: ['./app-login-form.component.css']
})

export class AppLoginFormComponent {
  message: string = 'enter login and password for access';
  login = new FormControl('');
  password = new FormControl('');
  user: User = {
    username: null,
    password: null
  };

  Login(event: SubmitEvent) {
    event.preventDefault();
    this.user.username = this.login.value;
    this.user.password = this.password.value;
    // TODO: send User to backend for auth
    this.login.setValue('');
    this.password.setValue('');
  }
}
