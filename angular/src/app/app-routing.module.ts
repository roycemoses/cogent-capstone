import { NgModule } from '@angular/core'
import { Routes, RouterModule } from '@angular/router';

import { AboutComponent } from './app-routing/about/about.component';
import { CareersComponent } from './app-routing/careers/careers.component';
import { ContactComponent } from './app-routing/contact/contact.component';
import { PageNotFoundComponent } from './app-routing/page-not-found/page-not-found.component';
import { AuthGuard } from './services/auth.guard';
import { LoginComponent } from './app-routing/login/login.component';
import { AdminDashboardComponent } from './app-routing/admin-dashboard/admin-dashboard.component';
import { LandingComponent } from './app-routing/landing/landing.component';
import { CreateQuestionComponent } from './app-routing/create-question/create-question.component';
import { QuestionComponent } from './question.component';
import { AdminGuard } from './services/admin.guard';
import { QuestionDetailsComponent } from './app-routing/question-details/question-details';
import { UserGuard } from './services/user.guard';
import { UserDashboardComponent } from './app-routing/user-dashboard/user-dashboard.component';
import { PendingQuestionsComponent } from './app-routing/pending-questions/pending-questions';
import { PendingAnswersComponent } from './app-routing/pending-answers/pending-answers';
import { RegisterComponent } from './app-routing/register/register.component';
import { AdminAndUserGuard } from './services/admin-and-user.guard';
import { ChatHomepageComponent } from './app-routing/chat-homepage/chat-homepage.component';
import { ChatDetailsComponent } from './app-routing/chat-details/chat-details.component';
import { SearchQuestionComponent } from './app-routing/search-question/search-question.component';
import { FailedAuthGuardComponent } from './app-routing/failed-auth-guard/failed-auth-guard.component';

const routes: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: 'error/403', component: FailedAuthGuardComponent },
    { path: 'error/404', component: PageNotFoundComponent },
    { path: 'home', component: LandingComponent },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent},
    { path: 'admin-dashboard', canActivate:[AdminGuard], component: AdminDashboardComponent },
    { path: 'user-dashboard', canActivate:[UserGuard], component: UserDashboardComponent},
    { path: 'create-question', canActivate:[AdminAndUserGuard], component: CreateQuestionComponent },
    { path: 'question-details', canActivate:[AdminAndUserGuard], component: QuestionDetailsComponent },
    { path: 'pending-questions', canActivate:[AdminGuard], component: PendingQuestionsComponent},
    { path: 'pending-answers', canActivate:[AdminGuard], component: PendingAnswersComponent},
    { path: 'chat-homepage', canActivate:[AdminAndUserGuard], component: ChatHomepageComponent},
    { path: 'chat-details', canActivate:[AdminAndUserGuard], component: ChatDetailsComponent },
    { path: 'search-question', canActivate:[AdminAndUserGuard], component: SearchQuestionComponent },
    { path: 'about', component: AboutComponent },
    // { path: 'careers', canActivate:[AuthGuard], component: CareersComponent },
    // { path: 'contact', component: ContactComponent },
    { path: '**', redirectTo: 'error/404', pathMatch:'full'}
]

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule {}; // authenticatino on other routes?