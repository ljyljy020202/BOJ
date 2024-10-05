import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        int arr[] = new int[21];

        while(m-->0){
            String str = br.readLine();
            String[] strArr = str.split(" ");

            if(strArr[0].equals("add")){
                arr[Integer.parseInt(strArr[1])] = 1;
            }else if(strArr[0].equals("remove")){
                arr[Integer.parseInt(strArr[1])] = 0;
            }else if(strArr[0].equals("check")){
                sb.append(arr[Integer.parseInt(strArr[1])]+"\n");
            }else if(strArr[0].equals("toggle")){
                if(arr[Integer.parseInt(strArr[1])]==1)
                    arr[Integer.parseInt(strArr[1])]=0;
                else
                    arr[Integer.parseInt(strArr[1])]=1;
            }else if(strArr[0].equals("all")){
                for(int i=1;i<21;i++)
                    arr[i]=1;
            }else{  //empty
                for(int i=1;i<21;i++)
                    arr[i]=0;
            }
        }
        System.out.println(sb);
    }
}
