import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int values[] = new int[n];
        int cnt = 0;

        for(int i=0;i<n;i++){
            values[i] = scan.nextInt();
        }

        int idx = n-1;
        while(k>0){
            while(k>=values[idx]){
                cnt = cnt+k/values[idx];
                k = k%values[idx];
            }
            idx--;
        }

        System.out.println(cnt);
    }
}
