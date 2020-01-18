import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http'

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  titles = ["Conf 1", "Conf 2", "Conf 3"];
  details = ["01/01/2020-01/02/2020:Early Registration","02/02/2020-10/02/2020:Late Registration",
"01/01/2020-01/02/2020:Early Registration","02/02/2020-10/02/2020:Late Registration",
"01/01/2020-01/02/2020:Early Registration","02/02/2020-10/02/2020:Late Registration"]
  models:ConfModelView[]= [{title:"Conf 1",early:"01/01/2020-01/02/2020:Early Registration",
late:"02/02/2020-10/02/2020:Late Registration"},{title:"Conf 2",early:"01/01/2020-01/02/2020:Early Registration"
,late:"02/02/2020-10/02/2020:Late Registration"}];
  constructor(private http:HttpClient) {
      //get conf
      let url = "localhost:8080/api/getConf";
      this.http.get(url).subscribe(
        res => {
          //some codes
          alert("it works");
          let i = 1;
        },
        err => {
          //alert("An error has occured");
        }
      );
  }

  ngOnInit() {
  }
}

export interface ConfModelView{
  title:string;
  early:string;
  late:string;
}
