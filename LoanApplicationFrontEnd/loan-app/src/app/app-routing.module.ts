import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ApplyloanComponent } from './component/applyloan/applyloan.component';
import { CustomerLoanDetailsComponent } from './component/customer-loan-details/customer-loan-details.component';
import { CustomerdetailsComponent } from './component/customerdetails/customerdetails.component';
import { LoginComponent } from './component/login/login.component';
import { PaymentScheduleComponent } from './component/payment-schedule/payment-schedule.component';
import { SignupComponent } from './component/signup/signup.component';
import { RouteGuardService } from './service/route-guard.service';

const routes: Routes = [
  {path:'', component:LoginComponent },
  {path:'login', component: LoginComponent },
  {path: 'home', component : CustomerLoanDetailsComponent, canActivate:[RouteGuardService] },
  {path: 'applyloan',component : ApplyloanComponent, canActivate:[RouteGuardService]},
  {path:'customerdetails',component : CustomerdetailsComponent, canActivate:[RouteGuardService] },
  { path: 'payment-schedule', component: PaymentScheduleComponent ,canActivate : [RouteGuardService]},
  { path: 'signup', component: SignupComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
