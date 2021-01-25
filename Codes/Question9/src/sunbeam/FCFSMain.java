//9. Use java.util.Queue to simulate FCFS scheduling algorithm. The jobs information like process id, 
//arrival time and burst time a should be loaded from a text file (example given below). 
//Output should be table printing process id, arrival time, burst time, waiting time and turnaround 
//time in order of scheduling.
//  Input format (process id, arrival time and burst time):
//	1,0,14
//	2,2,6
//	3,3,10
//	4,6,2
//	5,40,10
//   * For FCFS algorithm
//		* Waiting time = Scheduling time - Arrival time
//		* Turn-around time = Completion time - Arrival time
package sunbeam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;

class Job{
	private int processId,arrTime,burstTime,waitTime,turnAroundTime;

	public Job(int processId, int arrTime, int burstTime, int waitTime, int turnAroundTime) {
		this.processId = processId;
		this.arrTime = arrTime;
		this.burstTime = burstTime;
		this.waitTime = waitTime;
		this.turnAroundTime = turnAroundTime;
	}

	public Job() {
	}

	public int getProcessId() {
		return processId;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}

	public int getArrTime() {
		return arrTime;
	}

	public void setArrTime(int arrTime) {
		this.arrTime = arrTime;
	}

	public int getBurstTime() {
		return burstTime;
	}

	public void setBurstTime(int burstTime) {
		this.burstTime = burstTime;
	}

	public int getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}

	public int getTurnAroundTime() {
		return turnAroundTime;
	}

	public void setTurnAroundTime(int turnAroundTime) {
		this.turnAroundTime = turnAroundTime;
	}

	@Override
	public String toString() {
		return "Job [ProcessId=" + processId + ", ArrivalTime=" + arrTime + ", BurstTime=" + burstTime + ", WaitTime="
				+ waitTime + ", TurnAroundTime=" + turnAroundTime + "]";
	}
	
	
}
public class FCFSMain {

	
	
	public static Queue<Job> read() throws Exception
	{
		Queue<Job> q= new LinkedList<>();
		try(BufferedReader reader = new BufferedReader(new FileReader(new File("jobs.txt"))))
		 {
			
			int processId,arrTime,burstTime;
			 String line="";
			 while((line=reader.readLine())!=null)  
			 {  	
				 Job job=new Job();
				 String[] arr = line.split(",");
				 job.setProcessId(Integer.parseInt(arr[0]));
				 job.setArrTime(Integer.parseInt(arr[1]));
				 job.setBurstTime(Integer.parseInt(arr[2]));
				 q.add(job);
			 }
		}
		return q;
	}
	
	private static void printjob(Queue<Job> q) {
		
		int tAR=0,pId=0,aT=0,bT=0,cT=0,wT=0,sT;
		//tAR=Turn Around Time;pId=Process Id;aT=Arrival TIme;bT=Burst Time
		//cT=Completion Time;wT=Waiting Time;sT=Scheduling Time
		while(q.peek()!=null)
		{	
			
			Job job=q.poll();
			pId = job.getProcessId();
			aT=job.getArrTime();
			
			//If Arrival Time of ith job is greater than Completion time of (i-1)th job then
			if(aT>cT)   
			{	
				//Scheduling Time of ith job is it's arrival time
				sT=aT;
				//and waiting time is zero i.e sT-aT
				wT=0;
			}
			else
			//If Arrival Time of ith job is less than or equal to Completion time of (i-1)th job then
			//Scheduling Time of ith job is Completion time of (i-1)th job
			sT=cT;
			
			//& Waiting Time(ith job)=Scheduling Time(ith job) - Arrival Time(ith job) 
			wT=sT-aT;
			bT=job.getBurstTime();
			
			//If arrival time of ith job is less than or equal to completion time of (i-1)th job then 
			//the completion time of ith job= completion time [(i-1)th job] + burst time (ith) job
			cT=cT+bT;
			
			//If arrival time of ith job is greater then completion time of (i-1)th job then
			if(aT>(cT-bT))
			{
			//the completion time of ith job=Arrival Time(ith job) + Burst Time(ith job)
				cT=aT+bT;
			//turn around time of ith job is equal to burst time
			//Turn Around Time=Completion time - Arrival Time (tAR=(aT+bT)-bT
				tAR=bT;
			}
			else
				
			//If arrival time of ith job is less than or equal to completion time of (i-1)th job then
			//Turn Around Time of ith job = Completion Time (ith job) - Arrival Time (ith job)
			tAR=cT-aT;
			job=new Job(pId,aT,bT,wT,tAR);
			System.out.println(job.toString());
		}
		
	}
	
	public static void main(String[] args) {
		try {
			Queue<Job> q=read();
			printjob(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
