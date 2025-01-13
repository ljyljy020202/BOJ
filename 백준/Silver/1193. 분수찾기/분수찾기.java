import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        int cnt = 1;
        int sum = 0;
        while(true){
            sum += cnt;
            if(sum>=input)
                break;
            cnt++;
        }
        int remain = input - (sum-cnt);
        if(cnt%2==1)
            System.out.println((cnt+1-remain)+"/"+remain);
        else
            System.out.println(remain+"/"+(cnt+1-remain));
    }
}