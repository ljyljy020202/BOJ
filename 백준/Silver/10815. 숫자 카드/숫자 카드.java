import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(tmp[i]);
        }
        int m = Integer.parseInt(br.readLine());
        String[] search = br.readLine().split(" ");

        Arrays.sort(arr);
        for(int i=0;i<m;i++){
            int num = Integer.parseInt(search[i]);
            int low=0;
            int high=n-1;
            boolean find = false;
            while(low<=high){
                int mid = (low+high)/2;
                if(num<arr[mid]){
                    high=mid-1;
                }else if(num>arr[mid]){
                    low=mid+1;
                }else{
                    find = true;
                    break;
                }
            }
            if(find)
                sb.append(1+" ");
            else
                sb.append(0+" ");
        }
        System.out.println(sb);
    }
}