import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthRequest } from '../interface/auth-request';
import { AuthResponse } from '../interface/auth-response';
import { environment } from 'src/environment/environment';
import { AuthDetails } from '../interface/auth-details';

import jwt_decode from '../util/jwt-util';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private url = environment.apiUrl;
  private headers = {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  };

  constructor(private http: HttpClient) {}

  auth(credentials: AuthRequest): Observable<AuthResponse> {
    return this.http.post<AuthResponse>(`${this.url}/auth`, credentials, {
      headers: this.headers,
      observe: 'body',
      responseType: 'json',
      withCredentials: false
    });
  }

  parseToken(token: string): AuthDetails {
    const secret = atob(environment.secret);
    const result = jwt_decode(token, secret);
    const { sub, role, exp, iat } = result;
    return {
      username: sub,
      role,
      issued: new Date(iat * 1000),
      expires: new Date(exp * 1000)
    };
  }
}

