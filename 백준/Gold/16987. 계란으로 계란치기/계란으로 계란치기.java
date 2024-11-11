import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static int[][] eggs;
    static int n;
    static int max=0;
    public static void main(String[] args) throws IOException {
        // 입력 받기
        n = scan.nextInt();
        eggs = new int[n][2];
        for(int i=0;i<n;i++){
            eggs[i][0]=scan.nextInt();
            eggs[i][1]=scan.nextInt();
        }

        // 재귀 호출
        dfs(0);

        //출력
        System.out.println(max);
    }
    static void dfs(int idx){
        // 종료 조건
        if(idx==n){
            int cnt=0;
            for(int i=0;i<n;i++){
                if(eggs[i][0]<=0)
                    cnt++;
            }
            if(cnt>max)
                max = cnt;
            return;
        }

        // idx번째 계란이 깨지지 않은 경우
        if(eggs[idx][0]>0){

            // 자신이 아닌 다른 모든 계란을 쳐 봄
            boolean all_broken = true;
            for(int i=0;i<n;i++){
                if(i!=idx&&eggs[i][0]>0){
                    all_broken = false;
                    eggs[i][0] -= eggs[idx][1];
                    eggs[idx][0] -= eggs[i][1];
                    dfs(idx+1);
                    eggs[i][0] += eggs[idx][1];
                    eggs[idx][0] += eggs[i][1];
                }
            }

            // 깨지지 않은 계란이 없는 경우
            if(all_broken)
                dfs(idx+1);

        }else{  // idx번째 계란이 깨진 경우
            dfs(idx+1);
        }
    }
}
