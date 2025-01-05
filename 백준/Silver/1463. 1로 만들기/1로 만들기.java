import java.io.IOException;
import java.util.Scanner;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[1000001];
        int n = scan.nextInt();
        arr[1]=0;

        for(int i=2;i<=n;i++){
            arr[i] = arr[i-1]+1;
            if(i%2==0) arr[i] = min(arr[i],arr[i/2]+1);
            if(i%3==0) arr[i] = min(arr[i],arr[i/3]+1);
        }

        System.out.println(arr[n]);
    }
}