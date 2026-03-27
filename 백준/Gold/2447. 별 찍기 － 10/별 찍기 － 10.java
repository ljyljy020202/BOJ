import java.io.IOException;
import java.util.Scanner;

public class Main {
    static boolean[][] graph;
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        graph = new boolean[n][n];
        
        recursion(n,0,0);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(graph[i][j])
                    sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void recursion(int n, int startX, int startY){
        if(n==3){
            for(int i=startY;i<startY+3;i++){
                for(int j=startX;j<startX+3;j++){
                    if(!(i==startY+1 && j==startX+1))
                        graph[i][j] = true;
                }
            }
        }else{
            for(int i=startY;i<startY+n;i+=n/3){
                for(int j=startX;j<startX+n;j+=n/3){
                    if(!(i==startY+n/3 && j==startX+n/3))
                        recursion(n/3, j, i);
                }
            }
        }
    }
}