import { NgModule } from '@angular/core'
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './app-routing/home/home.component';
import { AboutComponent } from './app-routing/about/about.component';
import { CareersComponent } from './app-routing/careers/careers.component';
import { ContactComponent } from './app-routing/contact/contact.component';
import { PageNotFoundComponent } from './app-routing/page-not-found/page-not-found.component';

const routes: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: 'about', component: AboutComponent },
    { path: 'careers', component: CareersComponent },
    { path: 'contact', component: ContactComponent },
    { path: '**', component: PageNotFoundComponent }
]

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule {}; // authenticatino on other routes?