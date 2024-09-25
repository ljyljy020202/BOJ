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
            int I = Integer.parseInt(br.readLine());
            boolean[][] board = new boolean[I][I];
            st = new StringTokenizer(br.readLine());
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            int cnt = bfs(start, end, board);
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }

    static int bfs(Point start, Point end, boolean[][] board) {
        Queue<Point> q = new LinkedList<>();
        if(start.x==end.x && start.y==end.y)
            return 0;

        q.offer(start);
        board[start.y][start.x] = true;
        int[][] vector = {{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}};
        int level=0;
        boolean check = false;

        // 큐가 빌 때까지 반복
        while(!q.isEmpty()&&!check) {
            int qsize = q.size();
            for(int i=0;i<qsize&&!check;i++){
                Point node = q.poll();
                int x=node.x;
                int y=node.y;

                // 주위에 이동 가능한 8칸 중 방문하지 않은 칸들을 방문 처리 후 큐에 넣기
                for(int j=0;j<8;j++){
                    int xvec = vector[j][0];
                    int yvec = vector[j][1];

                    // 이동하려는 칸에 도착한 경우
                    if(x+xvec==end.x && y+yvec==end.y){
                        check=true;
                        break;
                    }
                    if(y+yvec>=0 && y+yvec<board.length && x+xvec>=0 && x+xvec<board.length){
                        if(!board[y+yvec][x+xvec]){
                            board[y+yvec][x+xvec]=true;
                            q.offer(new Point(x+xvec,y+yvec));
                        }
                    }
                }
            }
            level++;
        }
        return level;
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