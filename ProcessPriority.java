public class ProcessPriority {
    public int id;
    public int arrivalTime;
    public int burstTime;
    public int remainingTime;
    public int priority;
    public ProcessPriority(int id,int arrivalTime,int burstTime,int priority){
        this.id=id;
        this.arrivalTime=arrivalTime;
        this.burstTime=burstTime;
        this.remainingTime=burstTime;
        this.priority=priority;
    }
}
