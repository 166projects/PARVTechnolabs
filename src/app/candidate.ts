import { logging } from 'protractor';
import { InterviewSchedule } from './interview-schedule';

export class Candidate {
    candidateId:string
    firstName:string
    lastName:string
    email:string
    cpassword:string
    idProof:string
    primarySkills:string
    secondarySkills:string
    experience:number
    designation:string
    noticePeriod:number
    eligibility:string
    interviewschedules:InterviewSchedule[]

}
