import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int INF = 100000000;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] graph = new int[n+1][n+1];
        
        // 그래프 초기화
        for(int i=0;i<n+1;i++)
            for(int j=0;j<n+1;j++)
                if(i!=j)
                    graph[i][j] = INF;
        // 그래프 입력받기
        while(m-->0){
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            int c = Integer.parseInt(tmp[2]);
            graph[a][b] = min(graph[a][b],c);
            }
        // 플로이드 알고리즘
        for(int k=1;k<n+1;k++)
            for(int i=1;i<n+1;i++)
                for(int j=1;j<n+1;j++)
                    graph[i][j] = min(graph[i][j],graph[i][k]+graph[k][j]);
        // 출력
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(graph[i][j]==0 || graph[i][j]==INF)
                    sb.append(0+" ");
                else sb.append(graph[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}