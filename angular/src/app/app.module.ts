import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { QuestionComponent } from './question.component';
import { AppComponent } from './app.component';
//import { UserComponent } from './user.component';
import { LoginComponent } from './app-routing/login/login.component';
import { AnswerComponent } from './answer.component';
import { ExampleInterceptor } from './example.interceptor';
import { LandingComponent } from './app-routing/landing/landing.component';
import { AdminDashboardComponent } from './app-routing/admin-dashboard/admin-dashboard.component';
import { CreateQuestionComponent } from './app-routing/create-question/create-question.component';
import { QuestionDetailsComponent } from './app-routing/question-details/question-details';
import { DatePipe } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    /*UserComponent,*/
    LoginComponent,
    QuestionComponent,
    AnswerComponent,
    LandingComponent,
    AdminDashboardComponent,
    CreateQuestionComponent,
    QuestionDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [LoginComponent, DatePipe,
{
    provide: HTTP_INTERCEPTORS, useClass: ExampleInterceptor, multi: true   
}],
  bootstrap: [AppComponent]
})
export class AppModule { }
