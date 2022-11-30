import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SensorTableComponent } from 'src/app/components/sensor-table/sensor-table.component';
import { LoginFormComponent } from '../../components/login-form/login-form.component';

const routes: Routes = [
  { path: 'login', component: LoginFormComponent },
  { path: 'sensors', component: SensorTableComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRouterModule { }
