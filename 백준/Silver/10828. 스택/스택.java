import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            String str = br.readLine();
            String[] strArr = str.split(" ");

            if(strArr[0].equals("push")){
                stack.push(Integer.parseInt(strArr[1]));
            }else if(strArr[0].equals("pop")){
                if(!stack.empty())
                    sb.append(stack.pop()+"\n");
                else
                    sb.append(-1+"\n");
            }else if(strArr[0].equals("size")){
                sb.append(stack.size()+"\n");
            }else if(strArr[0].equals("empty")){
                if(stack.empty())
                    sb.append(1+"\n");
                else
                    sb.append(0+"\n");
            }else{
                if(!stack.empty())
                    sb.append(stack.peek()+"\n");
                else
                    sb.append(-1+"\n");
            }
        }
        System.out.println(sb);
    }
}
