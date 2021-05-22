import { Component, OnInit } from '@angular/core';
import { PointsTableService } from 'src/app/services/points-table.service';

@Component({
  selector: 'app-points-table',
  templateUrl: './points-table.component.html',
  styleUrls: ['./points-table.component.css']
})
export class PointsTableComponent implements OnInit {

  matchTable : any;
  constructor(private pointsService : PointsTableService) { }


  ngOnInit(){
    this.pointsService.getAllClubDetails().subscribe((data) =>{
      // @ts-ignore
      this.matchTable = data.response;
    })
  }

}
