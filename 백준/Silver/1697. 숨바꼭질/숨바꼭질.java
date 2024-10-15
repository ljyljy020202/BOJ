import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        boolean arr[] = new boolean[100001];
        int time = bfs_HAS(n,k,arr);

        System.out.println(time);
    }

    static int bfs_HAS(int start, int end, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        if(start==end)
            return 0;

        visited[start] = true;
        q.offer(start);
        int cnt=0;
        boolean check = false;

        // 큐가 빌 때까지 반복
        while(!q.isEmpty()&&!check) {
            int qsize = q.size();
            for(int i=0;i<qsize&&!check;i++){
                int x = q.poll();

                if(x>0 && !visited[x-1]){
                    if(x-1==end){
                        check = true;
                        break;
                    }
                    visited[x-1]=true;
                    q.offer(x-1);
                }
                if(x<100000 && !visited[x+1]){
                    if(x+1==end){
                        check = true;
                        break;
                    }
                    visited[x+1]=true;
                    q.offer(x+1);
                }
                if(2*x<100001 && !visited[2*x]){
                    if(2*x==end){
                        check = true;
                        break;
                    }
                    visited[2*x]=true;
                    q.offer(2*x);
                }
            }
            cnt++;
        }
        return cnt;
    }
}
