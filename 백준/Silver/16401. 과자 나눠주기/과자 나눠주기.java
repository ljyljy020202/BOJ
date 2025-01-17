import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int m = Integer.parseInt(tmp[0]);
        int n = Integer.parseInt(tmp[1]);
        tmp = br.readLine().split(" ");

        int[] arr = new int[n];
        int max = 0;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(tmp[i]);
            if(arr[i]>max)
                max = arr[i];
        }

        int low = 1;
        int high = max;
        int result = 0;
        while(low<=high){
            int mid = (low+high)/2;
            int cnt = 0;
            for(int i=0;i<n;i++){
                cnt += arr[i]/mid;
            }
            if(cnt>=m){
                result = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        System.out.println(result);
    }
}
