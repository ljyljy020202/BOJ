import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] tmp = br.readLine().split(" ");
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(tmp[i]);
            }
            long profit = 0;
            int max = arr[n-1];
            for(int i=n-1;i>=0;i--){
                if(arr[i]<max){
                    profit += max-arr[i];
                }else{
                    max = arr[i];
                }
            }
            sb.append(profit+"\n");
        }
        System.out.println(sb);
    }
}