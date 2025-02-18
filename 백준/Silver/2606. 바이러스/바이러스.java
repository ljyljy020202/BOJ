import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        boolean[] visited = new boolean[n+1];
        boolean[][] graph = new boolean[n+1][n+1];
        int cnt = 0;

        while(m-->0){
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph[a][b] = true;
            graph[b][a] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i=1;i<=n;i++){
                if(graph[cur][i]==true && visited[i] == false) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

        for(int i=2;i<n+1;i++)
            if(visited[i])
                cnt++;
        System.out.println(cnt);
    }
}