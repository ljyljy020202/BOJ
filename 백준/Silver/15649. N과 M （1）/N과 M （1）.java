import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] list;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        n = scan.nextInt();
        m = scan.nextInt();
        visited = new boolean[n+1];
        list = new int[m];
        backTracking(0);
        System.out.println(sb);
    }
    static void backTracking(int cnt){
        if(cnt == m){   // 재귀함수를 마치는 조건
            for(int i=0;i<m;i++)
                sb.append(list[i]+" ");
            sb.append("\n");
            return;
        }

        for(int i=1;i<=n;i++){
            if(!visited[i]){
                visited[i] = true;
                list[cnt] = i;
                backTracking(cnt+1);    // 자식 노드 방문
                visited[i] = false; // 자식 노드 방문 후 부모 노드의 방문 기록 다시 지우기
            }
        }
    }
}
