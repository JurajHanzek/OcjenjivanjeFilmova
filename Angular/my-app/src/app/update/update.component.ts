import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from '../login/login.service';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';
import { User } from '../user/user.model';
import { UserService } from '../user/user.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  id;
  movie: Movie = {} as Movie;
  movie2: Movie = {} as Movie;
  success:string ="";
  constructor(private _Activatedroute:ActivatedRoute,private router:Router,private movieService:MovieService,public sanitizer: DomSanitizer,private loginService: LoginService,
    public userService: UserService) { }
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
        },
        (error: HttpErrorResponse)=>{
          console.log(error.message);
        }
      )
  });
  }
  update() {
    if(this.movie.title===null || this.movie.durationMin === null || this.movie.rated == null || this.movie.releaseyear == null || this.movie.trailerUrl == null){
      this.success='Molim Vas popunite sva polja!'
    }else{
      this.movieService.update(this.movie).subscribe(result => this.gotoMovie());
    } 
  }
  gotoMovie() {
    this.router.navigate(['/movie-details-component', this.movie.idMovie]);
  }
}
