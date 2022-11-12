import { HttpErrorResponse, HttpHandler } from '@angular/common/http';
import { AfterViewInit } from '@angular/core';
import { Component, OnInit, ViewChild } from '@angular/core';
import { NgbCarousel, NgbSlideEvent, NgbSlideEventSource } from '@ng-bootstrap/ng-bootstrap';
import { Actor } from '../actor';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';
import { MovieRating } from '../movieRating';
import { Ocjene } from '../ocjene';
declare var jQuery: any;

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit  {

  paused = false;
  unpauseOnArrow = false;
  pauseOnIndicator = false;
  pauseOnHover = true;
  pauseOnFocus = true;
  show = false;

  @ViewChild('carousel', { static: true })
  carousel!: NgbCarousel;
  togglePaused() {
    if (this.paused) {
      this.carousel.cycle();
    } else {
      this.carousel.pause();
    }
    this.paused = !this.paused;
  }

  onSlide(slideEvent: NgbSlideEvent) {
    if (this.unpauseOnArrow && slideEvent.paused &&
      (slideEvent.source === NgbSlideEventSource.ARROW_LEFT || slideEvent.source === NgbSlideEventSource.ARROW_RIGHT)) {
      this.togglePaused();
    }
    if (this.pauseOnIndicator && !slideEvent.paused && slideEvent.source === NgbSlideEventSource.INDICATOR) {
      this.togglePaused();
    }
  }
  

  title(title: any) {
    throw new Error('Method not implemented.');
  }
  public ocjene: Ocjene[];
  public movies: Movie[];
  public movieRatings: MovieRating[];
  public actors: Actor[];
  constructor(private movieService:MovieService){
    this.movies = [];
    this.actors = [];
    this.movieRatings = [];
    this.ocjene = [];
  }
 
    
 
  
  ngOnInit(){
    this.getMovies();
    this.getActors();
    this.getMovieRatings();
    this.getOcjene();
  }


  public getMovies(): void{
    this.movieService.getMovies().subscribe(
      (response: Movie[]) =>{
        this.movies = response;
      },
      (error: HttpErrorResponse)=>{
        console.log(error.message);
      }
    )
  }

  public getOcjene(): void{
    this.movieService.getOcjene().subscribe(
      (response: Ocjene[]) =>{
        this.ocjene = response;
      },
      (error: HttpErrorResponse)=>{
        console.log(error.message);
      }
    )
   
  }

  public getMovieRatings(): void{
    this.movieService.getMovieRatings().subscribe(
      (response: MovieRating[]) =>{
        this.movieRatings = response;
      },
      (error: HttpErrorResponse)=>{
        console.log(error.message);
      }
    )
  }


  public getActors(): void{
    this.movieService.getActors().subscribe(
      (response: Actor[]) =>{
        this.actors = response;
      },
      (error: HttpErrorResponse)=>{
        console.log(error.message);
      }
    )
  }
}
