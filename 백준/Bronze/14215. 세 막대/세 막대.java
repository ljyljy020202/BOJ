import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[3];
        for(int i=0;i<3;i++){
            arr[i] = scan.nextInt();
        }
        int maxidx = 0;
        for(int i=1;i<3;i++){
            if(arr[i]>arr[maxidx])
                maxidx=i;
        }
        int sum=0;
        for(int i=0;i<3;i++){
            if(i!=maxidx)
                sum += arr[i];
        }

        if(arr[maxidx]>=sum)
            System.out.println(sum*2-1);
        else
            System.out.println(sum+arr[maxidx]);
    }
}