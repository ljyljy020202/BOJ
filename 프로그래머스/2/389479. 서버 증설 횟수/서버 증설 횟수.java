import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int cnt = 0;
        int servers = 0;
        int[] added = new int[24];
        
        for(int time = 0; time<24; time++){
            if(time >= k)
                servers -= added[time-k];
            
            int need = players[time]/m;
            if(need > servers){
                int add = need - servers;
                added[time] = add;
                servers += add;
                cnt += add;
            }
        }
        return cnt;
    }
}