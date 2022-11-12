import { Component, OnInit } from '@angular/core';
import { LoginService } from './login.service';
import { UserCredentials } from './user-credentials.model';
import { Router } from '@angular/router';
import { JwtToken } from './jwt-token.model';
import { UserService } from '../user/user.service';
import { User } from '../user/user.model';
import { HttpErrorResponse } from '@angular/common/http';
import { signup } from './singup';
import { ReactiveFormsModule } from '@angular/forms';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})


export class LoginComponent implements OnInit {

  authenticating = false; // to show loading
  loginFailed = false; // to show login failed message
  random:string ="";
  success:string ="";
  log:string ="";
  userCredentials: UserCredentials = {} as UserCredentials;
  signup: signup = {} as signup;
  ssd : string;
  constructor(
    private loginService: LoginService,
    private router: Router,
    private userService: UserService
  ) {
    this.ssd="";
  }

  ngOnInit(): void {
    //this.userCredentials  = {} as UserCredentials;
    // provjeriti da li je vec ulogiran
  }
  signUp() {
    console.log(this.signup.username);
    if(this.signup.username===null || this.signup.password === null || this.signup.firstName == null || this.signup.lastName == null){
      this.success='Molim Vas popunite sva polja!'
    }else if(this.signup.password!==this.random){
      this.success='Lozinke se ne podudaraju!'
    }else{
      this.userService.save(this.signup).subscribe(result => this.gotoLogin());

      this.signup.firstName = '';
      this.signup.lastName = '';
      this.signup.password = '';
      this.signup.username = '';
      this.random='';
  
      this.success='Uspješno ste se registrirali!'
    } 
  }
  gotoLogin() {
    this.router.navigate(['/login']);
  }

  login() {
    this.authenticating = true;
    this.loginFailed = false;

    this.loginService.authenticate(this.userCredentials).subscribe(
      (jwtToken: JwtToken) => this.successfulLogin(jwtToken),
      () => this.loginFailed = true
    ).add(() => this.authenticating = false);

    if(!this.loginFailed){
      this.log="Nije ispravna lozinka ili korisničko ime!";
    }
  
  }

  public ss(): void{
    console.log("butons");
    this.userService.addss("asd").subscribe(
      (response: string) =>{
        this.ssd = response;
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }

  successfulLogin(jwtToken: JwtToken) {
    localStorage.setItem('token', jwtToken.token); // store token value to localstorage
    this.userService.getCurrentUser().subscribe((currentUser: User) => this.userService.currentUser = currentUser);
    this.router.navigate(['/']);
  }
}
