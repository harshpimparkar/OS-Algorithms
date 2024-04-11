import java.util.*;

public class Priority {
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
        priorityNonPremptive(process);
        sc.close();
    }

    public static void priorityNonPremptive(ArrayList<ProcessPriority> processes) {
        Collections.sort(processes, Comparator.comparingInt(p -> p.priority));
        List<ProcessPriority> completedProcesses = new ArrayList<>();
        int completionTime = 0, currentTime = 0, waitingTime = 0, turnAroundTime = 0;
        int totalTurnAroundTime = 0, totalWaitingTime = 0;
        int n = processes.size();

        System.out.println("Process\tArrival Time \t Burst Time\tCompletion Time \tTurn Around Time \t Waiting Time");
            for (ProcessPriority process : processes) {
                waitingTime = currentTime - process.arrivalTime;
                currentTime += process.burstTime;
                completionTime = currentTime;
                turnAroundTime = completionTime - process.arrivalTime;
                totalTurnAroundTime += turnAroundTime;
                totalWaitingTime += waitingTime;
                completedProcesses.add(process);
                System.out.println(process.id + "\t\t" + process.arrivalTime + "\t\t"
                        + process.burstTime + "\t\t" + completionTime + "\t\t" + turnAroundTime + "\t\t"
                        + waitingTime);
        }
        System.out.println("Total turn around time: "+totalTurnAroundTime);
        System.out.println("Total waiting time: "+totalWaitingTime);
        System.out.println("Average TAT:"+ ((double)totalTurnAroundTime/n));
        System.out.println("Average WT:"+ ((double)totalWaitingTime/n));

    }
}