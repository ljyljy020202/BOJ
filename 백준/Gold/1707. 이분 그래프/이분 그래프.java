import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());

        while(k-->0){
            String[] tmp = br.readLine().split(" ");
            int v = Integer.parseInt(tmp[0]);
            int e = Integer.parseInt(tmp[1]);
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            int[] visited = new int[v+1];   //0, 1, -1 세 가지 값으로 나타냄

            for(int i=0;i<=v;i++){
                graph.add(new ArrayList<Integer>()); // 정점의 수 + 1만큼 초기화
                visited[i] = 0; // 방문하지 않은 정점의 색을 0으로 초기화
            }

            while(e-->0){
                tmp = br.readLine().split(" ");
                int a = Integer.parseInt(tmp[0]);
                int b = Integer.parseInt(tmp[1]);
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean bipart = true;
            for(int i=1;i<=v;i++){
                if(visited[i]==0)
                    bipart = bfs(graph,visited,i);
                if(!bipart)
                    break;
            }
            if(bipart)
                sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.println(sb);
    }

    static boolean bfs(ArrayList<ArrayList<Integer>> graph, int[] visited, int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = 1;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for (int v : graph.get(cur)) {
                if (visited[v] == 0) {
                    queue.offer(v);
                    visited[v] = visited[cur] * -1;
                }
                else if (visited[cur]==visited[v]) {
                    return false;
                }
            }
        }
        return true;
    }
}