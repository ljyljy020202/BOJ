import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deq;

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            String funcList = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String tmp = br.readLine();
            String[] arr = tmp.substring(1, tmp.length()-1).split(",");

            deq = new LinkedList<>();
            for(int i=0; i<n; i++)
                deq.add(Integer.parseInt(arr[i]));

            boolean reversed = false;
            boolean error = false;

            for(int i=0; i<funcList.length() && !error; i++){
                String func = String.valueOf(funcList.charAt(i));
                if(func.equals("R"))
                    reversed = !reversed;
                else{
                    if(deq.isEmpty())
                        error = true;
                    else if(reversed)
                        deq.pollLast();
                    else deq.poll();
                }
            }
            if(error)
                sb.append("error\n");
            else buildArr(deq, reversed, sb);
        }
        System.out.println(sb);
    }

    static void buildArr(Deque<Integer> deq, boolean reversed, StringBuilder sb){
        sb.append("[");
        if(!deq.isEmpty()){
            if(reversed){
                while(deq.size()>1)
                    sb.append(deq.pollLast()+",");
                sb.append(deq.pollLast());
            }else{
                while(deq.size()>1)
                    sb.append(deq.poll()+",");
                sb.append(deq.poll());
            }
        }
        sb.append("]\n");
    }
}