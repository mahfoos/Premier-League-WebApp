import { RandomMatchService } from '../../services/random-match.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-random-match',
  templateUrl: './random-match.component.html',
  styleUrls: ['./random-match.component.css']
})
export class RandomMatchComponent implements OnInit {

  randomTable : any;

  constructor(private randomService : RandomMatchService) { }

  ngOnInit(){
    this.randomService.getRandomMatch().subscribe((data) =>{
      // @ts-ignore
      this.randomTable = data.response;
    })
  }

  randomMatchGenerate(): void {
    this.randomService.getRandomMatch()
      .subscribe((data) => {
        // @ts-ignore
        this.randomTable = data.response;
      });
  }}








