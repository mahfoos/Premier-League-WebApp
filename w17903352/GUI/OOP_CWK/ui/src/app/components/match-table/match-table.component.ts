import { MatchTableService } from '../../services/match-table.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-match-table',
  templateUrl: './match-table.component.html',
  styleUrls: ['./match-table.component.css']
})
export class MatchTableComponent implements OnInit {
  footballClubMatch : any;
  dateArray="";
  constructor(private matchService : MatchTableService ) { }

  ngOnInit() {
    this.matchService.getMatchTable()
      .subscribe((data) =>{
        // @ts-ignore
        this.footballClubMatch = data.response;
      })
  }

  sortByDate(): void {
    this.matchService.sortDate()
      .subscribe((data) => {
        // @ts-ignore
        this.footballClubMatch = data.response;
      })


  }



}
