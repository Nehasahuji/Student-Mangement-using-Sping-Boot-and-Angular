import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from './student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseUrl = "http://localhost:8080/ap1/v1/students"

  constructor(private httpClient : HttpClient) {}
  getStudentList(): Observable<Student[]>{
      return this.httpClient.get<Student[]>(`${this.baseUrl}`);
  }

  createStudent(student : Student) :Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}`,student);
  }

  getStudentById(id:any) : Observable<Student>{
       return this.httpClient.get<Student>(`${this.baseUrl}/${id}`);
  }

  updateStudent(id :any ,student :Student):Observable<Object>{
    return this.httpClient.put(`${this.baseUrl}/${id}`,student);
  }

  deleteStudent(id : number):Observable<Object>{

    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
 
}
