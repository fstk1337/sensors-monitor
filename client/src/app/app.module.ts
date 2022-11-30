import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginFormComponent } from './components/login-form/login-form.component';

import { AppRouterModule } from './modules/router/router.module';
import { AppMaterialModule } from './modules/material/material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SensorTableComponent } from './components/sensor-table/sensor-table.component';
import { MatPaginatorIntl } from '@angular/material/paginator';
import { MatPaginatorIntlCustom } from './util/paginator';

@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    SensorTableComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRouterModule,
    AppMaterialModule
  ],
  providers: [
    {
      provide: MatPaginatorIntl,
      useClass: MatPaginatorIntlCustom
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
