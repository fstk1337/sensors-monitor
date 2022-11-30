import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthRequest } from '../interfaces/auth-request';
import { AuthResponse } from '../interfaces/auth-response';
import { environment } from 'src/environment/environment';
import { AuthDetails, TokenPayload } from '../interfaces/auth-details';

import jwtDecode from 'jwt-decode';

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
    const result: TokenPayload = jwtDecode(token, { header: false });
    const { sub, role, exp, iat } = result;
    const parsed: AuthDetails = {
      username: sub ? sub : '',
      role: role? role : '',
      issued: new Date(iat? iat * 1000 : 0),
      expires: new Date(exp? exp * 1000 : 0)
    };
    return parsed;
  }
}

