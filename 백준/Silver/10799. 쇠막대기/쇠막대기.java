import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        int piece = 0;

        for(int i=0;i<input.length();i++){
            char cur = input.charAt(i);
            if(cur=='(' && input.charAt(i+1)==')'){
                piece += stack.size();
                i++;
            }else if(cur=='('){
                stack.push(cur);
            }else if(cur==')'){
                piece += 1;
                stack.pop();
            }
        }
        System.out.println(piece);
    }
}
