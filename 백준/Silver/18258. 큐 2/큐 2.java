import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        int rear=0;

        for(int i=0;i<n;i++){
            String str = br.readLine();
            String[] strArr = str.split(" ");

            if(strArr[0].equals("push")){
                rear = Integer.parseInt(strArr[1]);
                queue.offer(rear);
            }else if(strArr[0].equals("pop")){
                if(queue.size()!=0)
                    sb.append(queue.poll()+"\n");
                else
                    sb.append(-1+"\n");
            }else if(strArr[0].equals("size")){
                sb.append(queue.size()+"\n");
            }else if(strArr[0].equals("empty")){
                if(queue.size()==0)
                    sb.append(1+"\n");
                else
                    sb.append(0+"\n");
            }else if(strArr[0].equals("front")){
                if(queue.size()!=0)
                    sb.append(queue.peek()+"\n");
                else
                    sb.append(-1+"\n");
            }else{
                if(queue.size()!=0)
                    sb.append(rear+"\n");
                else
                    sb.append(-1+"\n");
            }
        }
        System.out.println(sb);
    }
}
