import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for(int i=0;i<n;i++){
            String[] input = br.readLine().split("");
            for(int j=0;j<n;j++){
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }
        String result = recursion(n, 0, 0);
        System.out.println(result);
    }
    static String recursion(int n, int startX, int startY){
        if(n==1 || checkAllSame(n, startX, startY)){
            return String.valueOf(graph[startY][startX]);
        }

        String leftUp = recursion(n/2, startX, startY);
        String rightUp = recursion(n/2, startX+n/2, startY);
        String leftDown = recursion(n/2, startX, startY+n/2);
        String rightDown = recursion(n/2, startX+n/2, startY+n/2);

        return "("+leftUp+rightUp+leftDown+rightDown+")";
    }
    static boolean checkAllSame(int n, int startX, int startY){
        int num = graph[startY][startX];
        for(int i=startY;i<startY+n;i++){
            for(int j=startX;j<startX+n;j++){
                if(num!=graph[i][j])
                    return false;
            }
        }
        return true;
    }
}