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

    toggleLandingOn()
    {
        this.showLanding = true;
    }

    toggleLandingOff()
    {
        this.showLanding = false;
    }

    toggleLoginOn()
    {
        this.showLogin = true;
    }

    toggleLoginOff()
    {
        this.showLogin = false;
    }
    
    toggleAdminDashboardOn()
    {
        this.showAdminDashboard = true;    
    }

    toggleAdminDashboardOff()
    {
        this.showAdminDashboard = false;    
    }

    toggleHome()
    {
        this.showHome = !this.showHome;    
    }
    

}
