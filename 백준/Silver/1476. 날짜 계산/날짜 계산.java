import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int E = scan.nextInt()%15;
        int S = scan.nextInt()%28;
        int M = scan.nextInt()%19;
        int cnt=1;
        while(true){
            if(cnt%15==E && cnt%28==S && cnt%19==M)
                break;
            cnt++;
        }
        System.out.println(cnt);
    }
}