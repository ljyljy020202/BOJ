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
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());   //가로 길이
            int n = Integer.parseInt(st.nextToken());   //세로 길이
            int k = Integer.parseInt(st.nextToken());   //배추가 심어져 있는 위치의 개수

            int[][] cabbage = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            while(k-->0){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbage[y][x]=1;
            }

            int cnt=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(cabbage[i][j]==1 && !visited[i][j]){
                        bfs(j,i,cabbage,visited);
                        cnt++;
                    }
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }

    static void bfs(int startX, int startY, int[][] graph, boolean[][] visited) {
        Point start = new Point(startX, startY);
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[startY][startX] = true;

        // 큐가 빌 때까지 반복
        while(!q.isEmpty()) {
            Point node = q.poll();
            int x=node.x;
            int y=node.y;

            // 큐에서 꺼낸 노드와 연결된 노드들 체크(상,하,좌,우)
            // 방문하지 않았으면 방문처리 후 큐에 넣기
            if(y>0 && graph[y-1][x]==1 && !visited[y-1][x]){
                visited[y-1][x]=true;
                q.offer(new Point(x,y-1));
            }
            if(y<graph.length-1 && graph[y+1][x]==1 && !visited[y+1][x]){
                visited[y+1][x]=true;
                q.offer(new Point(x,y+1));
            }
            if(x>0 && graph[y][x-1]==1 && !visited[y][x-1]){
                visited[y][x-1]=true;
                q.offer(new Point(x-1,y));
            }
            if(x<graph[0].length-1 && graph[y][x+1]==1 && !visited[y][x+1]){
                visited[y][x+1]=true;
                q.offer(new Point(x+1,y));
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
