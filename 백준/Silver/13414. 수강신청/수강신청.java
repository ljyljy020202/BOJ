import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int k = scan.nextInt();
        int l = scan.nextInt();
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        while(l-->0){
            String key = scan.next();
            if(map.containsKey(key)){
                map.replace(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
            list.add(key);
        }

        int idx = 0;
        int cnt = 0;
        while(idx<list.size() && cnt<k){
            String data = list.get(idx);
            if(map.get(data)==1){
                sb.append(data+"\n");
                cnt++;
            }else{
                map.replace(data,map.get(data)-1);
            }
            idx++;
        }

        System.out.println(sb);
    }

}