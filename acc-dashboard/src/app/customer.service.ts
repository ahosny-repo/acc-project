import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './customer'; 

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

 private baseUrl = 'http://localhost:8088';
 
  constructor(private http: HttpClient) { }
  
  public getCustomer(id: string): Observable<Customer> {
    return this.http.get<Customer>('http://localhost:8088/acc/customers/id/${id}');
  }
  
    public getCar(id: string): Observable<Customer> {
    return this.http.get<Customer>('http://localhost:8088/acc/cars/carid/${carid}');
  }
  
  public getCustomerList(): Observable<Customer[]> {
  return this.http.get<Customer[]>('http://localhost:8088/acc/customercars');
  }
}
