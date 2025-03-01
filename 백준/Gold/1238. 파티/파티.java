import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int INF = 100000000;
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int x = Integer.parseInt(tmp[2]);
        int[][] graph = new int[n+1][n+1];
        int[] result = new int[n+1];

        for(int i=0;i<n+1;i++)
            for(int j=0;j<n+1;j++)
                if(i!=j)
                    graph[i][j] = INF;

        while(m-->0){
            tmp = br.readLine().split(" ");
            graph[Integer.parseInt(tmp[0])][Integer.parseInt(tmp[1])] = Integer.parseInt(tmp[2]);
        }

        for(int k=1;k<n+1;k++)
            for(int i=1;i<n+1;i++)
                for(int j=1;j<n+1;j++)
                    graph[i][j] = min(graph[i][j],graph[i][k]+graph[k][j]);

        int max = 0;
        for(int i=1;i<n+1;i++){
            result[i] = graph[i][x]+graph[x][i];
            if(result[i]>max)
                max = result[i];
        }
        System.out.println(max);
    }
}