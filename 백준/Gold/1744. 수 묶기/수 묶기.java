import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        //  수열의 크기가 1인 경우
        if(list.size()==1){
            System.out.println(list.get(0));
            return;
        }
        //  수열의 크기가 2이상인 경우
        int sum=0;
        int i=0;
        while(i<n){
            if(list.get(i)<0){          // 음수인 경우
                if(i<n-1 && list.get(i+1)<1){
                    sum += list.get(i)* list.get(i+1);
                    i=i+2;
                }else{
                    sum += list.get(i);
                    i++;
                }
            }else if(list.get(i)<2){    // 0 또는 1인 경우
                sum += list.get(i);
                i++;
            }else{                      // 2 이상의 양수인 경우
                if((list.size()-i)%2==1){
                    sum += list.get(i);
                    i++;
                }else{
                    sum += list.get(i)* list.get(i+1);
                    i=i+2;
                }
            }
        }
        System.out.println(sum);
    }
}
