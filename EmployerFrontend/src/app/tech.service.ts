import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { InterviewSchedule } from './interview-schedule';
import { tap, catchError } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { Leaves } from './leaves';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class TechService {

  constructor(private _http:HttpClient) {  }
  private baseUrl = 'http://localhost:8089/Izdoo/'

  getInterviewByType(): Observable<InterviewSchedule[]>{
   const apiUrl='http://localhost:8089/Izdoo/Tech/getInterviewByType';
   const url=`${apiUrl}`;
   return this._http.get<InterviewSchedule[]>(url).pipe(
     tap(_ => console.log(`tech interview schedules`)),
   catchError(this.handleError<InterviewSchedule[]>(`cannot display `))
   );
   }


   addLeave(leave: Leaves) : Observable<any>  {
    console.log('service called');
    const url2= 'http://10.96.177.169:8089/Izdoo/Tech/add-Leave';
    return this._http.post(url2, leave, httpOptions)
    .pipe(tap(_ =>  console.log(`add leave id=${leave.leaveId}`)),
      catchError(this.handleError<Leaves>('add leave'))
    );
  
  }
  


   private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
