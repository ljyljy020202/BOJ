import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        PriorityQueue<Integer> pqLowest = new PriorityQueue<>();
        PriorityQueue<Integer> pqHighest = new PriorityQueue<>(Collections.reverseOrder());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            int input = Integer.parseInt(br.readLine());
            if(!pqLowest.isEmpty() && input>pqLowest.peek())
                pqLowest.offer(input);
            else
                pqHighest.offer(input);

            while(pqLowest.size()<pqHighest.size())
                pqLowest.offer(pqHighest.poll());
            while(pqLowest.size()>pqHighest.size())
                pqHighest.offer(pqLowest.poll());

            sb.append(pqHighest.peek()+"\n");
        }
        System.out.println(sb);
    }
}