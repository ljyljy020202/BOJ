import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        paper = new boolean[m][n];
        while(k-->0){
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            draw(startX, startY, endX, endY);
        }
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (!paper[i][j]) {
                    list.add(bfs(i, j));
                    cnt++;
                }
            }
        }
        Collections.sort(list);
        System.out.println(cnt);
        for(int i=0;i<list.size();i++)
            System.out.print(list.get(i)+" ");
    }
    static void draw(int startX, int startY, int endX, int endY){
        for(int i=startY;i<endY;i++)
            for(int j=startX;j<endX;j++)
                paper[i][j] = true;
    }
    static int bfs(int startY, int startX){
        Point start  = new Point(startX, startY);
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        paper[startY][startX] = true;
        int size = 0;

        while(!q.isEmpty()){
            Point point = q.poll();
            int x = point.x;
            int y = point.y;
            size++;

            if(y>0 && !paper[y-1][x]){
                paper[y-1][x]=true;
                q.offer(new Point(x,y-1));
            }
            if(y<paper.length-1 && !paper[y+1][x]){
                paper[y+1][x]=true;
                q.offer(new Point(x,y+1));
            }
            if(x>0 && !paper[y][x-1]){
                paper[y][x-1]=true;
                q.offer(new Point(x-1,y));
            }
            if(x<paper[0].length-1 && !paper[y][x+1]){
                paper[y][x+1]=true;
                q.offer(new Point(x+1,y));
            }
        }
        return size;
    }
}

class Point{
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}