// import { Employee } from "./employee";
import fs from 'fs';
import readline from 'readline-sync';


let path = './employees.json';
function addData(id, name, salary) {
    fs.readFile(path, 'utf8', (err, data) => {
        if (err) {
            console.error('Error reading the file:', err);
            return;
        }
        let jsonData;
        try {
            if (data.trim() === '') {
                jsonData = [];
            } else {
                jsonData = JSON.parse(data);
            }
        } catch (parseErr) {
            console.error('Error parsing JSON:', parseErr);
            return;
        }
        const newData = {id,name,salary};
        jsonData.push(newData);
        fs.writeFile(path, JSON.stringify(jsonData, null, 2), (err) => {
            if (err) {
                console.error('Error writing the file:', err);
            } else {
                console.log('Data added successfully.');
            }
        });
    });
}


console.log("------EMPLOYEE MENU------");
let id = readline.question('Enter Your Employee ID: ');
let name = readline.question('Enter Your Name: ');
let salary = readline.question('Enter Your Salary: ');
addData(id, name, salary);
let display = readline.question('Display Input y/n: ');
if(display.toLowerCase() == 'y'){
    console.log("hello");
    fs.readFile(path, 'utf8', (err, data) => {
        if (err) return console.error('Error reading file:', err);
        try {
            const jsonData = JSON.parse(data);
            console.log(jsonData);
        } catch (e) {
            console.error('Error parsing JSON:', e);
        }
    });
}