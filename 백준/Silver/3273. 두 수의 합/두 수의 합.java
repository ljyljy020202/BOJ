import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String s = bf.readLine();
        int x = Integer.parseInt(bf.readLine());
        int cnt=0;

        StringTokenizer st = new StringTokenizer(s);
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int i=0;
        int j=n-1;

        while(i<j){
            if(arr[i]+arr[j]==x){
                cnt++;
                i++;
                j--;
            }else if(arr[j]<x-arr[i]){
                i++;
            }else{
                j--;
            }
        }
        System.out.println(cnt);
    }
}