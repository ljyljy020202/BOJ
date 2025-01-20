import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp[] = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int[] arr = new int[n];
        tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(tmp[i]);
        }

        int start = 0;
        int end = 0;
        int sum = arr[0];
        int cnt = 0;

        while(start<n){
            if(sum==m){
                cnt++;
                if(end>=n-1)
                    break;
                end++;
                sum += arr[end];
            }else if(sum>m){
                if(start==end){
                    if(end>=n-1)
                        break;
                    end++;
                    sum += arr[end];
                }else{
                    sum -= arr[start];
                    start++;
                }
            }else{
                if(end>=n-1)
                    break;
                end++;
                sum += arr[end];
            }
        }
        System.out.println(cnt);
    }
}