import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        int cnt = 0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='c'){
                if(i<input.length()-1 && (input.charAt(i+1)=='=' || input.charAt(i+1)=='-'))
                    i++;
            }else if(input.charAt(i)=='d'){
                if(i<input.length()-1 && input.charAt(i+1)=='-')
                    i++;
                else if(i<input.length()-2 && input.charAt(i+1)=='z' && input.charAt(i+2)=='=')
                    i+=2;
            }else if(input.charAt(i)=='l' || input.charAt(i)=='n'){
                if(i<input.length()-1 && input.charAt(i+1)=='j')
                    i++;
            }else if(input.charAt(i)=='s' || input.charAt(i)=='z'){
                if(i<input.length()-1 && input.charAt(i+1)=='=')
                    i++;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}