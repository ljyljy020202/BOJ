import java.io.IOException;
import java.util.Scanner;

public class Main {
    static String[][] stars;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = scan.nextInt();
        stars = new String[n][2*n-1];

        // 공백으로 초기화
        for(int i=0;i<n;i++){
            for(int j=0;j<2*n-1;j++)
                stars[i][j]=" ";
        }

        // n(줄의 개수)과 맨 위 꼭짓점의 위치 전달
        star(n,0, n-1);

        // 출력
        for(int i=0;i<n;i++){
            for(int j=0;j<2*n-1;j++)
                sb.append(stars[i][j]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void star(int n, int topY, int topX){
        if(n==3){
            stars[topY][topX]="*";
            stars[topY+1][topX-1]="*";
            stars[topY+1][topX+1]="*";
            for(int i=0;i<5;i++)
                stars[topY+2][topX-2+i]="*";
            return;
        }
        int half = n/2;
        star(half, topY, topX);
        star(half, topY+half, topX-half);
        star(half, topY+half, topX+half);
    }
}
