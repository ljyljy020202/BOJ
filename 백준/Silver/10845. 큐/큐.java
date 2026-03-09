import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            String[] tmp;
            tmp = br.readLine().split(" ");
            switch(tmp[0]){
                case "push":
                    deq.add(Integer.parseInt(tmp[1]));
                    break;
                case "pop":
                    if(deq.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(deq.poll()+"\n");
                    break;
                case "size":
                    sb.append(deq.size()+"\n");
                    break;
                case "empty":
                    if(deq.isEmpty())
                        sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "front":
                    if(deq.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(deq.peek()+"\n");
                    break;
                case "back":
                    if(deq.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(deq.peekLast()+"\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}