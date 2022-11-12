import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { Actor } from '../actor';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { Director } from '../director';
import { MovieStudio } from '../movieStudio';
import { MovieRating } from '../movieRating';
import { Ocjene } from '../ocjene';
import { LoginService } from '../login/login.service';
import { UserService } from '../user/user.service';
import { User } from '../user/user.model';
import { user_rating } from '../user_rating';


@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {
  id;
  ukupno;
  public ocjene: Ocjene[];
  public users: User[];
  urlSafe: SafeResourceUrl;
  movie: Movie = {} as Movie;
  userRating: user_rating = {} as user_rating;
  ocjena: Ocjene = {} as Ocjene;
  public movieRatings: MovieRating[];
  director: Director = {} as Director;
  movieStudio: MovieStudio = {} as MovieStudio;
  public actors: Actor[];
  constructor(private _Activatedroute:ActivatedRoute,private _router:Router,private movieService:MovieService,public sanitizer: DomSanitizer,private loginService: LoginService,
    public userService: UserService,private router: Router) {

    this.actors = [];
    this.urlSafe ="";
    this.movieRatings = [];
    this.ocjene = [];
    this.users = [];
   }
  sub;
  ngOnInit(): void {
    this.userService.getCurrentUser().subscribe((currentUser: User) => {
      this.userService.currentUser = currentUser;
    });
    this.sub=this._Activatedroute.paramMap.subscribe(params => { 
       this.id = params.get('id'); 
       this.movieService.getMovieByID(this.id).subscribe(
        (response: Movie) =>{
          this.movie = response;
          this.getDirector(this.movie.directorId);
          this.getMovieStudio(this.movie.movieStudioid);
          this.getOcjena(this.movie.idMovie);
        },
        (error: HttpErrorResponse)=>{
          console.log(error.message);
        }
      )
  });

  this.getActors(this.id);
  this.urlSafe= this.sanitizer.bypassSecurityTrustResourceUrl(this.movie.trailerUrl);
  this.getMovieRatings();
  this.getOcjene();
  this.getUsers();

}
ngOnDestroy() {
  this.sub.unsubscribe();
}
public getUsers(): void{
  this.movieService.getUsers().subscribe(
    (response: User[]) =>{
      this.users = response;
    },
    (error: HttpErrorResponse)=>{
      console.log(error.message);
    }
  )
}

onBack(): void {
   this._router.navigate(['product']);
}

rate(): void {
  this.userRating.idMovie=this.movie.idMovie;
  this.userRating.idUser=this.userService.currentUser.id;

  this.movieService.rate(this.userRating).subscribe(
    () =>{
      console.log("rated");
    },
    (error: HttpErrorResponse)=>{
      console.log(error.message);
    }
  )

  window.location.reload();
}

erase() {
  this.movieService.erase(this.movie.idMovie).subscribe(
    (response: void) =>{
      console.log("erased");
    },
    (error: HttpErrorResponse)=>{
      console.log(error.message);
    }
  )
  this.router.navigate(['/home-component']);
  
}



public getActors(id): void{
  this.movieService.getActorsByMovie(id).subscribe(
    (response: Actor[]) =>{
      this.actors = response;
    },
    (error: HttpErrorResponse)=>{
      console.log(error.message);
    }
  )
}
public getDirector(id): void{
  this.movieService.getDirector(id).subscribe(
    (response: Director) =>{
      this.director = response;
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
public getOcjena(id): void{
  this.movieService.getOcjena(id).subscribe(
    (response: Ocjene) =>{
      this.ocjena = response;
      if(this.ocjena.rating==0){
        this.ukupno=(this.ocjena.imdbRating+this.ocjena.metacriticRating+this.ocjena.rottenRating)/3;
      }else{
        this.ukupno=(this.ocjena.rating+this.ocjena.imdbRating+this.ocjena.metacriticRating+this.ocjena.rottenRating)/4;
      }
     
      this.ukupno=Math.round(this.ukupno * 100) / 100
    },
    (error: HttpErrorResponse)=>{
      console.log(error.message);
    }
  )
}

public getMovieStudio(id): void{
  this.movieService.getMovieStudio(id).subscribe(
    (response: MovieStudio) =>{
      this.movieStudio = response;
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

}