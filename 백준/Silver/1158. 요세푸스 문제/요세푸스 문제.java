import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        List<Integer> list = new ArrayList<>();
        int num[] = new int[n];
        for(int i=0;i<n;i++){
            num[i]=1;
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            int pos;
            int tmp=1;
            while(tmp<k){
                pos = cnt%n;
                if(num[pos]==1)
                    tmp++;
                cnt++;
            }
            pos=cnt%n;
            while(num[pos]==0){
                cnt++;
                pos=cnt%n;
            }
            num[pos]=0;
            list.add(pos);
            cnt++;
        }
        System.out.print("<");
        for(int i=0;i<n-1;i++){
            System.out.print(list.get(i)+1+", ");
        }
        System.out.println(list.get(n-1)+1+">");
    }
}
