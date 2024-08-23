import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        for(int i = 0; i < 10; i++) {
            arr[i] = 0;
        }
        
        String input = bf.readLine();
        int num = Integer.parseInt(input);

        for(int i=0;i<input.length();i++){
            arr[num%10]++;
            num=num/10;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
            for(int j = 0; j < arr[i]; j++) {
                sb.append(i);
            }
        }

        System.out.print(sb.toString());
    }
}
