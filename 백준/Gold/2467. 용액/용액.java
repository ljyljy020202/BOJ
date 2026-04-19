import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }
        Arrays.sort(arr);

        int left = 0;
        int right = n-1;

        int min = Integer.MAX_VALUE;
        int a = arr[left];
        int b = arr[right];

        while(left < right){
            int sum = arr[left] + arr[right];
            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                a = arr[left];
                b = arr[right];
            }
            if(sum>0)
                right--;
            else if(sum<0)
                left++;
            else break;
        }

        System.out.println(a+" "+b);
    }
}