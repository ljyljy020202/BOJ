import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[][] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new boolean[n][n];

        recursion(n,0,0);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(graph[i][j])
                    sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void recursion(int n, int col, int row){
        if(n==1){
            graph[row][col] = true;
            return;
        }

        for(int i=row;i<row+n;i+=n/3){
            for(int j=col;j<col+n;j+=n/3){
                if(!(i==row+n/3 && j==col+n/3))
                    recursion(n/3, j, i);
            }
        }
        
    }
}