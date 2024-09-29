import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] iceberg = new int[n][m];
        int[][] mask = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                iceberg[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        int piece = 0;
        while(piece<2){
            piece = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(iceberg[i][j]>0 && !visited[i][j]){
                        bfs(j,i,iceberg,mask,visited);
                        piece++;
                    }
                }
            }
            if(piece==0)
                break;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    visited[i][j] = false;
                }
            }
            year++;
        }
        if(piece==0)
            System.out.println(0);
        else
            System.out.println(year-1);
    }

    static void bfs(int startX, int startY, int[][] graph, int[][] mask, boolean[][] visited) {
        Point start = new Point(startX, startY);
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[startY][startX] = true;

        // 큐가 빌 때까지 반복
        while(!q.isEmpty()) {
            Point node = q.poll();
            int x=node.x;
            int y=node.y;
            int cnt=0;

            // 큐에서 꺼낸 노드와 연결된 노드들 체크(상,하,좌,우)
            // 방문하지 않았으면 방문처리 후 큐에 넣기
            if(y>0 && graph[y-1][x]>0){
                cnt++;
                if(!visited[y-1][x]){
                    visited[y-1][x]=true;
                    q.offer(new Point(x,y-1));
                }
            }
            if(y<graph.length-1 && graph[y+1][x]>0){
                cnt++;
                if(!visited[y+1][x]){
                    visited[y+1][x]=true;
                    q.offer(new Point(x,y+1));
                }
            }
            if(x>0 && graph[y][x-1]>0){
                cnt++;
                if(!visited[y][x-1]){
                    visited[y][x-1]=true;
                    q.offer(new Point(x-1,y));
                }
            }
            if(x<graph[0].length-1 && graph[y][x+1]>0){
                cnt++;
                if(!visited[y][x+1]){
                    visited[y][x+1]=true;
                    q.offer(new Point(x+1,y));
                }
            }
            mask[y][x] = cnt-4;
        }
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[0].length;j++){
                graph[i][j] += mask[i][j];
                mask[i][j]=0;
            }
        }
    }
}
class Point{
    int x;
    int y;
    public Point(int x, int y) {
        this.x=x;
        this.y=y;
    }
}