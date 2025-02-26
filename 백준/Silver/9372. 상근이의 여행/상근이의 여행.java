import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            while (m-- > 0){
                int a = scan.nextInt();
                int b = scan.nextInt();
            }
            sb.append(n - 1 + "\n");
        }

        System.out.println(sb);
    }
}