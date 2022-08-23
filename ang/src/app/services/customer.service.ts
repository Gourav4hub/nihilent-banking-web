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
}
