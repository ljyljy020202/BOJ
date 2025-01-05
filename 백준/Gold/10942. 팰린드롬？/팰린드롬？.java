import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[] word = new int[n];
        String[] tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++)
            word[i] = Integer.parseInt(tmp[i]);
        int m = Integer.parseInt(br.readLine());
        int[][] question = new int[m][2];
        for(int i=0;i<m;i++){
            String[] q = br.readLine().split(" ");
            question[i][0] = Integer.parseInt(q[0]);
            question[i][1] = Integer.parseInt(q[1]);
        }

        // dp 알고리즘
        int[][] answer = new int[n][n]; // s행의 e열은 s,e에 대한 대답을 저장
        for(int i=0;i<n;i++)    //s=e인 경우 모두 1로 저장
            answer[i][i]=1;

        int diff = 1;   // s와 e의 차
        for(int i=0;i<n-diff;i++){
            if(word[i]==word[i+diff]) answer[i][i+diff]=1;
        }
        diff++; // diff=2부터
        while(diff<n){
            for(int i=0;i<n-diff;i++){
                if(word[i]==word[i+diff] && answer[i+1][i+diff-1] == 1)
                    answer[i][i+diff]=1;
            }
            diff++;
        }

        // 출력
        for(int i=0;i<m;i++){
            sb.append(answer[question[i][0]-1][question[i][1]-1]+"\n");
        }
        System.out.println(sb);
    }
}