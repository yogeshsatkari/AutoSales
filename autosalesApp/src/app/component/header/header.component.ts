import { Component, OnInit } from '@angular/core';
import { LogoutService } from 'src/app/service/logout.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public role: string;

  constructor(private logoutService: LogoutService) { }

  ngOnInit(): void {
    this.role = window.localStorage.getItem('tgt_role');       
  }

  public logout() {
    this.logoutService.logout();
  }

}
