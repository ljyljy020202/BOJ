import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(factZero(n));


    }
    static int factZero(int k){
        int five = 0;
        int mod = 5;
        while(k>=mod){
            five += k/mod;
            mod = mod*5;
        }
        return five;
    }
}
