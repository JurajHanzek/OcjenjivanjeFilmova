import { Injectable } from '@angular/core';
import { SERVER_API_URL } from '../constants/app.constants';
import { HttpClient } from '@angular/common/http';
import { User } from './user.model';
import { Observable } from 'rxjs';
import { Authority } from '../constants/authority.constants';
import { signup } from '../login/singup';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  currentUser: User= {} as User;


  private usersUrl = `${SERVER_API_URL}/api/user`;

  constructor(private http: HttpClient) { }

  getCurrentUser(): Observable<User> {
    return this.http.get<User>(`${this.usersUrl}/current-user`);
  }

  isRoleAdmin(): boolean {
    if (this.currentUser) {
      return this.currentUser.authorities.some((authority: string) => authority === Authority.ADMIN);
    } else {
      return false;
    }
  }

  public addss(ss: string): Observable<string>{
    return this.http.post<string>(`http://localhost:8080/ss`,ss)
  }

  public save(user: signup) {
    return this.http.post<signup>(`http://localhost:8080/save-user`, user);
  }
 

}
