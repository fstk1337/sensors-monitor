import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environment/environment";
import { Sensor } from "../interfaces/sensor";

@Injectable({ providedIn: 'root' })
export class SensorService {
    private url = environment.apiUrl;
    private headers = {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${localStorage.getItem('token')}`
    };

    constructor(private http: HttpClient) {}

    getAllSensors(): Observable<Array<Sensor>> {
        return this.http.get<Array<Sensor>>(`${this.url}/sensors`, {
            headers: this.headers,
            responseType: 'json',
            withCredentials: false
        });
    }
}