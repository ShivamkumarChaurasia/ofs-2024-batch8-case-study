/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import * as ko from "knockout";
import * as Bootstrap from "ojs/ojbootstrap";
import { IntlConverterUtils } from 'ojs/ojconverterutils-i18n';
import ArrayDataProvider = require('ojs/ojarraydataprovider');
import "oj-c/input-text";
import "oj-c/input-number";
import 'oj-c/input-password';
import "oj-c/input-date-text";
import 'oj-c/text-area';
import 'oj-c/input-date-mask';
import 'oj-c/input-date-text';
import 'oj-c/input-month-mask';
import 'oj-c/input-number';
import 'oj-c/input-text';
import 'oj-c/input-password';
import 'oj-c/input-sensitive-text';
import 'oj-c/radioset';
import 'oj-c/form-layout';
import "oj-c/button";
import "oj-c/progress-bar";
import Message = require('ojs/ojmessaging');
import { whenDocumentReady } from "ojs/ojbootstrap";


class DashboardViewModel {
    value: ko.Observable<string>;
    salary: ko.Observable<Number> | ko.Observable<any>;
    date: ko.Observable<String> | ko.Observable<any>;
    password: ko.Observable<String> | ko.Observable<any>;
    firstName: ko.Observable<string> | ko.Observable<any>;
    lastName: ko.Observable<string> | ko.Observable<any>;
    address: ko.Observable<string> | ko.Observable<any>;
    clickedButton: ko.Observable<string>;
    private readonly step = ko.observable(0);
    // readonly progress1Value = ko.pureComputed(() => {
    //   return Math.min(this.step(), 100);
    // });
    readonly progressValue = ko.observable(0);
    readonly indeterminate = ko.observableArray();
    
    constructor() {
        this.value = ko.observable("Green");
        this.salary = ko.observable(null);
        this.date = ko.observable(null);
        this.password = ko.observable(null);
        this.firstName = ko.observable(null);
        this.address = ko.observable(null);
        this.lastName = ko.observable(null);
        this.clickedButton = ko.observable("(Not clicked yet)");
        window.setInterval(() => {
            this.step((this.step() + 1) % 200);
        }, 30);
    }
    
    public handleClick = async (event: Event) => {
        // alert('Button was clicked!');
        this.clickedButton('Clicked');
        let id = parseInt(this.firstName());
        let url = "https://jsonplaceholder.typicode.com/users/" + id;
        let res = await fetch(url);
        let jsonData = await res.json();
        console.log(jsonData);

    }

    public onkey = (event: Event) => {
        this.progressValue(this.progressValue() + 20);
    }
}

// const viewModel = new ViewModel();
// ko.applyBindings(viewModel);

// whenDocumentReady().then(() => {
//   ko.applyBindings(
//     new ViewModel(),
//     document.getElementById("progressBarWrapper")
//   );
// });

// whenDocumentReady().then(() => {
//   ko.applyBindings(
//     new DashboardViewModel(),
//     document.getElementById("progressBarWrapper")
//   );
// });

export = DashboardViewModel;

