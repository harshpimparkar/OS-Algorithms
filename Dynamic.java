public class Dynamic {
    public static void main(String[] args) {
        int[] partitions = { 100, 200, 300, 400, 500 };
        int process = 150;
        bestFit(partitions, process);
        firstFit(partitions, process);
        worstFit(partitions, process);
    }

    public static void bestFit(int[] partitions, int process) {
        int index = -1;
        int largestPartition = partitions[0];
        for (int i = 0; i < partitions.length; i++) {
            if (largestPartition >= process && partitions[i] >= process) {
                largestPartition = Math.min(largestPartition, partitions[i]);
            }
        }

        for (int i = 0; i < partitions.length; i++) {
            if (largestPartition == partitions[i]) {
                index = i+1;
            }
        }
        System.out.println("Best fit index: " + index);
    }
    public static void worstFit(int[] partitions, int process){
        int index =-1;
        int largestPartition=partitions[0];
        for(int i=0;i<partitions.length;i++){
            if(largestPartition>=process && partitions[i]>=process){
                largestPartition=Math.max(largestPartition, partitions[i]);
            }
        }
        for(int i=0;i<partitions.length;i++){
            if(largestPartition==partitions[i]){
                index = i+1;
            }
        }
        System.out.println("Worst fit index: "+index);
    }

    public static void firstFit(int[] partitions, int process){
        int index=-1;
        for(int i=0;i<partitions.length;i++){
            if(partitions[i]>=process){
                index=i+1;
            }
        }
        System.out.println("First fit index: "+index);
    }

}