import { Component } from "@angular/core";
import { Router } from "@angular/router";

@Component({
    selector: 'sensor-table',
    templateUrl: './sensor-table.component.html',
    styleUrls: ['./sensor-table.component.css']
})  
export class SensorTableComponent {
    constructor(private router: Router) {}

    logout() {
        localStorage.removeItem('token');
        this.router.navigate(['/login']);
    }
};