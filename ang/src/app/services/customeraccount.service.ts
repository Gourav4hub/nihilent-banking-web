import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CustomeraccountService {
  constructor(private http:HttpClient) { }

  public saveAccount(data:any)
  {
    return this.http.post("/api/customer/addAccount",data)
  }
}
