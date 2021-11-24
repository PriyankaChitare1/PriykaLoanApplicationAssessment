import { Injectable } from '@angular/core';
import { Customer } from '../models/customer';
import { LoanService } from './loan-service.service';


@Injectable({
  providedIn: 'root'
})
export class HardcodedAuthenticationService {
  private customer!: Customer;

  constructor(private loanService: LoanService) {

  }
  async authenticate(username: string, password: string) {
    this.customer = await this.loanService.CustomerVerfication(username, password).toPromise();

    if(this.customer .customerId!=null) {
      sessionStorage.setItem('authenticaterUser', username);
      return true;
    }
    return false;
  }
  getCustomerId(): string {
    return this.customer.customerId;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('authenticaterUser')
    return !(user === null)
  }
  logout(){
    sessionStorage.removeItem('authenticaterUser')
  }
}
