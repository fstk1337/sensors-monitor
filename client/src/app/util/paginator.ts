import { Injectable } from "@angular/core";
import { MatPaginatorIntl } from "@angular/material/paginator";


@Injectable()
export class MatPaginatorIntlCustom extends MatPaginatorIntl {
    override itemsPerPageLabel = 'Sensor per screen';
    override nextPageLabel = 'Next';
    override previousPageLabel = 'Previous';

    override getRangeLabel = (page: number, pageSize: number, length: number) => {
        if (length === 0 || pageSize === 0) {
            return '-';
        }
        return 'Page ' + (page + 1);
    }
};