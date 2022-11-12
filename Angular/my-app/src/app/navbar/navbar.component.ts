import { HttpErrorResponse } from '@angular/common/http';
import { AfterViewInit, Component, OnInit } from '@angular/core';
import { Input,  Output,EventEmitter } from '@angular/core';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';
import { SelectDropDownModule } from 'ngx-select-dropdown'
import { ActivatedRoute, Router, UrlSegment } from '@angular/router';
import { UserService } from '../user/user.service';
import { LoginService } from '../login/login.service';
import { User } from '../user/user.model';
declare var jQuery: any;


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit,AfterViewInit {
  public searchTerm: string = "";
  public movies: Movie[];
  public codeValue: string;
  constructor(private movieService:MovieService,private loginService: LoginService,
    public userService: UserService,private route:ActivatedRoute,
    private router: Router) {
    
    this.movies = [];
    this.codeValue = "";
   }
  
  ngOnInit(): void {
    this.getMovies();
   
      this.userService.getCurrentUser().subscribe((currentUser: User) => {
        this.userService.currentUser = currentUser;
      });
    
  }
  ngAfterViewInit(): void {
    (function ($) {
      $(document).ready(function(){
                  
          var nav = $('nav');
          var line = $('<div />').addClass('line');

          line.appendTo(nav);

          var active = nav.find('.active');
          var pos = 0;
          var wid = 0;

          if(active.length) {
            pos = active.position().left;
            wid = active.width();
            line.css({
              left: pos,
              width: wid
            });
          }

          nav.find('ul li a').click(function(this: void  ,e: Event) {
            e.preventDefault();


            if(!$(this).parent().hasClass('active') && !nav.hasClass('animate')&& !nav.hasClass('dont') &&!$(this).parent().hasClass('dont')) {
              
              nav.addClass('animate');

              var _this = $(this);
              nav.find('ul li').removeClass('active');

              var position = _this.parent().position();
              var width = _this.parent().width();

              if(position.left >= pos) {
                line.animate({
                  width: ((position.left - pos) + width)
                }, 300, function() {
                  line.animate({
                    width: width,
                    left: position.left
                  }, 150, function() {
                    nav.removeClass('animate');
                  });
                  _this.parent().addClass('active');
                });
              } else {
                line.animate({
                  left: position.left,
                  width: ((pos - position.left) + wid)
                }, 300, function() {
                  line.animate({
                    width: width
                  }, 150, function() {
                    nav.removeClass('animate');
                  });
                  _this.parent().addClass('active');
                });
              }

              pos = position.left;
              wid = width;
            }
});
      });
    })(jQuery);
  }


  public saveCode(e): void {
    let title = e.target.value;
    let list = this.movies.filter(x => x.title === title)[0];
    this.router.navigate(['/movie-details-component', list.idMovie]);
  }

  logout() {
    this.loginService.logout();
    this.userService.currentUser = null!;
    this.router.navigate(['/login']);
  }

  isUserLoggedIn(): boolean {

    return !!this.userService.currentUser;
    
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
