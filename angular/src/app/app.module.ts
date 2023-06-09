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
import { UserDashboardComponent } from './app-routing/user-dashboard/user-dashboard.component';
import { PendingQuestionsComponent } from './app-routing/pending-questions/pending-questions';
import { PendingAnswersComponent } from './app-routing/pending-answers/pending-answers';
import { RegisterComponent } from './app-routing/register/register.component';
import { ChatHomepageComponent } from './app-routing/chat-homepage/chat-homepage.component';
import { ChatDetailsComponent } from './app-routing/chat-details/chat-details.component';
import { SearchQuestionComponent } from './app-routing/search-question/search-question.component';
import { PageNotFoundComponent } from './app-routing/page-not-found/page-not-found.component';
import { AboutComponent } from './app-routing/about/about.component';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';


@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    LoginComponent,
    QuestionComponent,
    AnswerComponent,
    LandingComponent,
    AdminDashboardComponent,
    UserDashboardComponent,
    CreateQuestionComponent,
    QuestionDetailsComponent,
    PendingQuestionsComponent,
    PendingAnswersComponent,
    RegisterComponent,
    ChatHomepageComponent,
    ChatDetailsComponent,
    SearchQuestionComponent,
    PageNotFoundComponent
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
    },
    {
        provide: LocationStrategy, useClass: HashLocationStrategy
    }
],
  bootstrap: [AppComponent]
})
export class AppModule { }
