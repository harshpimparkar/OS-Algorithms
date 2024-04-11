public class Process {
    public int id;
    public int arrivalTime;
    public int burstTime;
    // public int priority;
    public Process(int id,int arrivalTime,int burstTime/* ,int priority*/){
        this.id = id;
        this.arrivalTime=arrivalTime;
        this.burstTime=burstTime;
    }
}