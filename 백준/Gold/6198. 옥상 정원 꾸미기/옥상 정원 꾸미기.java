import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            left.push(Integer.parseInt(br.readLine()));
        }
        while(!left.isEmpty()){
            right.push(left.pop());
        }

        long cnt = 0;
        left.push(right.pop());
        while(!right.isEmpty()){
            int tmp = right.pop();
            while(!left.isEmpty() && tmp>=left.peek()){
                left.pop();
            }
            cnt += left.size();
            left.push(tmp);
        }

        System.out.println(cnt);
    }
}
