import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Main {
    static int[][][] graph;
    static Queue<Node> q;
    static int[] dx = new int[]{1,-1,0,0,0,0};
    static int[] dy = new int[]{0,0,1,-1,0,0};
    static int[] dz = new int[]{0,0,0,0,1,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        graph = new int[h][n][m];

        // drawing
        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<m;k++){
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // search
        q = new ArrayDeque<>();
        for(int i=0;i<h;i++)
            for(int j=0;j<n;j++)
                for(int k=0;k<m;k++)
                    if(graph[i][j][k]==1){
                        q.offer(new Node(k,j,i,0));
                    }
        int maxDay = bfs();

        if(testAll())
            System.out.println(maxDay);
        else System.out.println(-1);
    }

    static int bfs(){
        int maxDay = 0;

        while(!q.isEmpty()){
            Node node = q.poll();

            int x = node.x;
            int y = node.y;
            int z = node.z;
            int day = node.day;

            maxDay = max(maxDay, day);

            for(int a=0;a<6;a++){
                int nx = x+dx[a];
                int ny = y+dy[a];
                int nz = z+dz[a];
                if(nx>=0 && nx<graph[0][0].length
                        && ny>=0 && ny<graph[0].length
                        && nz>=0 && nz<graph.length
                        && graph[nz][ny][nx]==0
                ){
                    graph[nz][ny][nx] = 1;
                    q.offer(new Node(nx,ny,nz,day+1));
                }
            }
        }
        return maxDay;
    }

    static boolean testAll(){
        for(int i=0;i<graph.length;i++)
            for(int j=0;j<graph[0].length;j++)
                for(int k=0;k<graph[0][0].length;k++)
                    if(graph[i][j][k]==0)
                        return false;
        return true;
    }
}

class Node{
    int x,y,z,day;
    public Node(int x, int y, int z, int day) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.day = day;
    }
}
