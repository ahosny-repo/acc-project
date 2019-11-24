import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CustomerService } from '../customer.service';
import { Customer } from '../customer';
import { Router } from '@angular/router';
import { MatInputModule, MatPaginatorModule, MatProgressSpinnerModule, 
         MatSortModule, MatTableModule,MatTableDataSource } from "@angular/material";
import { FormControl,ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: Customer[];
  
  dataSource = new MatTableDataSource();
  
  displayedColumns = ['customerName', 'customerAddress', 'carId', 'carRegNumber','carStatus'];

  nameFilter = new FormControl();
  statusFilter = new FormControl();

  filteredValues = { customerName:'', carStatus:'', topFilter: false};
  
  constructor(private customerService: CustomerService,
    private router: Router) { }

  ngOnInit() { 
  	this.reloadData();
  } 
  
  reloadData() {
       
    this.nameFilter.valueChanges.subscribe((nameFilterValue) => {
    this.filteredValues['customerName'] = nameFilterValue;
    this.dataSource.filter = JSON.stringify(this.filteredValues);
    this.filteredValues['topFilter'] = false;
    });

    this.statusFilter.valueChanges.subscribe((statusFilterValue)        => {
    this.filteredValues['carStatus'] = statusFilterValue;
    this.dataSource.filter = JSON.stringify(this.filteredValues);
    this.filteredValues['topFilter'] = false;
    });
      
      this.customerService.getCustomerList().subscribe(data => {
      this.customers = data;
      this.dataSource.data = this.customers;
      this.dataSource.filterPredicate = this.customFilterPredicate();
    });
  }

 
  applyFilter(filterValue: string) {
    let filter = {
      customerName: filterValue.trim().toLowerCase(),
      carStatus: filterValue.trim().toLowerCase(),
      topFilter: true
    }
    this.dataSource.filter = JSON.stringify(filter)
  }
  
  
  customFilterPredicate() {
    const myFilterPredicate = function(data:Customer,filter:string) :boolean {
      let searchString = JSON.parse(filter);
      let nameFound = data.customerName.toString().trim().toLowerCase().indexOf(searchString.customerName.toLowerCase()) !== -1
      let statusFound = data.carStatus.toString().trim().toLowerCase().indexOf(searchString.carStatus.toLowerCase()) !== -1
      if (searchString.topFilter) {
          return nameFound || statusFound 
      } else {
          return nameFound && statusFound 
      }
    }
    return myFilterPredicate;
  }
}