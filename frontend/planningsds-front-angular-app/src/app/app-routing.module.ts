import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SportsComponent } from './sports/sports.component';

const routes: Routes = [
  { path : "sports", component : SportsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
