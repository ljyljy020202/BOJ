import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    static String[][] grid;
    static String[] strarr;
    static int[][] vector = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public static void main(String[] args) throws IOException{
        Map<String,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        //  입력 받기
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        int k = Integer.parseInt(tmp[2]);
        grid = new String[n][];
        strarr = new String[k];
        for(int i=0;i<n;i++)
            grid[i] = br.readLine().split("");
        for(int i=0;i<k;i++)
            strarr[i] = br.readLine();

        //  k개의 문자열 각각에 대해 반복
        for(int i=0;i<k;i++){
            String cur = strarr[i];
            //  map에 문자열이 저장되지 않은 경우
            if(!map.containsKey(cur)){
                int cnt = 0;
                //  grid의 모든 칸과 문자열의 첫 번째 글자를 비교하고
                //  같으면 dfs를 호출하여 그 결과 값을 cnt에 더함
                for(int a=0;a<n;a++){
                    for(int b=0;b<m;b++){
                        if(cur.charAt(0)==grid[a][b].charAt(0)){
                            cnt += dfs(a,b,cur,1);
                        }
                    }
                }
                map.put(cur,cnt);
            }
            //  문자열을 만들 수 있는 경우의 수를 sb에 append
            sb.append(map.get(cur)+"\n");
        }

        //  출력
        System.out.println(sb);
    }

    static int dfs(int a,int b, String cur, int idx){
        //  재귀 종료 조건
        if(cur.length()==idx){
            return 1;
        }

        //  다음으로 갈 수 있는 칸들을 확인하여 문자열의 idx번째 글자와 같으면 dfs를 호출
        //  cnt에 다음으로 갈 수 있는 칸들에서 문자열을 만들 수 있는 경우의 수를 모두 더한 뒤 리턴
        int cnt=0;
        for(int i=0;i<8;i++){
            int row = (a+vector[i][0]+n)%n;
            int col = (b+vector[i][1]+m)%m;
            if(grid[row][col].charAt(0)==cur.charAt(idx))
                cnt += dfs(row,col,cur,idx+1);
        }
        return cnt;
    }
}