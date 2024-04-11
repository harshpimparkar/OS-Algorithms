import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class FCFS {
    //build array
    public static void main(String[] args) {
        ArrayList<Process> process = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
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
        fcfs(process);
        sc.close();
    }

    //calculate
    public static void fcfs(ArrayList<Process> processes){
        // sort array based on at
        Collections.sort(processes, Comparator.comparingInt(p->p.arrivalTime));
        int waitingTime=0;
        int turnAroundTime=0;
        int completionTime=0;
        int totalTurnAroundTime = 0;
        int totalWaitingTime = 0;

        System.out.println("Process\tArrival Time \t Burst Time\tCompletion Time \tTurn Around Time \t Waiting Time");
        for (Process process : processes){
            waitingTime = Math.max(waitingTime, process.arrivalTime);
            completionTime = waitingTime+process.burstTime;
            turnAroundTime = completionTime - process.arrivalTime;
            totalTurnAroundTime+=turnAroundTime;
            totalWaitingTime+=waitingTime;

            System.out.printf("%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t\t%d",process.id,process.arrivalTime,process.burstTime,completionTime,turnAroundTime,waitingTime);
            System.out.println("\n");
            
        }
        System.out.printf("%d\t\t%d\t\t%n",totalTurnAroundTime,totalWaitingTime);

    }
    
}