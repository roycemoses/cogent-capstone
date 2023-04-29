import { HttpClient, HttpHeaders } from '@angular/common/http'
import { BehaviorSubject, Observable, ObservedValueOf } from 'rxjs';
import { Injectable } from '@angular/core';
import { LoginService } from '../login/login.service';
import { Question } from 'src/app/question';

@Injectable({
    providedIn:'root'
})
export class QuestionDetailsService
{
    private baseUrl = 'http://localhost:8080/question';
    
    constructor (private httpClient:HttpClient, private loginService:LoginService) {}
    
    getQuestionById(id:number):Observable<Question> {
        const headers= new HttpHeaders()
            .set('Authorization', 'Bearer ' + this.loginService.token)
            .set('Access-Control-Allow-Origin', '*')
            .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
            .set('Access-Control-Allow-Headers','*');
        
        return this.httpClient.get<Question>(`${this.baseUrl}/getquestionbyid/`+id, {'headers':headers});
    }
}