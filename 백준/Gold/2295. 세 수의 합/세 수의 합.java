import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(br.readLine());

        ArrayList<Integer> sum = new ArrayList<>();
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                sum.add(arr[i]+arr[j]);

        Arrays.sort(arr);
        Collections.sort(sum);

        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int diff = arr[i]-arr[j];
                if(Collections.binarySearch(sum,diff)>=0){
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }

}