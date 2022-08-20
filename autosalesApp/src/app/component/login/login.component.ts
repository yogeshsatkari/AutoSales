import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from 'src/app/service/user.service';
import { Logindata } from './logindata';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

 
  logindata: Logindata;
  messageOnSubmit:any;

  constructor(private userService :UserService){
    window.localStorage.clear();
  }

  loginFormGroup = new FormGroup({
    "emailId": new FormControl('',[Validators.required]),
    "password": new FormControl('',[Validators.required])
  });

  loginCheck(){
    // console.log(this.loginFormGroup.value);
    // storing form data into the model class
    this.logindata = this.loginFormGroup.value;
    // console.log(this.logindata);
    this.userService.login(this.logindata).subscribe(
      response => {
        console.log("Login Success message : ");
        console.log(response);
        this.messageOnSubmit = response.message;
        let x = document.getElementById('submitResponse');
        x.style.color = 'rgb(0, 128, 0)';
        x.style.fontStyle = 'italic';
        window.localStorage.setItem('tgt', response.token);
        window.localStorage.setItem('tgt_email', response.emailId);
        window.localStorage.setItem('tgt_role',response.role);       
      },
      error => {
        console.log("Login error message : ");
        console.log(error);
        this.messageOnSubmit = error.error;
        let x = document.getElementById('submitResponse');
        x.style.color = 'rgb(255, 0, 0)';
        x.style.fontStyle = 'italic';
      }
    );
  }

  get password() {
    return this.loginFormGroup.get('password')
  }

  get emailId() {
    return this.loginFormGroup.get('emailId')
  }

  ngOnInit(): void {
  }

}
