import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] paper;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        paper = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int max = 0;
        for(int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (!visited[i][j] && paper[i][j]==1) {
                    int area = bfs(i,j);
                    max = Math.max(max,area);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }

    static int bfs(int startY, int startX){
        Point start  = new Point(startX, startY);
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[startY][startX] = true;
        int size = 0;

        while(!q.isEmpty()){
            Point point = q.poll();
            int x = point.x;
            int y = point.y;
            size++;

            if(y>0 && !visited[y-1][x] && paper[y-1][x]==1){
                visited[y-1][x]=true;
                q.offer(new Point(x, y - 1));
            }
            if(y<paper.length-1 && !visited[y+1][x] && paper[y+1][x]==1){
                visited[y+1][x]=true;
                q.offer(new Point(x, y + 1));
            }
            if(x>0 && !visited[y][x-1] && paper[y][x-1]==1){
                visited[y][x-1]=true;
                q.offer(new Point(x - 1, y));
            }
            if(x<paper[0].length-1 && !visited[y][x+1] && paper[y][x+1]==1){
                visited[y][x+1]=true;
                q.offer(new Point(x + 1, y));
            }
        }
        return size;
    }
}