import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n+1];     // 각 정점의 진입 차수
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Integer>()); // 정점의 수 + 1만큼 초기화
        }
        while(m-->0){
            tmp = br.readLine().split(" ");
            graph.get(Integer.parseInt(tmp[0])).add(Integer.parseInt(tmp[1]));
            indegree[Integer.parseInt(tmp[1])]++;
        }
        
        // 정렬 후 출력
        System.out.println(topologySort(graph, indegree));
    }

    static StringBuilder topologySort(ArrayList<ArrayList<Integer>> graph, int[] indegree){
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        // 진입 차수가 0인 정점들을 큐에 삽입
        for(int i=1;i<indegree.length;i++){
            if(indegree[i]==0)
                queue.offer(i);
        }

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            int cur = queue.poll();
            sb.append(cur+" ");
            for (int v : graph.get(cur)) {
                indegree[v]--;
                if(indegree[v]==0)
                    queue.offer(v);
            }
        }

        return sb;
    }
}