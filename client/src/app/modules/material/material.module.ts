import { NgModule } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTooltipModule } from '@angular/material/tooltip';

@NgModule({
    declarations: [],
    exports: [
      MatFormFieldModule,
      MatInputModule,
      MatButtonModule,
      MatToolbarModule,
      MatTableModule,
      MatIconModule,
      MatPaginatorModule,
      MatTooltipModule
    ],
    providers: []
  })
  export class AppMaterialModule { }