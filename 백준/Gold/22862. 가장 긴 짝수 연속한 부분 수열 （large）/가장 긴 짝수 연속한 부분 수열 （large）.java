import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);
        int[] arr = new int[n];
        tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(tmp[i]);

        int start = 0;
        int end = 0;
        int del = 0;
        int len = 1;
        int max = 0;

        //  처음 짝수가 나오는 위치까지 start 이동
        while(start<n && arr[start]%2==1)
            start++;

        //  짝수가 없는 경우
        if(start==n){
            System.out.println(0);
            return;
        }

        end = start+1;
        //  배열의 끝까지 반복
        while(start<n){
            while(del<=k && end<n){
                if(arr[end]%2==1)
                    del++;
                else
                    len++;
                end++;
            }
            if(len>max)
                max = len;
            if(end==n)
                break;

            int prev = start++;
            while(start<n && arr[start]%2==1)
                start++;
            len--;
            del -= start-prev-1;
        }
        System.out.println(max);
    }
}