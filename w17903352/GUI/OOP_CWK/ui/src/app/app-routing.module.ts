import { RandomMatchComponent } from './components/random-match/random-match.component';
import { MatchTableComponent } from './components/match-table/match-table.component';
import { PointsTableComponent } from './components/points-table/points-table.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path : '',redirectTo:'points_table',pathMatch : 'full'},
  {path : 'points_table', component : PointsTableComponent},
  {path : 'match_table' , component : MatchTableComponent},
  {path : 'random_match', component : RandomMatchComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
