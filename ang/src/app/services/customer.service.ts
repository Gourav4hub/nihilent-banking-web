import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  constructor(private http:HttpClient) { }

  public saveCustomer(data:any)
  {
    return this.http.post("/api/customer/save",data)
  }

  public listCustomer()
  {
    return this.http.get("/api/customer/list")
  }

  public getCustomer(name:string)
  {
    return this.http.post("/api/customer/getByUserName",{name})
  }

  public getCustomerByUpi(upi:string)
  {
    return this.http.post("/api/customer/getByUpi",{upi})
  }

  public sendAmount(data:any)
  {
    return this.http.post("/api/customer/sendamount",data)
  }

  public getTransactions(name:string)
  {
    return this.http.post("/api/customer/getTransactions",{name})
  }

}
