import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String grid[][] = new String[n][n];
        boolean visited[][] = new boolean[n][n];
        int area1=0;
        int area2=0;
        for(int i=0;i<n;i++){
            String line[] = br.readLine().split("");
            grid[i]=line;
        }

        // 적록색약이 아닌 경우
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    bfs_(j,i,grid,visited);
                    area1++;
                }
            }
        }

        // visited 배열 전부 false로 바꾸기, grid에서 G를 모두 R로 바꾸기
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                visited[i][j]=false;
                if(grid[i][j].equals("G")){
                    grid[i][j]="R";
                }
            }
        }

        // 적록색약인 경우
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    bfs_(j,i,grid,visited);
                    area2++;
                }
            }
        }

        System.out.println(area1+" "+area2);
    }

    static void bfs_(int startX, int startY, String[][] graph, boolean[][] visited) {
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
            if(y>0 && graph[y-1][x].equals(graph[y][x]) && !visited[y-1][x]){
                visited[y-1][x]=true;
                q.offer(new Point(x,y-1));
            }
            if(y<graph.length-1 && graph[y+1][x].equals(graph[y][x]) && !visited[y+1][x]){
                visited[y+1][x]=true;
                q.offer(new Point(x,y+1));
            }
            if(x>0 && graph[y][x-1].equals(graph[y][x]) && !visited[y][x-1]){
                visited[y][x-1]=true;
                q.offer(new Point(x-1,y));
            }
            if(x<graph[0].length-1 && graph[y][x+1].equals(graph[y][x]) && !visited[y][x+1]){
                visited[y][x+1]=true;
                q.offer(new Point(x+1,y));
            }

        }
    }
}
