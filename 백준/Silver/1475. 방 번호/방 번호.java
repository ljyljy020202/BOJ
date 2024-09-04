import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int arr[] = new int[10];
        for(int i=0;i<10;i++){
            arr[i]=0;
        }
        while(n>0){
            arr[n%10]++;
            n=n/10;
        }
        int max=0;
        arr[6]=(arr[6]+arr[9]+1)/2;
        for(int i=0;i<9;i++){
            if(arr[i]>max)
                max=arr[i];
        }
        System.out.println(max);
    }
}
