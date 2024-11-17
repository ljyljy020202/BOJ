import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            list.add(br.readLine());
        }

        // 사전식 정렬
        Collections.sort(list);

        // 글자수 정렬
        Collections.sort(list,new WordComparator());

        for(int i=0;i<n;i++){
            String s = list.get(i);
            if(i>0){
                String prev = list.get(i-1);
                if(!prev.equals(s))
                    sb.append(s+"\n");
            }else
                sb.append(s+"\n");
        }

        System.out.println(sb);
    }
}

class WordComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length()-o2.length();
    }
}