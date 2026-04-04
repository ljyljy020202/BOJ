import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] pNum = new long[91];

        pNum[1] = 1;
        pNum[2] = 1;
        for(int i=3;i<=90;i++){
            pNum[i] = pNum[i-1] + pNum[i-2];
            if(i==n)
                break;
        }

        System.out.println(pNum[n]);
    }
}