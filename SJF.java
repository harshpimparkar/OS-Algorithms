import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SJF{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Process> process =  new ArrayList<>();
        System.out.println("Enter the no of processes: ");
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Enter process id:");
            int pid=sc.nextInt();
            System.out.println("Enter arrival time:");
            int at = sc.nextInt();
            System.out.println("Enter burst time:");
            int bt = sc.nextInt();

            process.add(new Process(pid, at, bt));
        }
        sjf(process);
        sc.close();
    }
    public static void sjf(ArrayList<Process> processes){
        Collections.sort(processes,Comparator.comparingInt(p->p.burstTime));

        int currentTime=0;
        int completionTime=0;
        int waitingTime=0;
        int turnAroundTime=0;
        int totalTurnAroundTime=0;
        int totalWaitingTime=0;
        
        System.out.println("Process\tArrival Time \t Burst Time\tCompletion Time \tTurn Around Time \t Waiting Time");
        for(Process process: processes){
            waitingTime=currentTime;
            totalWaitingTime+=turnAroundTime;
            currentTime+=process.burstTime;
            turnAroundTime=waitingTime+process.burstTime;
            totalTurnAroundTime+=turnAroundTime;
            completionTime=turnAroundTime+process.arrivalTime;

            System.out.printf("%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t\t%d",process.id,process.arrivalTime,process.burstTime,completionTime,turnAroundTime,waitingTime);
            System.out.println("\n");
        }
        System.out.printf("%d\t\t%d\t\t%n",totalTurnAroundTime,totalWaitingTime);
    }
}