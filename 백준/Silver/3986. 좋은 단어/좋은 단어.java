import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i=0;i<n;i++){
            String input = br.readLine();
            for(int j=0;j<input.length();j++){
                char ch = input.charAt(j);
                if(stack.empty() || !stack.peek().equals(ch))
                    stack.push(ch);
                else
                    stack.pop();
            }
            if(stack.empty())
                cnt++;

            while(!stack.empty())
                stack.pop();
        }

        System.out.println(cnt);
    }
}
