import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http'


@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {
  types =["Type 1: 10$","Type 2: 20$","Type 3: 30$"];
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
  }

  constructor(private http:HttpClient) {
    let url = "localhost:api/getPrice";
    this.http.get(url).subscribe(
      res => {
        //some codes
        alert("it works");

      },
      err => {
      //  alert("An error has occured, can not collect prices from server");
      }
    );
  }


  ngOnInit() {
  }

  sendForm():void{
    //verify users inputs

    //send request
    let url = "localhost:8080/api/inscription";
    this.http.get(url).subscribe(
      res => {
        //some codes
        alert("it works");
        let i = 1;
      },
      err => {
        alert("An error has occured");
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
}
