import { Component } from '@angular/core';
import{RegisterToAppService} from './register-to-app.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  isAdmin = false;
  isSuperAdmin = false;
  constructor(private sharedService:RegisterToAppService){
      sharedService.changeEmitted$.subscribe(
        text =>{
                this.isAdmin = true;
                if(text == "SuperAdmin"){
                  this.isSuperAdmin = true;
                }
              }
            );

  }
  admin(){
    this.sharedService.emitchangeStatus("admin");
  }
  superAdmin(){
    this.sharedService.emitchangeStatus("superAdmin");

  }
}
