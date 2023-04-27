import { NgModule } from '@angular/core'
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './app-routing/home/home.component';
import { AboutComponent } from './app-routing/about/about.component';
import { CareersComponent } from './app-routing/careers/careers.component';
import { ContactComponent } from './app-routing/contact/contact.component';
import { PageNotFoundComponent } from './app-routing/page-not-found/page-not-found.component';
import { AuthGuard } from './services/auth.guard';
import { LoginComponent } from './login.component';
import { AdminDashboardComponent } from './admin-dashboard.component';

const routes: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: 'login', component: LoginComponent },
    { path: 'admin-dashboard', component: AdminDashboardComponent },
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