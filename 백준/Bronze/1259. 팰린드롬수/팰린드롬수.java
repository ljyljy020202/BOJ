import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        while(!input.equals("0")){
            int len = input.length();
            boolean pal = true;
            for(int i=0;i<len/2;i++){
                if(input.charAt(i)!=input.charAt(len-1-i)){
                    pal = false;
                    break;
                }
            }
            if(pal)
                sb.append("yes\n");
            else
                sb.append("no\n");

            input = br.readLine();
        }

        System.out.println(sb);
    }
}