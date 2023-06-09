import { Component, OnInit } from '@angular/core';
import { User } from 'src/models/User';
import { UsersService } from '../users.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  public listusers : User[] = [];
  constructor(private userService: UsersService, private router: Router) {}

  ngOnInit(): void {
    this.getListusers();
  }

  public getListusers() {
    this.userService.getUsers().subscribe((data) => {
      console.log(data);
      this.listusers = data;
    })
  }

  public addUser() {
    this.router.navigate(['user-form'])
  }

  public editUser(id:any) {
    this.router.navigate(['user-form', id])
  }

  public deleteUser(id:any) {
    console.log('user id: ' + id);
    this.userService.deleteUser(id).subscribe((data) => {
      console.log('delete: ' + data);
    })

    this.getListusers();
  }
}
