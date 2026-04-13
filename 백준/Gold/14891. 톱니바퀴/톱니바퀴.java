import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] wheels;
    static int[] startPoint;
    static int[] rotations;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        wheels = new int[4][8];
        startPoint = new int[4];

        for(int i=0;i<4;i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < 8; j++)
                wheels[i][j] = Integer.parseInt(tmp[j]);
        }
        int k = Integer.parseInt(br.readLine());

        while(k-->0){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken())-1;
            int direction = Integer.parseInt(st.nextToken());
            rotate(num, direction);
        }

        System.out.println(getScore());
    }

    static void rotate(int num, int direction){
        rotations = new int[4];
        rotations[num] = direction;

        rotateLeft(num);
        rotateRight(num);

        for(int i=0;i<4;i++)
            startPoint[i] = (startPoint[i]-rotations[i]+8) % 8;
    }
    static void rotateLeft(int num){
        if(num==0)
            return;

        int curIdx = (startPoint[num]+6) % 8;
        int nextIdx = (startPoint[num-1]+2) % 8;

        if(wheels[num][curIdx] != wheels[num-1][nextIdx]){
            rotations[num-1] = -1*rotations[num];
            rotateLeft(num-1);
        }
    }
    static void rotateRight(int num){
        if(num==3)
            return;

        int curIdx = (startPoint[num]+2) % 8;
        int nextIdx = (startPoint[num+1]+6) % 8;

        if(wheels[num][curIdx] != wheels[num+1][nextIdx]){
            rotations[num+1] = -1*rotations[num];
            rotateRight(num+1);
        }
    }

    static int getScore(){
        int score = 0;
        for(int i=0;i<4;i++){
            if(wheels[i][startPoint[i]]==1)
                score += Math.pow(2,i);
        }
        return score;
    }
}