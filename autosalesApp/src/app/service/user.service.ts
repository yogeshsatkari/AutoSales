import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Logindata } from '../component/login/logindata';
import { Signupdata } from '../component/signup/signupdata';

@Injectable({
  providedIn: 'root'
})

export class UserService {

  constructor(private httpClient: HttpClient) { }

  userAuthenticationBaseUrl: string="http://localhost:8085/user";
  userAutomobilesMongodbBaseUrl: string="http://localhost:8086/auto";

  signup(signupdata: Signupdata) {
    return this.httpClient.post<any>(this.userAuthenticationBaseUrl+"/signup",signupdata);
  }


  login(logindata: Logindata){
    return this.httpClient.post<any>(this.userAuthenticationBaseUrl+"/login",logindata);
  }

  getAllUsers() {
    let reqHeader = new HttpHeaders().set('Authorization','Bearer ' + window.localStorage.getItem('tgt'));
    return this.httpClient.get<any>(this.userAutomobilesMongodbBaseUrl+"/getallusers", {'headers':reqHeader});
  }

  updateUserProfile(formData: FormData) {
    let reqHeader = new HttpHeaders().set('Authorization','Bearer ' + window.localStorage.getItem('tgt'));
    this.httpClient.post<any>(this.userAutomobilesMongodbBaseUrl+ "/updateuserprofile", formData, {'headers':reqHeader}).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    );
  }

}