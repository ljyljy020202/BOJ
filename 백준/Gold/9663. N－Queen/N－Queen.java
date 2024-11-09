import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static boolean[] visitedCol;
    static int[] path;
    static int n;
    static int cnt;
    public static void main(String[] args) throws IOException {
        n = scan.nextInt();
        visitedCol = new boolean[n];
        path = new int[n];
        cnt=0;
        dfs(0);
        System.out.println(cnt);
    }
    static void dfs(int row){
        // 백트래킹 조건 - 대각선
        if(row>1){
            int curCol = path[row-1];
            int distance = 0;
            for(int i=row-2;i>=0;i--){
                distance++;
                if(path[i]-distance>=0 && path[i]-distance == curCol)
                    return;
                else if(path[i]+distance<n && path[i]+distance == curCol)
                    return;
            }
        }
        // 종료 조건 - 모든 row를 방문한 경우
        if(row==n){
            cnt++;
            return;
        }
        // 방문하지 않은 column을 방문
        for(int i=0;i<n;i++){
            if(!visitedCol[i]){
                visitedCol[i]=true;
                path[row]=i;
                dfs(row+1);
                visitedCol[i]=false;
            }
        }

    }
}
