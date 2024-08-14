import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int i = 2;
        while(n>1){
            if(n%i==0){
                System.out.println(i);
                n = n/i;
            }else
                i++;
        }
    }
}