import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][3];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<3;j++){
                int a = (j+1)%3;
                int b = (j+2)%3;
                int sum_a = cost[i][j]+cost[i-1][a];
                int sum_b = cost[i][j]+cost[i-1][b];

                cost[i][j] = Math.min(sum_a,sum_b);
            }
        }

        int min = 1000001;
        for(int j=0;j<3;j++){
            if(cost[n-1][j]<min)
                min = cost[n-1][j];
        }

        System.out.println(min);
    }
}