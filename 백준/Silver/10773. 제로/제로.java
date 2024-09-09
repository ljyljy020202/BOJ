import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int k = Integer.parseInt(br.readLine());

        for(int i=0;i<k;i++){
            int n = Integer.parseInt(br.readLine());
            if(n==0)
                stack.pop();
            else
                stack.push(n);
        }
        int sum=0;
        while(!stack.empty()){
            sum+=stack.pop();
        }

        System.out.println(sum);
    }
}
