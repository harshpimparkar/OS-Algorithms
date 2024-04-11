import java.util.ArrayList;
import java.util.Scanner;

public class FIFO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of page frames: ");
        int numberOfFrames = sc.nextInt();
        ArrayList<Integer> pages = new ArrayList<>(numberOfFrames);
        ArrayList<Integer> frames = new ArrayList<>();
        System.out.println("Enter page-reference: ");
        int page;
        while((page=sc.nextInt())!=-1){
            pages.add(page);
        }
        int[] result = performFIFO(frames, pages, numberOfFrames);
        System.out.println("Misses: "+result[0]);
        System.out.println("Hits: "+result[1]);

        sc.close();

    }

    public static int[] performFIFO(ArrayList<Integer> frames, ArrayList<Integer> pages,int numberOfFrames){
        int miss=0;
        int hit=0;
        for(Integer page:pages){
            if(!frames.contains(page)){
                if (frames.size() < numberOfFrames) {
                    frames.add(page);
                }else{
                    frames.remove(0);
                    frames.add(page);
                }
                miss++;
                System.out.println("Miss:\t"+ page +" added.");
            }else{
                hit++;
                System.out.println("Hit: \t"+ page +" already present.");
            }
            System.out.println("Frame: "+frames);
        }

        return new int[]{miss,hit};
    }
}
