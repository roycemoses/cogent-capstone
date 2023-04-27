import { Component } from '@angular/core';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {
    title = 'user-management-app';
    showHome:boolean = false;
    showLanding:boolean = true;
    showLogin:boolean = false;
    showAdminDashboard:boolean = false;

    toggleLanding()
    {
        this.showLanding = !this.showLanding;
    }

    toggleLogin()
    {
        this.showLogin = !this.showLogin;
    }
    
    toggleAdminDashboard()
    {
        this.showAdminDashboard = !this.showAdminDashboard;    
    }

    toggleHome()
    {
        this.showHome = !this.showHome;    
    }
    

}
