import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  
  public users: any = [];     
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getAllUsers();
  }

  public getAllUsers(){
    this.userService.getAllUsers().subscribe(
      response => {
        console.log("success message :")
        console.log(response);
        this.users = response; 
        console.log(this.users);
      },
      error => {    
        console.log("error message :")         
        alert(error);
      } 
    );
  }

  public searchUsers(key: string): void {
    const results: any = [];
    if(this.users.length>=1) {
      for(const user of this.users){
        if(user.userName.toLowerCase().indexOf(key.toLowerCase()) !== -1 || user.emailId.toLowerCase().indexOf(key.toLowerCase()) !== -1 )
        {
          results.push(user);
        }
      }
    }
    this.users = results;
      if(!key) {
          this.getAllUsers();
      }
  }
}
