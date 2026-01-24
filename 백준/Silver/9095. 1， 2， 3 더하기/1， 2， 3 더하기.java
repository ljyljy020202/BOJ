import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-->0){
            int n = scan.nextInt();
            int[] arr = new int[n+1];
            for(int i=1;i<=n;i++){
                if(i==1)
                    arr[i]=1;
                else if(i==2)
                    arr[i]=2;
                else if(i==3)
                    arr[i]=4;
                else
                    arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
            }
            System.out.println(arr[n]);
        }
    }
}