import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = scan.nextInt();
        while(T-->0){
            int n = scan.nextInt();
            int m = scan.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            boolean[] visited = new boolean[n+1];
            for(int i=0;i<=n;i++)
                graph.add(new ArrayList<Integer>());
            while(m-->0){
                int a = scan.nextInt();
                int b = scan.nextInt();
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            sb.append(n-1+"\n");
        }

        System.out.println(sb);
    }
}