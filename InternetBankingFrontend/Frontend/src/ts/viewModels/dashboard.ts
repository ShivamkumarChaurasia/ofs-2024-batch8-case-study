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

class DashboardViewModel {
  message: ko.Observable<string>;
  password: ko.Observable<String> | ko.Observable<any>;
  customerId : ko.Observable<Number> | ko.Observable<any>;
  clickedButton: ko.Observable<string>;
  readonly progressValue = ko.observable(0);
  readonly indeterminate = ko.observableArray();
  private readonly step = ko.observable(0);
  constructor() {
    this.password = ko.observable(null);
    this.customerId = ko.observable(null);
    this.clickedButton = ko.observable("(Not clicked yet)");
    this.message = ko.observable('');
    window.setInterval(() => {
      this.step((this.step() + 1) % 200);
    }, 30);
  }

  public updateMessage(newMessage: string): void {
    this.message(newMessage);
  }

  public onkey = (event: Event) => {
    this.progressValue(this.progressValue() + 50);
  }

  public handleClick = async (event: Event) => {
    // alert('Button was clicked!');
    // this.clickedButton('Clicked');
    // let id = parseInt(this.firstName());
    let url = 'http://localhost:8083/login/signin';
    const row = {
      "customerId": this.customerId(),
      "password": this.password()
    };
    console.log(row);
    const request = new Request(url, {
      headers: new Headers({
        "Content-Type": "application/json",
      }),
      body: JSON.stringify(row),
      method: "POST",
    });
    const response = await fetch(request);
    let data = await response.json();
    if(data.customerId == 0){
      this.updateMessage("Your Account is Blocked!");
    }else if(data.customerId == 1){
      this.updateMessage("You can retry");
    }else{
      this.updateMessage("LOGGED IN");
      this.displayWelcomeMessage(`Welcome, Customer ${data.customerId}`);
    }
  }

  private displayWelcomeMessage(message: string): void {
    const welcomeElement = document.getElementById('welcomeMessage');
    if (welcomeElement) {
      welcomeElement.innerText = message;
    }
  }

}

export = DashboardViewModel;
