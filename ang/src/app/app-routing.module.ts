import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

import { AccounttypeComponent } from './admin/accounttype/accounttype.component';
import { BankComponent } from './admin/bank/bank.component';
import { RoleComponent } from './admin/role/role.component';
import { UserComponent } from './admin/user/user.component';
import { BankofficerComponent } from './bank/bankofficer/bankofficer.component';
import { CustomerComponent } from './bank/customer/customer.component';
import { TransactionsComponent } from './customer/transactions/transactions.component';
import { TransferComponent } from './customer/transfer/transfer.component';
import { CustomeraccountComponent } from './bank/customeraccount/customeraccount.component';
import { AccountviewComponent } from './customer/accountview/accountview.component';

const routes: Routes = [
  {path:"" , component:LoginComponent},
  {path:"home" , component:HomeComponent},

  {path:"acttypes" , component:AccounttypeComponent},
  {path:"banks" , component:BankComponent},
  {path:"roles" , component:RoleComponent},
  {path:"users" , component:UserComponent},

  {path:"officers" , component:BankofficerComponent},
  {path:"customers" , component:CustomerComponent},
  {path:"addaccount/:id",component:CustomeraccountComponent},

  {path:"transactions" , component:TransactionsComponent},
  {path:"transfer" , component:TransferComponent},
  {path:"account" , component:AccountviewComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
