import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RandomMatchService {

  constructor(private httpRequest : HttpClient) { }

  getRandomMatch(){
    return this.httpRequest.get("http://localhost:9000/getRandom");
  }
}
