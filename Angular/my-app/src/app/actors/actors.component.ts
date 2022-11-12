import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Actor } from '../actor';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-actors',
  templateUrl: './actors.component.html',
  styleUrls: ['./actors.component.css']
})
export class ActorsComponent implements OnInit {
  public actors: Actor[];
  constructor(private movieService:MovieService) { this.actors = []; }

  ngOnInit(): void {
    this.getActors();
  }
  
  public getActors(): void{
    this.movieService.getActors().subscribe(
      (response: Actor[]) =>{
        this.actors = response;
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }
}
