import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {
  types =["Type 1: 10$","Type 2: 20$","Type 3: 30$"];

  constructor() { }

  ngOnInit() {
  }

  sendForm():void{
    alert("DSDSDSDDDSDS");
  }
}
