import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int cnt = 4;
        while(cnt-->0){
            int[] arr = new int[8];
            for(int i=0;i<8;i++)
                arr[i] = scan.nextInt();
            System.out.println(getCode(arr));
        }
    }

    static char getCode(int[] arr){
        if(arr[0]>arr[6] || arr[2]<arr[4])
            return 'd';
        else if(arr[0]==arr[6] || arr[2]==arr[4]){
            if(arr[1]>arr[7] || arr[3]<arr[5])
                return 'd';
            else if(arr[1]==arr[7] || arr[3]==arr[5])
                return 'c';
            else
                return 'b';
        }else{
            if(arr[1]>arr[7] || arr[3]<arr[5])
                return 'd';
            else if(arr[1]==arr[7] || arr[3]==arr[5])
                return 'b';
            else
                return 'a';
        }
    }
}