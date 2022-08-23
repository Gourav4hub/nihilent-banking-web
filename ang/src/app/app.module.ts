import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import {HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { TopmenuComponent } from './topmenu/topmenu.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RoleComponent } from './admin/role/role.component';
import { UserComponent } from './admin/user/user.component';
import { AccounttypeComponent } from './admin/accounttype/accounttype.component';
import { BankComponent } from './admin/bank/bank.component';
import { BankofficerComponent } from './bank/bankofficer/bankofficer.component';
import { CustomerComponent } from './bank/customer/customer.component';
import { TransactionsComponent } from './customer/transactions/transactions.component';
import { TransferComponent } from './customer/transfer/transfer.component';
import { AccountComponent } from './customer/account/account.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    TopmenuComponent,
    HomeComponent,
    LoginComponent,
    RoleComponent,
    UserComponent,
    AccounttypeComponent,
    BankComponent,
    BankofficerComponent,
    CustomerComponent,
    TransactionsComponent,
    TransferComponent,
    AccountComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
