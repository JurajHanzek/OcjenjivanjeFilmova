import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { ViewChild } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { NgbCarousel, NgbSlideEvent, NgbSlideEventSource } from '@ng-bootstrap/ng-bootstrap';
import { Actor } from './actor';
import { Movie } from './movie';
import { MovieService } from './movie.service';
declare var $: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
 
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
  public movies: Movie[];
  public actors: Actor[];
  constructor(private movieService:MovieService){
    this.movies = [];
    this.actors = [];
  }

  ngOnInit(){
    this.getMovies();
    this.getActors();
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
