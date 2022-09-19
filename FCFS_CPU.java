package com.Data_Structures_byprayush;

/*
CODE Created by Prayush Giri
Registration Number : 21BCE7864
System.out.printf("  %d ",(i+1));
            System.out.printf("     %d",burst_time[i]);
            System.out.printf("     %d",waiting_time[i]);
            System.out.printf("     %d",turnaroundtime[i])
 */
public class FCFS_CPU {
    //Given n process with their burst times, teh task is to find average waiting time and average turn around time using FCFS scheduling algo.
    //First in, first out(FIFO), also known as first come, first served(FCFS), is the
    // simplest scheduling algorithm. FIFO/FCFS simply queues processes in the order that they arrive in the ready queue.
    //In this, the process that comes first will be executed first and next process starts only after the previous gets fully executed.
    //Here we are considering that the arrival time for all processes is 0.
    /*
    1. Completion time - Time at which process completes its execution, also including the waiting time period after arrival.
    2. Turn Around Time - Time difference between completion time and arrival time.
    TAT = Completion time - Arrival Time.
    3. Waiting Time(W.T) - Time difference between turn around time and burst time.
    Waiting Time = Turn Around Time - Burst Time.
    4.Burst time = Total time taken for all the instruction in the process to execute, in  milliseconds is called burst time.
     */
    public static void main(String[] args) {
        int[] processes = {1,2,3,4};
        int no_of_processes = processes.length;
        int[] burst_time = {10,9,3,15};
        avgTime(processes,no_of_processes,burst_time);
    }
    //Waiting time calculation function
    static void waitingtime(int[] processes, int no_of_processes, int[] burst_time, int[] waitingtime)
    {
        //First process need not wait.
        waitingtime[0]=0;

        for(int i = 1; i< no_of_processes ;i++) {
            //for i = 1, waiting time[1] = burst time [0] + waiting time [0] -> Burst time will be waiting time for the second process.
             waitingtime[i] = burst_time[i-1] + waitingtime[i-1];
        }
    }
    //Turn around time calculation function.
    static void turnaroundtime(int[] processes, int no_of_processes,
                               int[] burst_time, int[] waitingtime,int[] turnaroundtime)
    {
        for (int i = 0; i < no_of_processes; i++) {
            turnaroundtime[i] = waitingtime[i] + burst_time[i];
        }
    }
    static void avgTime(int[] process,int length,int[] burst_time)
    {
        int[] waiting_time = new int[length];
        int [] turnaroundtime = new int [length];
        int total_waiting_time=0, total_turnaroundtime = 0;
        waitingtime(process,length,burst_time,waiting_time);
        turnaroundtime(process,length,burst_time,waiting_time,turnaroundtime);

        //Displaying
        System.out.print("Processes |  Burst-Time |  Waiting-Time | Turn-Around-Time\n");
        //calculating total waiting time:
        for (int i = 0; i < length; i++) {
            total_waiting_time = total_waiting_time + waiting_time[i];
            total_turnaroundtime = total_turnaroundtime + turnaroundtime[i];
            System.out.printf("    %d\t\t",(i+1));
            System.out.printf("     %d\t\t",burst_time[i]);
            System.out.printf("       %d\t\t",waiting_time[i]);
            System.out.printf("       %d\t\n",turnaroundtime[i]);
        }
        //Avg waiting time:
        float avgWaitingTime = (float) total_waiting_time / (float) length;
        int AvgTurnaroundTime = total_turnaroundtime/length;
        System.out.printf("Average Waiting Time: %f ",avgWaitingTime);
        System.out.printf("%n");
        System.out.printf("Average Turn Around Time: %d ",AvgTurnaroundTime);
    }

}