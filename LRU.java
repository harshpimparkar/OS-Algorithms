import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class LRU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("No of page frames: ");
        int numberOfFrames = sc.nextInt();
        LinkedList<Integer> frames = new LinkedList<>();
        ArrayList<Integer> pages = new ArrayList<>();
        System.out.println("Enter the number of page refernces: ");
        int page;
        while((page = sc.nextInt())!=-1){
            pages.add(page);
        }

        int[] result = performLRU(frames,pages,numberOfFrames);
        System.out.println("Hits: "+result[1]);
        System.out.println("Misses: "+ result[0]);
        sc.close();
    }
    public static int[] performLRU(LinkedList<Integer> frames,ArrayList<Integer> pages,int numberOfFrames){
        int hit=0,miss=0;
        for(Integer page : pages){
            if(!frames.remove(page)){
                if(frames.size()>=numberOfFrames){
                    frames.removeLast();
                }
                miss++;
                System.out.println("Miss: "+page+" added.");
            }else{
                hit++;
                System.out.println("Hit: "+hit+" page already present.");
            }
            frames.addFirst(page);
            System.out.println("Frame: "+frames);
        }

        return new int[]{miss,hit};
    }
}
