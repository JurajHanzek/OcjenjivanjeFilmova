import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from './movie';
import { Actor } from './actor';
import { environment } from 'src/environments/environment';
import { Director } from './director';
import { MovieStudio } from './movieStudio';
import { MovieRating } from './movieRating';
import { Ocjene } from './ocjene';
import { Character } from './character';
import { user_rating } from './user_rating';
import { User } from './user/user.model';
import { MovieData } from './MovieData';


@Injectable({
  providedIn: 'root'
})
export class MovieService {
  private api=environment.api;
  constructor(private http: HttpClient) {}
   

    public getMovies(): Observable<Movie[]>{
      return this.http.get<Movie[]>(`${this.api}/movie/all`)
    }
    public getMovieRatings(): Observable<MovieRating[]>{
      return this.http.get<MovieRating[]>(`${this.api}/movie/rating`)
    }
    public getUsers(): Observable<User[]>{
      return this.http.get<User[]>(`${this.api}/api/user/all`)
    }

    public getOcjene(): Observable<Ocjene[]>{
      return this.http.get<Ocjene[]>(`${this.api}/movie/ocjene`)
    }
    public getOcjena(id): Observable<Ocjene>{
      return this.http.get<Ocjene>(`${this.api}/movie/ocjena/${id}`)
    }
    public erase(id): Observable<void>{
      return this.http.get<void>(`${this.api}/movie/erase/${id}`)
    }
   
    public update(movie: Movie) {
      return this.http.post<Movie>(`${this.api}/movie/update`, movie);
    }
    public rate(ur: user_rating) {
      return this.http.post<user_rating>(`${this.api}/movie/rate`, ur);
    }
    public dodajFilm(id: String) {
      return this.http.post<String>(`${this.api}/movie/dodaj`, id);
    }
   
    public getMovieByID(movieId: number): Observable<Movie>{
      return this.http.get<Movie>(`${this.api}/movie/${movieId}`)
    }
    public search(md: MovieData): Observable<MovieData[]>{
      return this.http.get<MovieData[]>(`${this.api}/movie/search/${md.title}/${md.year}/${md.genre}`)
    }
    public getMoviesByActorID(id: number): Observable<Movie[]>{
      return this.http.get<Movie[]>(`${this.api}/actor/movies/${id}`)
    }
    public getCharactersByActorID(id: number): Observable<Character[]>{
      return this.http.get<Character[]>(`${this.api}/actor/character/${id}`)
    }

    public getActorsByMovie(movieId: number): Observable<Actor[]>{
      return this.http.get<Actor[]>(`${this.api}/movie/actors/${movieId}`)
    }
    public getActorByID(movieId: number): Observable<Actor>{
      return this.http.get<Actor>(`${this.api}/actor/${movieId}`)
    }

    public getMovieStudio(id: number): Observable<MovieStudio>{
      return this.http.get<MovieStudio>(`${this.api}/movie/studio/${id}`)
    }

    public getDirector(id: number): Observable<Director>{
      return this.http.get<Director>(`${this.api}/movie/director/${id}`)
    }

    public getActors(): Observable<Actor[]>{
      return this.http.get<Actor[]>(`${this.api}/actor/all`)
    }
   
    public addMovies(movie: Movie): Observable<Movie>{
      return this.http.post<Movie>(`${this.api}/movie/add`,movie)
    }

    public updateMovies(movie: Movie): Observable<Movie>{
      return this.http.put<Movie>(`${this.api}/movie/update`,movie)
    }

    public deleteMovies(movieId: number): Observable<void>{
      return this.http.delete<void>(`${this.api}/movie/delete/${movieId}`)
    }
}
