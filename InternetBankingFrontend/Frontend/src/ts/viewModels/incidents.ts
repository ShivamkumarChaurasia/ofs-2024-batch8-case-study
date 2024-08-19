/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */

import * as AccUtils from "../accUtils";
import * as ko from "knockout";
import * as Bootstrap from "ojs/ojbootstrap";
import "oj-c/input-text";
import "oj-c/input-number";
import 'oj-c/input-password';
import 'oj-c/form-layout';
import "oj-c/progress-bar";
import "oj-c/button";

class IncidentsViewModel {
  customerId : ko.Observable<Number> | ko.Observable<any>;
  firstName : ko.Observable<String> | ko.Observable<any>;
  lastName : ko.Observable<String> | ko.Observable<any>;
  addressLine_1 : ko.Observable<String> | ko.Observable<any>;
  addressLine_2 : ko.Observable<String> | ko.Observable<any>;
  addressLine_3 : ko.Observable<String> | ko.Observable<any>;
  city : ko.Observable<String> | ko.Observable<any>;
  state :ko.Observable<String> | ko.Observable<any>;
  email : ko.Observable<String> | ko.Observable<any>;
  ZIP :  ko.Observable<Number> | ko.Observable<any>;
  password : ko.Observable<String> | ko.Observable<any>;
  clickedButton: ko.Observable<string>;
  readonly progressValue = ko.observable(0);
  readonly indeterminate = ko.observableArray();
  private readonly step = ko.observable(0);

  constructor() {
    this.customerId = ko.observable(null);
    this.firstName = ko.observable(null);
    this.lastName = ko.observable(null);
    this.addressLine_1 = ko.observable(null);
    this.addressLine_2 = ko.observable(null);
    this.addressLine_3 = ko.observable(null);
    this.city = ko.observable(null);
    this.state = ko.observable(null);
    this.email = ko.observable(null);
    this.ZIP = ko.observable(null);
    this.password = ko.observable(null);
    this.clickedButton = ko.observable("(Not clicked yet)");
    window.setInterval(() => {
      this.step((this.step() + 1) % 200);
    }, 30);
  }

  public handleClick = async (event: Event) => {
    // alert('Button was clicked!');
    // this.clickedButton('Clicked');
    // let id = parseInt(this.firstName());
    let url = 'http://localhost:8083/login/signup';
    let url2 = 'http://localhost:8083/login/lsignup';
    const row = {
      "customerId" : this.customerId(),
      "firstName" : this.firstName(),
      "lastName" : this.lastName(),
      "addressLine_1" : this.addressLine_1(),
      "addressLine_2" : this.addressLine_2(),
      "addressLine_3" : this.addressLine_3(),
      "city" : this.city(),
      "state" : this.state(),
      "email" : this.email(),
      "ZIP" : this.ZIP(),
    };
    const row2 = {
      "customerId" : this.customerId(),
      "password" : this.password()
    };
    console.log(row);
    console.log(row2);
    const request = new Request(url, {
      headers: new Headers({
        "Content-Type": "application/json",
      }),
      body: JSON.stringify(row),
      method: "POST",
    });
    const request1 = new Request(url2, {
      headers: new Headers({
        "Content-Type": "application/json",
      }),
      body: JSON.stringify(row2),
      method: "POST",
    });
    const response = await fetch(request);
    let data = await response.json();
    console.log(data);
    const response2 = await fetch(request1);
    let data2 = await response2.json();
    console.log(data2);
    this.displayWelcomeMessage(`Customer Profile Added`);


    
    // if(data.customerId == 0){
    //   this.updateMessage("Your Account is Blocked!");
    // }else if(data.customerId == 1){
    //   this.updateMessage("You can retry");
    // }else{
    //   this.updateMessage("LOGGED IN"); 
    // }
  }

  


  public onkey = (event: Event) => {
    this.progressValue(this.progressValue() + 12);
  }

  private displayWelcomeMessage(message: string): void {
    const welcomeElement = document.getElementById('welcomeMessage');
    if (welcomeElement) {
      welcomeElement.innerText = message;
    }
  }
}

export = IncidentsViewModel;
