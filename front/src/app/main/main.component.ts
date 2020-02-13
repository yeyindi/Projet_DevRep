import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http'

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  models:ConfModelView[];
  constructor(private http:HttpClient) {
      //get conf
      let url = "http://localhost:8080/api/conf";
      this.http.get<ConfModelView[]>(url).subscribe(
        res => {
          //some codes
          console.log("it works");
          this.models = res;

        },
        err => {
          console.error(err);
        }
      );
  }

  ngOnInit() {
  }
}

export interface ConfModelView{
  title:string;
  early_date:string;
  late_date:string;
}
