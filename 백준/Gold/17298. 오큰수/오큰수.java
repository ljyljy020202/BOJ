import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> idx = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        // tmp 배열에 입력값 순서대로 저장
        int[] tmp = new int[n];
        int j = 0;
        while (st.hasMoreTokens()) {
            tmp[j++] = Integer.parseInt(st.nextToken());
        }
        // stack1에 순서 거꾸로 push
        for(int i=n-1;i>=0;i--){
            stack1.push(tmp[i]);
        }



        stack2.push(stack1.pop());
        idx.push(n-stack1.size()-1);

        while(!stack1.empty()){
            int num = stack1.pop();
            while(!stack2.empty() && stack2.peek()<num){
                stack2.pop();
                tmp[idx.pop()] = num;
            }
            stack2.push(num);
            idx.push(n-stack1.size()-1);
        }
        while(!stack2.empty()){
            stack2.pop();
            tmp[idx.pop()]=-1;
        }

        for(int i=0;i<n;i++){
            sb.append(tmp[i]+" ");
        }
        System.out.println(sb);
    }
}
