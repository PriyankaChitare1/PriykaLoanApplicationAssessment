import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Loan } from '../models/loan';
import { Customer } from '../models/customer';
import { PaymentSchedule } from '../models/paymentSchedule';

@Injectable({
  providedIn: 'root'
})

export class LoanService {

  private customerUrl = 'http://localhost:8080/customer/';
  private paymentUrl = 'http://localhost:8080/payment/';
  private baseUrl = 'http://localhost:8080/loan/';

  constructor(private http: HttpClient) { }

  CustomerVerfication(email: string, password: string): Observable<Customer> {
    let params = new HttpParams();
    params = params.append('email', email);
    params = params.append('password', password);
    return this.http.get<Customer>(`${this.customerUrl}` + '/customer-Verification', { params:  params });
  }

  getCustomerDetails(customerId: string): Observable<Customer> {
    return this.http.get<Customer>(`${this.customerUrl}` + '/customer/' + `${customerId}`);
  }

  saveCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(`${this.customerUrl}` + '/addCustomer', customer);
  }

  getLoanList(customerId: string): Observable<Loan[]> {
    return this.http.get<Loan[]>(`${this.baseUrl}` + '/loan/' + `${customerId}`);
  }

  saveLoan(loan: object): Observable<Loan> {
    return this.http.post<Loan>(`${this.baseUrl}` + '/addloan', loan);
  }


  getLoanDetails(loanId:string): Observable<Loan>{
    return this.http.get<Loan>(`${this.paymentUrl}` + '/loan-details/' + `${loanId}`);
  }

  getPaymentSchedule(loanId: string): Observable<PaymentSchedule[]> {
    return this.http.get<PaymentSchedule[]>(`${this.paymentUrl}` + '/loan/payment-schedule/' + `${loanId}`);
  }

  updatePaymentStatus(paymentId:any){
    return this.http.put<PaymentSchedule>(`${this.paymentUrl}`+`/update-payment/`+`${paymentId}`,null);
  }


}