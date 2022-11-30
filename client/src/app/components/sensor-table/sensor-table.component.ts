import { AfterViewInit, ChangeDetectorRef, Component, OnInit, ViewChild } from "@angular/core";
import { MatPaginator, MatPaginatorIntl } from "@angular/material/paginator";
import { MatTableDataSource } from "@angular/material/table";
import { Router } from "@angular/router";
import { Sensor } from "src/app/interfaces/sensor";
import { SensorService } from "src/app/services/sensor.service";

@Component({
    selector: 'sensor-table',
    templateUrl: './sensor-table.component.html',
    styleUrls: ['./sensor-table.component.css']
})  
export class SensorTableComponent implements OnInit, AfterViewInit {
    filterValue = '';
    sensors = new MatTableDataSource<Sensor>();
    displayedColumns: string[] = ['name', 'model', 'type', 'range', 'unit', 'location'];

    @ViewChild(MatPaginator) paginator: MatPaginator = new MatPaginator(new MatPaginatorIntl(), ChangeDetectorRef.prototype);

    ngAfterViewInit() {
        this.sensors.paginator = this.paginator;
    }

    constructor(private sensorService: SensorService, private router: Router) {}

    fetchSensors() {
        this.sensorService.getAllSensors().subscribe(
            (response: Array<Sensor>) => this.sensors.data = response,
            (error: any) => console.log(error),
            () => {
                console.log('that is it');
            }
          );
    }

    ngOnInit(): void {
        this.fetchSensors();
    }

    applyFilter() {
        this.sensors.filter = this.filterValue.trim().toLowerCase();
    }

    logout() {
        localStorage.removeItem('token');
        this.router.navigate(['/login']);
    }
};