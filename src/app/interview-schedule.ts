import { Candidate } from './candidate';
import { Employer } from './employer';

export class InterviewSchedule {
    interviewId:string
    interviewDate:Date
    interviewType:string
    rating:number
    feedback:string
    interviewStatus:string
    candidate:Candidate
    employer:Employer
}
