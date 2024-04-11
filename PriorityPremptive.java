import java.util.*;

public class PriorityPremptive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ProcessPriority> process = new ArrayList<>();
        System.out.println("Enter the no of processes: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter process id:");
            int pid = sc.nextInt();
            System.out.println("Enter arrival time:");
            int at = sc.nextInt();
            System.out.println("Enter burst time:");
            int bt = sc.nextInt();
            System.out.println("Enter priority:");
            int priority = sc.nextInt();
            process.add(new ProcessPriority(pid, at, bt, priority));
        }
        priorityPremptive(process);
        sc.close();
    }

    public static void priorityPremptive(List<ProcessPriority> processes) {
        int currentTime = 0, completionTime = 0, completedProcess = 0, turnAroundTime = 0, waitingTime = 0;
        int totalTurnAroundTime = 0, totalWaitingTime = 0;
        int n = processes.size();

        System.out.println("Process\tArrival Time \t Burst Time\tCompletion Time \tTurn Around Time \t Waiting Time");
        while (completedProcess < n) {
            int highestPriority = Integer.MAX_VALUE;
            ProcessPriority currentProcess = null;
            for (ProcessPriority p : processes) {
                if (p.arrivalTime <= currentTime && p.priority < highestPriority) {
                    highestPriority = p.priority;
                    currentProcess = p;
                }
                if (currentProcess != null) {
                    currentProcess.remainingTime--;
                    if (currentProcess.remainingTime == 0) {
                        completedProcess++;
                        waitingTime = currentTime - p.arrivalTime;
                        currentTime = p.burstTime;
                        completionTime = currentTime;
                        turnAroundTime = completionTime - p.arrivalTime;
                        waitingTime = turnAroundTime - p.arrivalTime;
                        totalTurnAroundTime += turnAroundTime;
                        totalWaitingTime += waitingTime;
                        System.out.println(p.id + "\t\t" + p.arrivalTime + "\t\t"
                                + p.burstTime + "\t\t" + completionTime + "\t\t" + turnAroundTime + "\t\t"
                                + waitingTime);
                    }
                }
            }

        }
        System.out.println("Total turn around time: " + totalTurnAroundTime);
        System.out.println("Total waiting time: " + totalWaitingTime);
        System.out.println("Average TAT:" + ((double) totalTurnAroundTime / n));
        System.out.println("Average WT:" + ((double) totalWaitingTime / n));
    }
}
