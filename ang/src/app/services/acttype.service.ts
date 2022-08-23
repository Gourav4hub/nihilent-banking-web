import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ActtypeService {

  constructor(private http:HttpClient) { }

  public saveType(data:any)
  {
    return this.http.post("/api/acttype/save",data)
  }

  public listTypes()
  {
    return this.http.get("/api/acttype/list")
  }
}
