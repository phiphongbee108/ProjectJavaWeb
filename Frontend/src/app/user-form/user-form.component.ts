import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from 'src/models/User';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})

export class UserFormComponent implements OnInit {
  id: number = 0;
  public userForm:any = new FormGroup({
    id: new FormControl(''),
    username: new FormControl(''),
    pass: new FormControl(''),
    role_user: new FormControl(''),
  })

  constructor(private userService: UsersService, private router: Router, private myroute: ActivatedRoute) {}
  ngOnInit(): void {
    const idParam = this.myroute.snapshot.paramMap.get('id');
    this.id = idParam ? + idParam : 0;
    console.log('id= ', this.id);
    if (this.id > 0) {
      this.loadData(this.id);
    }
  }

  public onSubmit() {
    const user:any = {};
    console.log('onSubmit');
    for (const control in this.userForm.controls) {
      if(control) {
        console.log(this.userForm.controls[control].value);
        user[control] = this.userForm.controls[control].value;
      }
    }

    if (this.id > 0) {
      this.userService.updateUser(this.id, user as User).subscribe(data => {
        console.log('Cập nhật nhân viên: ' + data);
        this.router.navigate(['users']);
      })
    } else {
      this.userService.addUser(user as User).subscribe(data => {
        console.log('Thêm nhân viên mới: ' + data);
        this.router.navigate(['users']);
      })
    }
  }

  private loadData(id:number) {
    console.log('load data', id);
    this.userService.getUserById(id).subscribe((data) => {
      console.log('get user: ', data);

      for (const control in this.userForm.controls) {
        if (control) {
          this.userForm.controls[control].setValue(data[control]);
        }
      }
    })
  }
}
