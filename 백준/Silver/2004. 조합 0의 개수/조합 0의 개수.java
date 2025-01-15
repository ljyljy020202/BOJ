import java.io.IOException;
import java.util.Scanner;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        if(m>n/2)
            m = n-m;
        int two = getFactNum(n,2)-getFactNum(n-m,2)-getFactNum(m,2);
        int five = getFactNum(n,5)-getFactNum(n-m,5)-getFactNum(m,5);
        System.out.println(min(two,five));
    }
    static int getFactNum(int k, int num){
        int cnt = 0;
        long mod = num;
        while(k>=mod){
            cnt += k/mod;
            mod = mod*num;
        }
        return cnt;
    }
}