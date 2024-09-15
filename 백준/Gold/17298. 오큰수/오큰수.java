import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
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

        
        int cnt=0;  

        // tmp[0]을 스택에 넣고 idx에 0을 push함
        stack.push(tmp[cnt]);
        idx.push(cnt);
        cnt++;

        // cnt가 n보다 작을 동안
        // tmp[cnt]가 stack의 맨 위 값보다 큰지 확인하고, 크면 stack에서 pop해서 배열에 tmp[cnt]를 저장하고,
        // 그렇지 않다면 tmp[cnt]를 stack에 push하는 것을 반복함
        while(cnt<n){
            int num = tmp[cnt];
            while(!stack.empty() && stack.peek()<num){
                stack.pop();
                tmp[idx.pop()] = num;
            }
            stack.push(num);
            idx.push(cnt);
            cnt++;
        }
        // stack에 남은 요소들은 오큰수가 존재하지 않는 것들이므로 배열의 해당 위치에 -1을 저장함
        while(!stack.empty()){
            stack.pop();
            tmp[idx.pop()]=-1;
        }

        // 출력
        for(int i=0;i<n;i++){
            sb.append(tmp[i]+" ");
        }
        System.out.println(sb);
    }
}