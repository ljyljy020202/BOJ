import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            String tmp[] = br.readLine().split(" ");
            int n = Integer.parseInt(tmp[0]);
            int m = Integer.parseInt(tmp[1]);
            List<Integer> Alist = new ArrayList<>();
            List<Integer> Blist = new ArrayList<>();

            tmp = br.readLine().split(" ");
            for(int i=0;i<n;i++){
                Alist.add(Integer.parseInt(tmp[i]));
            }
            tmp = br.readLine().split(" ");
            for(int i=0;i<m;i++){
                Blist.add(Integer.parseInt(tmp[i]));
            }

            Collections.sort(Alist, Collections.reverseOrder());
            Collections.sort(Blist, Collections.reverseOrder());

            int idx=0;
            int pairs=0;
            for(int i=0;i<n;i++){
                while(idx<m && Alist.get(i)<=Blist.get(idx)){
                    idx++;
                }
                if(idx==m)
                    break;
                pairs += m-idx;
            }

            System.out.println(pairs);
        }
    }
}
