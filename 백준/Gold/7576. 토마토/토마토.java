import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int x,y,day;
        public Node(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Node> q = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(graph[i][j]==1){
                    q.offer(new Node(j,i,0));
                    visited[i][j] = true;
                }
            }
        }
        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};

        int maxDay = 0;
        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int day = node.day;

            maxDay = Math.max(maxDay, day);

            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<m && ny>=0 && ny<n
                        && !visited[ny][nx]
                        && graph[ny][nx]==0
                ){
                    q.offer(new Node(nx,ny,day+1));
                    graph[ny][nx] = 1;
                    visited[ny][nx] = true;
                }
            }
        }

        if(testAll())
            System.out.println(maxDay);
        else System.out.println(-1);
    }
    static boolean testAll(){
        for(int i=0;i<graph.length;i++)
            for(int j=0;j<graph[0].length;j++)
                if(graph[i][j]==0)
                    return false;
        return true;
    }
}