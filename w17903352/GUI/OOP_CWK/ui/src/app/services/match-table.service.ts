import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MatchTableService {


  constructor(private httpRequest : HttpClient) { }

  getMatchTable(){
    return this.httpRequest.get("http://localhost:9000/getMatch");
  }

  sortDate(){
    return this.httpRequest.get("http://localhost:9000/getDate");
  }
}
