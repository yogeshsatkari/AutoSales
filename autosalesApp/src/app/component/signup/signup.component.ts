import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/user.service';
import { Signupdata } from './signupdata';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signupdata: Signupdata;
  messageOnSubmit:any;
  
  constructor(private userservice: UserService, private router: Router) {
  }

  //definining formgroup shape to capture.
  signupFormGroup = new FormGroup ({
    userName: new FormControl(''),
    emailId: new FormControl('',[Validators.required]),
    password: new FormControl('',[Validators.required]),
  });

  sendSignupData() {
    // console.log(this.signupFormGroup.value);
    //storing form data into the model class
    this.signupdata = this.signupFormGroup.value;
    // console.log(this.signupdata);
    this.userservice.signup(this.signupdata).subscribe(
      response => {
        console.log("User registration success : ")
        console.log(response);
        this.messageOnSubmit = "Your account has been created successfully.";
        let x = document.getElementById('submitResponse');
        x.style.color = 'rgb(0, 128, 0)';
        x.style.fontStyle = 'italic';
      },
      error => {
        console.log("error message : ");
        console.log(error);
      }
    );
  }

  ngOnInit(): void {
  }

  get userName() {
    return this.signupFormGroup.get("userName");
  }
  get emailId() {
    return this.signupFormGroup.get('emailId')
  }
  get password() {
    return this.signupFormGroup.get('password')
  }
 
}
