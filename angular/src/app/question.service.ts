import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Question } from './question';
import { LoginService } from './app-routing/login/login.service';
import * as myGlobals from './globals';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

    currQuestionId!:number;

    private baseUrl = 'http://' + myGlobals.ip + ':8080/question';
    constructor(private httpClient: HttpClient, private loginService:LoginService) { }

    setCurrQuestionId(id:number)
    {
        this.currQuestionId = id;
    }

    getQuestions(): Observable<Question[]>{
        const headers= new HttpHeaders()
            .set('Authorization', 'Bearer ' + this.loginService.token)
            .set('Access-Control-Allow-Origin', '*')
            .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
            .set('Access-Control-Allow-Headers','*');
                
        return this.httpClient.get<Question[]>(`${this.baseUrl}/getallquestion`, {'headers':headers});
    }

    addQuestion(question: Question): Observable<Question> {
        const headers= new HttpHeaders()
            .set('Authorization', 'Bearer ' + this.loginService.token)
            .set('Access-Control-Allow-Origin', '*')
            .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
            .set('Access-Control-Allow-Headers','*');

        // this.sendEmail(this.currQuestionId);
        this.httpClient.post(`${this.baseUrl}/sendemail/`+6, {'headers': headers});
        return this.httpClient.post<Question>(`${this.baseUrl}/addquestion`, question, {'headers': headers});
    }

    updateQuestion(question:Question):Observable<Question> {
        const headers= new HttpHeaders()
            .set('Authorization', 'Bearer ' + this.loginService.token)
            .set('Access-Control-Allow-Origin', '*')
            .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
            .set('Access-Control-Allow-Headers','*');

        return this.httpClient.put<Question>(`${this.baseUrl}/updatequestion`, question, {'headers': headers});
    }

    deleteQuestionById(id:number)
    {
        const headers= new HttpHeaders()
        .set('Authorization', 'Bearer ' + this.loginService.token)
        .set('responseType', 'text')
        .set('Access-Control-Allow-Origin', '*')
        .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
        .set('Access-Control-Allow-Headers','*');

        return this.httpClient.delete(`${this.baseUrl}/deletequestion/`+id, {'headers': headers});
    }

    sendEmail(id:number) {
        const headers= new HttpHeaders()
        .set('Authorization', 'Bearer ' + this.loginService.token)
        .set('responseType', 'text')
        .set('Access-Control-Allow-Origin', '*')
        .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
        .set('Access-Control-Allow-Headers','*');

        console.log("is this happening?");
        console.log(id);
        return this.httpClient.get(`${this.baseUrl}/sendemail/` + id, {'headers': headers});
    }
}