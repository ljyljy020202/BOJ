import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();

        int cnt = 0;
        for(int i=1;i<x;i++){
            if(i==2)
                cnt += 28;
            else if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10)
                cnt += 31;
            else cnt += 30;
        }
        cnt += y;

        int day = cnt%7;
        if(day==0)
            System.out.println("SUN");
        else if(day==1)
            System.out.println("MON");
        else if(day==2)
            System.out.println("TUE");
        else if(day==3)
            System.out.println("WED");
        else if(day==4)
            System.out.println("THU");
        else if(day==5)
            System.out.println("FRI");
        else if(day==6)
            System.out.println("SAT");
    }
}
