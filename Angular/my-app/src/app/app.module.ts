import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MovieService } from './movie.service';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { ActorsComponent } from './actors/actors.component';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { MoviesComponent } from './movies/movies.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { MovieDetailsComponent } from './movie-details/movie-details.component';
import { ActorDetailsComponent } from './actor-details/actor-details.component';
import { SelectDropDownModule } from 'ngx-select-dropdown';
import { FormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from './interceptors/auth.interceptor';
import { AuthExpiredInterceptor } from './interceptors/auth-expired.inteceptor';
import { ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { ForbiddenPageComponent } from './forbidden-page/forbidden-page.component';
import { DodajComponent } from './dodaj/dodaj.component';
import { UpdateComponent } from './update/update.component';
import { DataTablesModule } from 'angular-datatables';



@NgModule({
  declarations: [
    AppComponent,
    ActorsComponent,
    HomeComponent,
    MoviesComponent,
    NavbarComponent,
    PageNotFoundComponent,
    MovieDetailsComponent,
    ActorDetailsComponent,
    LoginComponent,
    ForbiddenPageComponent,
    DodajComponent,
    UpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    NoopAnimationsModule,
    RouterModule,
    SelectDropDownModule,
    FormsModule,
    ReactiveFormsModule,
    DataTablesModule
  ],
  providers: [
    {
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true
  },
  {
    provide: HTTP_INTERCEPTORS,
    useClass: AuthExpiredInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
