import { ChangeDetectorRef, Component, OnInit, ViewChild } from "@angular/core";
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
export class SensorTableComponent implements OnInit {
    filterValue = '';
    dataSource = new MatTableDataSource<Sensor>();
    displayedColumns: string[] = ['edit','name', 'model', 'type', 'range', 'unit', 'location', 'delete'];

    @ViewChild(MatPaginator) paginator: MatPaginator = new MatPaginator(new MatPaginatorIntl(), ChangeDetectorRef.prototype);

    constructor(private sensorService: SensorService, private router: Router) {}

    fetchSensors() {
        this.sensorService.getAllSensors().subscribe(
            (response: Array<Sensor>) => {
                this.dataSource.data = response;
            },
            (error: any) => console.log(error),
            () => {
                this.dataSource.paginator = this.paginator;
            }
          );
    }

    ngOnInit(): void {
        this.fetchSensors();
    }

    applyFilter() {
        this.dataSource.filter = this.filterValue.trim().toLowerCase();
    }

    clearFilter() {
        this.filterValue = '';
        this.dataSource.filter = '';
    }

    logout() {
        localStorage.removeItem('token');
        this.router.navigate(['/login']);
    }
};