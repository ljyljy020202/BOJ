import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        ArrayDeque<Integer> deque;

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");

            deque = new ArrayDeque<>();
            for(int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean reverse = false;
            boolean error = false;

            for(int j=0;j<p.length();j++){
                char ch = p.charAt(j);
                if(ch=='R')
                    reverse = !reverse;
                else{
                    if(!reverse) {
                        if(deque.poll() == null)
                            error = true;
                    }
                    else{
                        if(deque.pollLast() == null)
                            error = true;
                    }
                }
            }

            if(error){
                sb.append("error\n");
            }else{
                sb.append('[');
                if(deque.size()>0){
                    if(!reverse){
                        sb.append(deque.poll());
                        while(!deque.isEmpty())
                            sb.append(',').append(deque.poll());
                    }else{
                        sb.append(deque.pollLast());
                        while(!deque.isEmpty())
                            sb.append(',').append(deque.pollLast());
                    }
                }
                sb.append(']').append('\n');
            }
        }
        System.out.println(sb);
    }
}