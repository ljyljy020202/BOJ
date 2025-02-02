import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pqLowest = new PriorityQueue<>();
            PriorityQueue<Integer> pqHighest = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer,Integer> map = new HashMap<>();

            while(k-->0){
                String[] tmp = br.readLine().split(" ");
                if(tmp[0].equals("I")){
                    int n = Integer.parseInt(tmp[1]);
                    pqLowest.offer(n);
                    pqHighest.offer(n);
                    map.put(n, map.getOrDefault(n, 0) + 1);
                }else if(map.size() != 0){
                    if(tmp[1].equals("1")){
                        remove(pqHighest,map);
                    }else{
                        remove(pqLowest,map);
                    }
                }
            }
            if(map.size() == 0)
                sb.append("EMPTY\n");
            else{
                int n = remove(pqHighest, map);
                sb.append(n + " " + (map.size() > 0 ? remove(pqLowest, map) : n)+"\n");
            }
        }
        System.out.println(sb);
    }
    static int remove(PriorityQueue<Integer> q, Map<Integer,Integer> map){
        int num;
        while(true){
            num = q.poll();
            int cnt = map.getOrDefault(num, 0);
            if (cnt == 0)
                continue;
            if (cnt == 1)
                map.remove(num);
            else
                map.put(num, cnt - 1);
            break;
        }
        return num;
    }
}