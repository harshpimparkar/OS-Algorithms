import java.util.ArrayList;
import java.util.Scanner;

public class SJFpremptive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ProcessRR> process = new ArrayList<>();
        System.out.println("Enter the no of processes: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter process id:");
            int pid = sc.nextInt();
            System.out.println("Enter arrival time:");
            int at = sc.nextInt();
            System.out.println("Enter burst time:");
            int bt = sc.nextInt();

            process.add(new ProcessRR(pid, at, bt));
        }
        sjfPremptive(process);
        sc.close();
    }

    public static void sjfPremptive(ArrayList<ProcessRR> processes) {
        int currentTime = 0, completionTime = 0, waitingTime = 0, turnAroundTime = 0, completedProcess = 0;
        int totalTurnAroundTime = 0, totalWaitingTime = 0, n = processes.size();
        ProcessRR shortestProcess = null;
        int shortestBurst = Integer.MAX_VALUE;

        System.out.println("Process\tArrival Time \t Burst Time\tCompletion Time \tTurn Around Time \t Waiting Time");
        while (completedProcess < n) {
            for (ProcessRR process : processes) {
                if (process.arrivalTime <= currentTime && process.remainingTime < shortestBurst) {
                    shortestBurst = process.remainingTime;
                    shortestProcess = process;
                }
                if (shortestProcess == null) {
                    currentTime++;
                } else {
                    process.remainingTime--;
                    currentTime++;
                    if (process.remainingTime == 0) {
                        completedProcess++;
                        completionTime = currentTime;
                        turnAroundTime = completionTime - process.arrivalTime;
                        waitingTime = turnAroundTime - process.arrivalTime;
                        totalTurnAroundTime += turnAroundTime;
                        totalWaitingTime += waitingTime;
                        System.out.printf("%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t\t%d", process.id, process.arrivalTime,
                                process.burstTime, completionTime, turnAroundTime, waitingTime);
                        System.out.println("\n");

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
