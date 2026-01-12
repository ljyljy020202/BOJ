import java.util.*;

public class Main {
    public static void main(String[] args){
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        for(int i=0;i<n;i++){
            map.put(scan.next(),0);
        }

        for(int i=0;i<m;i++){
            String name = scan.next();
            if(map.containsKey(name))
                list.add(name);
        }

        Collections.sort(list);
        System.out.println(list.size());

        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));
    }
}