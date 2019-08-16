import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';
import { Candidate } from './candidate';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})

export class LoginSignupServiceService {
  private url='http://localhost:8089/Izdoo';
  constructor(private _http:HttpClient) { }
  
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error); // log to console instead
      return of(result as T);
    };
  }
  
  login(email: string, cpassword: string):Observable<Candidate>{
    console.log('service called');  
    const url1= 'http://10.96.177.169:8089/Izdoo/candidate/login';
    //const lurl = `http://localhost:8089/Izdoo/LoginSignup/login/rohhith@gmail.com/123456Sd`;
    const lurl=`${url1}/${email}/${cpassword}`;
    return this._http.get<Candidate>(lurl)
    .pipe(tap(_ => console.log(`logged in as=${email}`)),
    catchError(this.handleError<Candidate>(`getCandidateid=${email}`))
  );       
}

addCandidate(candidate: Candidate) : Observable<any>  {
  console.log('service called');
  const url2= 'http://10.96.177.169:8089/Izdoo/candidate/add';
  return this._http.post(url2, candidate, httpOptions)
  .pipe(tap(_ =>  console.log(`add candidate email=${candidate.email}`)),
    catchError(this.handleError<Candidate>('add candidate'))
  );

}

}


