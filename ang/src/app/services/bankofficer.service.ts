import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BankofficerService {

  constructor(private http:HttpClient) { }

  public saveBankOfficer(data:any)
  {
    return this.http.post("/api/bankOfficer/save",data)
  }

  public listBankOfficers()
  {
    return this.http.get("/api/bankOfficer/list")
  }
}
