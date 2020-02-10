import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {
  //@Input() conf_id:ConfModelView;
  types :string[];
  exist = false;
  model:FormViewModel = {
    title:'',
    fName:'',
    lName:'',
    addr:'',
    zip:'',
    city:'',
    country:'',
    email:'',
    phone:'',
    type:'',
    conf_id:'',
  }

  constructor(private http:HttpClient,private route:ActivatedRoute) {
    let url = "http://localhost:8080/api/conf/types/"+this.route.snapshot.params["id"];
    this.http.get<string[]>(url).subscribe(
      res => {
        //some codes
        if(res.length > 0){
            this.types = res;
            this.exist = true;
        }


      },
      err => {
        alert("An error has occured, can not collect prices from server");
      }
    );
  }


  ngOnInit() {
  }

  sendForm():void{
    //verify users inputs

    //send request
    let url = "http://localhost:8080/api/users";
    this.model["conf_id"] = this.route.snapshot.params["id"];
    this.http.post(url,this.model).subscribe(
      res => {
        //some codes
        alert("it works");

      },
      err => {
        alert("Inscription failed, try later");
        console.log(err);
      }
    );
  }
}

export interface FormViewModel{
  title:string;
  fName:string;
  lName:string;
  addr:string;
  zip:string;
  city:string;
  country:string;
  email:string;
  phone:string;
  type:string;
  conf_id:string;
}

export interface ConfModelView{

}
