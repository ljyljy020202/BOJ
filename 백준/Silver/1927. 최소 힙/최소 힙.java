import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = scan.nextInt();

        while(n-->0){
            int x = scan.nextInt();
            if(x==0){
                if(pq.isEmpty())
                    sb.append(0+"\n");
                else sb.append(pq.poll()+"\n");
            }else pq.offer(x);
        }

        System.out.println(sb);
    }
}