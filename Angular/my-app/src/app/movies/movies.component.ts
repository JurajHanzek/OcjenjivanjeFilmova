import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {
  public movies: Movie[];
  constructor(private movieService:MovieService) {this.movies = []; }

  ngOnInit(): void {
    this.getMovies();
  }

  public getMovies(): void{
    this.movieService.getMovies().subscribe(
      (response: Movie[]) =>{
        this.movies = response;
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }

}
