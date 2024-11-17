import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Map<Integer, Integer> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();

        int n = scan.nextInt();
        int c = scan.nextInt();
        for(int i=0;i<n;i++){
            int tmp = scan.nextInt();
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort((entry1, entry2) -> {
            if (!entry1.getValue().equals(entry2.getValue())) {
                return entry2.getValue() - entry1.getValue(); // value 내림차순
            }
            return 0; // value가 같으면 순서 유지
        });

        for (Map.Entry<Integer, Integer> entry : entryList) {
            int key = entry.getKey();
            int value = entry.getValue();
            for(int i=0;i<value;i++)
                sb.append(key+" ");
        }

        System.out.println(sb);
    }
}
