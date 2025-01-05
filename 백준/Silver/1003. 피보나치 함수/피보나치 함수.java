import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        while(t-->0){
            int n = scan.nextInt();
            int[] zero = new int[41];
            int[] one = new int[41];
            zero[0] = 1;
            zero[1] = 0;
            one[0] = 0;
            one[1] = 1;
            for(int i=2;i<=n;i++){
                zero[i] = zero[i-1]+zero[i-2];
                one[i] = one[i-1]+one[i-2];
            }
            System.out.println(zero[n]+" "+one[n]);
        }
    }
}