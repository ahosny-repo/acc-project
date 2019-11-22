import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CustomerService } from '../customer.service';
import { Customer } from '../customer';
import { Router } from '@angular/router';


@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: Customer[];

  constructor(private customerService: CustomerService,
    private router: Router) { }

  ngOnInit() {
  	this.reloadData();
  }

  reloadData() {
      this.customerService.getCustomerList().subscribe(data => {
      this.customers = data;
    });
  }

}
