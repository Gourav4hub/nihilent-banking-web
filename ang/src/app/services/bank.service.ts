import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BankService {

  constructor(private http:HttpClient) { }

  public saveBank(data:any)
  {
    return this.http.post("/api/bank/save",data)
  }

  public listBanks()
  {
    return this.http.get("/api/bank/list")
  }
}
