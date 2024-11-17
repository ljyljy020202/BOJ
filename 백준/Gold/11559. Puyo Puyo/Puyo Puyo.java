import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String field[][] = new String[12][6];
        boolean visited[][] = new boolean[12][6];
        boolean check[][] = new boolean[12][6]; // 터질 수 있는 뿌요의 위치
        int chain=0;
        boolean burst = true;

        for(int i=0;i<12;i++){
            field[i] = br.readLine().split("");
        }

        while(burst){
            burst = false;

            // 그래프 탐색을 통해 한 단계 뿌요 터뜨리기
            for(int i=0;i<12;i++){
                for(int j=0;j<6;j++){
                    if(!field[i][j].equals(".") && !visited[i][j]){
                        if(bfs(j,i,field,visited)>=4)
                            burst = true;
                    }
                }
            }
            if(!burst)
                break;

            // 블럭 내리기
            for(int j=0;j<6;j++){
                Queue<String> q = new LinkedList<>();
                for(int i=11;i>=0;i--){
                    if(!field[i][j].equals(".")){
                        q.add(field[i][j]);
                        field[i][j]=".";
                    }
                }
                int idx = 11;
                while(!q.isEmpty()){
                    field[idx][j] = q.poll();
                    idx--;
                }
            }

            // visited 초기화
            for(int i=0;i<12;i++){
                for(int j=0;j<6;j++){
                    visited[i][j] = false;
                }
            }

            // 연쇄 횟수
            chain++;
        }
        System.out.println(chain);
    }

    static int bfs(int startX, int startY, String[][] graph, boolean[][] visited) {
        Point start = new Point(startX, startY);
        Queue<Point> q = new LinkedList<>();
        Queue<Point> tmp = new LinkedList<>();
        q.offer(start);
        visited[startY][startX] = true;

        int cnt = 0;  // 그룹 내 뿌요의 개수

        // 큐가 빌 때까지 반복
        while(!q.isEmpty()) {
            Point node = q.poll();
            int x=node.x;
            int y=node.y;
            tmp.offer(node);
            cnt++;

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

        if(cnt>=4){
            while(!tmp.isEmpty()){
                Point node = tmp.poll();
                graph[node.y][node.x] = ".";
            }
        }
        return cnt;
    }
}