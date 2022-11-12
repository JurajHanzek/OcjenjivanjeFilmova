import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActorDetailsComponent } from './actor-details/actor-details.component';
import { ActorsComponent } from './actors/actors.component';
import { DodajComponent } from './dodaj/dodaj.component';
import { ForbiddenPageComponent } from './forbidden-page/forbidden-page.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { MovieDetailsComponent } from './movie-details/movie-details.component';
import { MoviesComponent } from './movies/movies.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { UpdateComponent } from './update/update.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'actors-component', component: ActorsComponent },
  { path: 'home-component', component: HomeComponent },
  { path: 'movies-component', component: MoviesComponent },
  { path: 'movie-details-component/:id', component: MovieDetailsComponent },
  { path: 'actor-details-component/:id', component: ActorDetailsComponent },
  { path: 'dodaj-component',component: DodajComponent },
  { path: 'update-component/:id',component: UpdateComponent },
  { path: 'forbidden',component: ForbiddenPageComponent },
  { path: '', redirectTo: 'home-component', pathMatch: 'full'},
  { path: '**', component: PageNotFoundComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
