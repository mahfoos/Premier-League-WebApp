import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PointsTableService {

  constructor(private httpRequest : HttpClient) { }

  getAllClubDetails(){
    return this.httpRequest.get("http://localhost:9000/pointsTable");
  }
}
