import java.util.*;

class Solution {   
    static int maxOpen;
    public int solution(int n, int infection, int[][] edges, int k) {
        boolean[] infected = new boolean[n+1];
        infected[infection] = true;
        maxOpen = k;
        int max = 0;
        
        for(int i=1; i<=3; i++){
            boolean[] copy = infected.clone();
            int result = infect(copy, i, edges, 1);
            max = Math.max(max, result);
        }
        
        return max;
    }
    
    int infect(boolean[] infected, int type, int[][] edges, int depth){
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<infected.length; i++){
            if(infected[i])
                q.offer(i);
        }
        while(!q.isEmpty()){
            int n = q.poll();
            for(int[] edge: edges){
                if(edge[2]==type){
                    if(edge[0]==n && !infected[edge[1]]){
                        infected[edge[1]] = true;
                        q.offer(edge[1]);
                    }else if(edge[1]==n && !infected[edge[0]]){
                        infected[edge[0]] = true;
                        q.offer(edge[0]);
                    }
                }
            }
        }
        
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<infected.length; i++){
            if(infected[i]){
                cnt++;
                sb.append(i+" ");
            }
        }
        System.out.println("infected(depth="+depth+"): "+sb);
        if(depth == maxOpen)
            return cnt;
        
        boolean[] copy1 = infected.clone();
        boolean[] copy2 = infected.clone();
        
        int next1 = (type+1)%3==0 ? 3 : (type+1)%3;
        int next2 = (type+2)%3==0 ? 3 : (type+2)%3;
        
        return Math.max(infect(copy1, next1, edges, depth+1), infect(copy2, next2, edges, depth+1));
    }
}