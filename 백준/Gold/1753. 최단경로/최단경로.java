import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int to;
        int cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost; // 비용 기준 오름차순
        }
    }
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;
    static int V, E;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        dist = new int[V+1];

        for(int i=0;i<=V;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v,w));
        }

        dijkstra(start);

        for(int i=1;i<=V;i++){
            if(dist[i]!=Integer.MAX_VALUE)
                System.out.println(dist[i]);
            else System.out.println("INF");
        }
    }
    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            int now = cur.to;
            int cost = cur.cost;

            if(dist[now] < cost) continue;

            for(Node next : graph.get(now)){
                int nextNode = next.to;
                int nextCost = cost + next.cost;

                if(dist[nextNode] > nextCost){
                    dist[nextNode] = nextCost;
                    pq.offer(new Node(nextNode, nextCost));
                }
            }
        }
    }
}