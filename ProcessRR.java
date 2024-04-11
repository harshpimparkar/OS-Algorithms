public class ProcessRR {
    public int id;
    public int arrivalTime;
    public int burstTime;
    public int remainingTime;

    public ProcessRR(int id,int arrivalTime,int burstTime){
        this.id = id;
        this.arrivalTime=arrivalTime;
        this.burstTime=burstTime;
        this.remainingTime=burstTime;
    }
}