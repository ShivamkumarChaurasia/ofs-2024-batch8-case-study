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
import "ojs/ojknockout";
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
import Message = require('ojs/ojmessaging');


class DashboardViewModel {
  value: ko.Observable<string>;
  salary:ko.Observable<Number> | ko.Observable<any>;
  date:ko.Observable<String> | ko.Observable<any>;
  password : ko.Observable<String> | ko.Observable<any>;
  firstName : ko.Observable<string>| ko.Observable<any>;
  lastName : ko.Observable<string>| ko.Observable<any>;
  address : ko.Observable<string>| ko.Observable<any>;
    constructor() {
      this.value = ko.observable("Green");
      this.salary = ko.observable(null);
      this.date = ko.observable(null);
      this.password = ko.observable(null);
      this.firstName = ko.observable(null);
      this.address = ko.observable(null);
      this.lastName = ko.observable(null);
    }
}

export = DashboardViewModel;
