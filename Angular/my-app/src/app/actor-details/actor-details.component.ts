import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { Actor } from '../actor';
import { Character } from '../character';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-actor-details',
  templateUrl: './actor-details.component.html',
  styleUrls: ['./actor-details.component.css']
})
export class ActorDetailsComponent implements OnInit {
  id;
  actor: Actor = {} as Actor;
  public movies: Movie[];
  public char: Character[];
  constructor(private _Activatedroute:ActivatedRoute,private _router:Router,private movieService:MovieService,public sanitizer: DomSanitizer) { 
    this.movies = [];
    this.char = [];
  }
  sub;
  ngOnInit(): void {
    this.sub=this._Activatedroute.paramMap.subscribe(params => { 
      this.id = params.get('id'); 
      this.movieService.getActorByID(this.id).subscribe(
       (response: Actor) =>{
         this.actor = response;
         this.getMoviesByActorID(this.actor.idActors);
         this.getCharactersByActorID(this.actor.idActors);
       },
       (error: HttpErrorResponse)=>{
         console.log(error.message);
       }
     )
 });

}

public getMoviesByActorID(id): void{
  this.movieService.getMoviesByActorID(id).subscribe(
    (response: Movie[]) =>{
      this.movies = response;
    },
    (error: HttpErrorResponse)=>{
      console.log(error.message);
    }
  )
}
public getCharactersByActorID(id): void{
  this.movieService.getCharactersByActorID(id).subscribe(
    (response: Character[]) =>{
      this.char = response;
    },
    (error: HttpErrorResponse)=>{
      console.log(error.message);
    }
  )
}
}
