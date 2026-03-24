import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};

    static class Node{
        int x,y,time;
        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            visited = new boolean[h][w];
            int posX = 0;
            int posY = 0;

            for(int i=0;i<h;i++){
                String[] row = br.readLine().split("");
                for(int j=0;j<w;j++){
                    if(row[j].equals("."))
                        map[i][j] = 0;
                    else if(row[j].equals("#"))
                        map[i][j] = 1;
                    else if(row[j].equals("*"))
                        map[i][j] = 2;
                    else{
                        posX = j;
                        posY = i;
                    }
                }
            }

            int sec = 1;
            boolean escape = false;
            Queue<Node> q = new ArrayDeque<>();
            q.offer(new Node(posX, posY, 0));
            visited[posY][posX] = true;

            Queue<Node> fireQ = new ArrayDeque<>();
            for(int i=0;i<h;i++)
                for(int j=0;j<w;j++)
                    if(map[i][j]==2)
                        fireQ.offer(new Node(j,i,0));

            while(!q.isEmpty() && !escape){
                Node pos = q.poll();
                int x = pos.x;
                int y = pos.y;
                int time = pos.time;
                sec = time+1;

                // 새로운 1초 동안 불의 이동
                while(!fireQ.isEmpty() && fireQ.peek().time<sec){
                    Node node = fireQ.poll();
                    int fireX = node.x;
                    int fireY = node.y;
                    int fTime = node.time;

                    for(int a=0;a<4;a++){
                        int nx = fireX+dx[a];
                        int ny = fireY+dy[a];
                        if(nx>=0 && nx<map[0].length
                                && ny>=0 && ny<map.length
                                && map[ny][nx]==0) {
                            fireQ.offer(new Node(nx,ny,fTime+1));
                            map[ny][nx] = 2;
                        }
                    }
                }

                for(int a=0;a<4;a++){
                    int nx = x+dx[a];
                    int ny = y+dy[a];
                    if(nx<0 || nx>=map[0].length || ny<0 || ny>=map.length){
                        escape = true;
                    }else if(!visited[ny][nx] && map[ny][nx]==0){
                        q.offer(new Node(nx,ny,sec));
                        visited[ny][nx] = true;
                    }
                }
            }

            if(escape)
                sb.append(sec+"\n");
            else sb.append("IMPOSSIBLE\n");
        }
        System.out.println(sb);
    }
}