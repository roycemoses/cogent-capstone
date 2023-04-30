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
import { UserGuard } from './services/user.guard.ts';
import { UserDashboardComponent } from './app-routing/user-dashboard/user-dashboard.component';
import { PendingQuestionsComponent } from './app-routing/pending-questions/pending-questions';
import { PendingAnswersComponent } from './app-routing/pending-answers/pending-answers';

const routes: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: 'home', component: LandingComponent },
    { path: 'login', component: LoginComponent },
    { path: 'admin-dashboard', canActivate:[AdminGuard], component: AdminDashboardComponent },
    { path: 'user-dashboard', canActivate:[UserGuard], component: UserDashboardComponent},
    { path: 'create-question', component: CreateQuestionComponent },
    { path: 'question-details', component: QuestionDetailsComponent },
    { path: 'pending-questions', canActivate:[AdminGuard], component: PendingQuestionsComponent},
    { path: 'pending-answers', canActivate:[AdminGuard], component: PendingAnswersComponent},
    // { path: 'about', canActivate:[AuthGuard], component: AboutComponent },
    // { path: 'careers', canActivate:[AuthGuard], component: CareersComponent },
    // { path: 'contact', component: ContactComponent },
    { path: '**', component: PageNotFoundComponent }
]

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule {}; // authenticatino on other routes?