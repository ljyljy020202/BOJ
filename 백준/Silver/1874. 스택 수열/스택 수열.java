import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int cnt = 1;
        while(n-->0){
            int input = Integer.parseInt(br.readLine());
            while(input >= cnt){
                stack.push(cnt++);
                sb.append("+\n");
            }
            if(stack.isEmpty() || stack.peek()<input){
                System.out.println("NO");
                return;
            }
            while(!stack.isEmpty() && input <= stack.peek()){
                stack.pop();
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }
}