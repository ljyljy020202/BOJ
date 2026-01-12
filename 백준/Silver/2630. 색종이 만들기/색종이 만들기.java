import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i=0;i<n;i++){
            String input = br.readLine();
            String[] tmp = input.split(" ");
            for(int j=0;j<n;j++)
                arr[i][j] = Integer.parseInt(tmp[j]);
        }

        cut(0,0,n);
        System.out.println(white);
        System.out.println(blue);
    }
    static void cut(int row, int col, int n){
        int result = testSame(row, col, n);
        if(result==0){
            white++;
        }else if(result==1){
            blue++;
        }else{
            n = n/2;
            cut(row, col, n);
            cut(row,col+n, n);
            cut(row+n, col, n);
            cut(row+n, col+n, n);
        }
    }
    static int testSame(int startRow, int startCol, int n){
        int color = arr[startRow][startCol];
        for(int i=startRow; i<startRow+n; i++){
            for(int j=startCol; j<startCol+n; j++){
                if(arr[i][j]!=color)
                    return -1;
            }
        }
        return color;
    }
}