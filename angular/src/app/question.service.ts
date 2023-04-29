import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Question } from './question';
import { LoginService } from './app-routing/login/login.service';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  private baseUrl = "http://localhost:8080/question";

  constructor(private httpClient: HttpClient, private loginService:LoginService) { }

    getQuestions(): Observable<Question[]>{
        const headers= new HttpHeaders()
            .set('Authorization', 'Bearer ' + this.loginService.token)
            .set('Access-Control-Allow-Origin', '*')
            .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
            .set('Access-Control-Allow-Headers','*');
                
        return this.httpClient.get<Question[]>(`${this.baseUrl}/getallquestion`, {'headers':headers});
    }
}