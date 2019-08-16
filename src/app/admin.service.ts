import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Candidate } from './candidate';
import { catchError, tap } from 'rxjs/operators';
import { InterviewSchedule } from './interview-schedule';
import { Leaves } from './leaves';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private url = 'http://localhost:8089/Izdoo';

  constructor(private _http:HttpClient,) {  }


   getAllcandidates(): Observable<Candidate[]>{
    const apiUrl='http://localhost:8089/Izdoo/admin/candidates';
    const url=`${apiUrl}`;
    return this._http.get<Candidate[]>(url).pipe(
      tap(_ => console.log(`all Candidate`)),
    catchError(this.handleError<Candidate[]>(`cannot display `))
    );
    }

    getAllInterviewSchedules(): Observable<InterviewSchedule[]>{
      const apiUrl='http://localhost:8089/Izdoo/admin/interview-schedules';
      const url=`${apiUrl}`;
      return this._http.get<InterviewSchedule[]>(url).pipe(
        tap(_ => console.log(`all Interview Schedules`)),
      catchError(this.handleError<InterviewSchedule[]>(`cannot display `))
      );
      }
    getAllLeaves(): Observable<Leaves[]>{
      const apiUrl='http://localhost:8089/Izdoo/admin/leaves';
      const url=`${apiUrl}`;
      return this._http.get<Leaves[]>(url).pipe(
        tap(_ => console.log(`all Interview Schedules`)),
        catchError(this.handleError<Leaves[]>(`cannot display `))
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
