import java.util.ArrayList;
import java.util.Scanner;

public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ProcessRR> processes = new ArrayList<>();
        System.out.println("No. of processes: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Process ID: ");
            int pid = sc.nextInt();
            System.out.println("Arrival time: ");
            int at = sc.nextInt();
            System.out.println("Burst time: ");
            int bt = sc.nextInt();
            processes.add(new ProcessRR(pid, at, bt));
        }
        System.out.println("Enter time quatum: ");
        int quantum = sc.nextInt();

        roundRobin(processes, quantum);
        sc.close();
    }

    
    public static void roundRobin(ArrayList<ProcessRR> processes, int quantum) {
        int currentTime = 0, completionTime = 0, turnAroundTime = 0, waitingTime = 0, completedProcess = 0;
        int totalTurnAroundTime = 0, totalWaitingTime = 0;
        int n = processes.size();

        System.out.println("Process\tArrival Time \t Burst Time\tCompletion Time \tTurn Around Time \t Waiting Time");
        while (completedProcess < n) {
            for (ProcessRR process : processes) {
                if (process.remainingTime > 0) {
                    int slice = Math.min(process.remainingTime, quantum);
                    currentTime += slice;
                    process.remainingTime -= slice;

                    if (process.remainingTime == 0) {
                        completionTime = currentTime;
                        turnAroundTime = completionTime - process.arrivalTime;
                        waitingTime = turnAroundTime - process.burstTime;
                        totalTurnAroundTime += turnAroundTime;
                        totalWaitingTime += waitingTime;
                        completedProcess++;
                        System.out.println(process.id + "\t\t" + process.arrivalTime + "\t\t"
                                + process.burstTime + "\t\t" + completionTime + "\t\t" + turnAroundTime + "\t\t"
                                + waitingTime);
                    }

                }
            }
        }
        System.out.println("Total turn around time: "+totalTurnAroundTime);
        System.out.println("Total waiting time: "+totalWaitingTime);
        System.out.println("Average TAT:"+ ((double)totalTurnAroundTime/n));
        System.out.println("Average WT:"+ ((double)totalWaitingTime/n));
    }
}