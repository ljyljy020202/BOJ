import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int cnt = k;

        int result1=1;
        int result2=1;

        for(int i=0;i<cnt;i++){
            result1 = result1*n;
            n--;
            result2 = result2*k;
            k--;
        }

        System.out.println(result1/result2);

    }
}