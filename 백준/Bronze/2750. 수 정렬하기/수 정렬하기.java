import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>(len);
        for(int i=0;i<len;i++){
            int n = scan.nextInt();
            list.add(n);
        }
        Collections.sort(list);
        for(int i=0;i<len;i++){
            System.out.println(list.get(i));
        }
    }
}