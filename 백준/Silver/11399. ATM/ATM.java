import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        while(n-->0){
            list.add(scan.nextInt());
        }
        Collections.sort(list);
        int sum=0;
        int time=0;
        for(int i : list){
            time += i;
            sum += time;
        }
        System.out.println(sum);
    }
}