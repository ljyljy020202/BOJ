import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        int tc = 1;
        while(true){
            String[] tmp = br.readLine().split(" ");
            int n = Integer.parseInt(tmp[0]);
            int m = Integer.parseInt(tmp[1]);

            //  입력의 끝인 경우
            if(n==0) break;

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            boolean[] visited = new boolean[n+1];
            for(int i=0;i<=n;i++){
                graph.add(new ArrayList<Integer>()); // 정점의 수 + 1만큼 초기화
            }
            while(m-->0){
                tmp = br.readLine().split(" ");
                int a = Integer.parseInt(tmp[0]);
                int b = Integer.parseInt(tmp[1]);
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            //  그래프 탐색하여 트리 개수 세기
            int cnt = 0;
            for(int i=1;i<=n;i++){
                if(!visited[i] && dfs(graph,visited,0,i))
                    cnt++;
            }

            //  출력문 append
            printResult(tc, cnt);
            tc++;
        }
        System.out.println(sb);
    }

    private static void printResult(int tc, int cnt) {
        if(cnt==0)
            sb.append("Case "+tc+": No trees.\n");
        else if(cnt==1)
            sb.append("Case "+tc+": There is one tree.\n");
        else sb.append("Case "+tc+": A forest of "+cnt+" trees.\n");
    }

    static boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int prev, int idx){
        boolean tree = true;
        visited[idx] = true;

        for (int v : graph.get(idx)) {
            if(v==prev)
                continue;
            if (!visited[v]){
                if(!dfs(graph,visited,idx,v))
                    tree = false;
            }else tree = false;
        }
        return tree;
    }
}