import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] input = new String[n][];
        int[][] result = new int[n][n];
        for(int i=0;i<n;i++){
            input[i] = br.readLine().split(" ");
        }

        result[0][0] = Integer.parseInt(input[0][0]);
        int colsize = 1;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<colsize;j++){
                int left = Integer.parseInt(input[i+1][j])+result[i][j];
                int right = Integer.parseInt(input[i+1][j+1])+result[i][j];

                if(result[i+1][j]<left) result[i+1][j]=left;
                if(result[i+1][j+1]<right) result[i+1][j+1]=right;
            }
            colsize++;
        }

        int max=0;
        for(int i=0;i<colsize;i++){
            if(result[n-1][i]>max) max=result[n-1][i];
        }
        System.out.println(max);
    }
}
