import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from '../login/login.service';
import { MovieService } from '../movie.service';
import { MovieData } from '../MovieData';
import { User } from '../user/user.model';
import { UserService } from '../user/user.service';

@Component({
  selector: 'app-dodaj',
  templateUrl: './dodaj.component.html',
  styleUrls: ['./dodaj.component.css']
})
export class DodajComponent implements OnInit {
  public result: MovieData[];
  params: MovieData = {} as MovieData;
  cl: MovieData = {} as MovieData;
  id;
  constructor(private _Activatedroute:ActivatedRoute,private _router:Router,private movieService:MovieService,public sanitizer: DomSanitizer,private loginService: LoginService,
    public userService: UserService,private router: Router) { 
    this.result = [];
  }

  ngOnInit(): void {
    console.log(this.params.title);
    this.userService.getCurrentUser().subscribe((currentUser: User) => {
      this.userService.currentUser = currentUser;
    });
  }



  search() {
    
    if(this.params.title=='' || this.params.title==null){
      this.params.title='-';
    }
    if(this.params.year=='' || this.params.year==null){
      this.params.year="-";
    }
    if(this.params.genre=='' || this.params.genre==null){
      this.params.genre="-";
    }

  this.movieService.search(this.params).subscribe(
    (response: MovieData[]) =>{
      this.result = response; 
    },
    (error: HttpErrorResponse)=>{
      console.log(error.message);
    }
  ) 
  this.cl.genre=this.params.genre
  this.cl.year=this.params.year
  this.params.title='-';
  this.params.year="-";
  this.params.genre="-";
 
  }
  clear1() {this.params.title='-';}
  clear2() {this.params.year='-';}
  clear3() {this.params.genre='-';}

    





    add(id) {
      this.movieService.dodajFilm(id).subscribe(
        () =>{
          
        },
        (error: HttpErrorResponse)=>{
          console.log(error.message);
        }
      ) 
      setTimeout(() => 
      {
          this.router.navigate(['movies-component']);
      }, 
      3000);
       }

}
