import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numA = Integer.parseInt(st.nextToken());
        int numB = Integer.parseInt(st.nextToken());

        Map<Integer, Boolean> mapA = new TreeMap<>();
        Map<Integer, Boolean> mapB = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<numA;i++){
            mapA.put(Integer.parseInt(st.nextToken()),false);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<numB;i++){
            mapB.put(Integer.parseInt(st.nextToken()),false);
        }

        for(int key : mapA.keySet()){
            if(mapB.containsKey(key))
                mapA.replace(key,true);
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        for(int key : mapA.keySet()){
            if(!mapA.get(key)){
                cnt++;
                sb.append(key+" ");
            }
        }
        System.out.println(cnt);
        if(cnt!=0)
            System.out.println(sb);
    }
}