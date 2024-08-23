import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        int[] alphabet = new int[26];
        Scanner scan = new Scanner(System.in);
        int count=0;
        
        int n = scan.nextInt();
        for(int i=0;i<n;i++){
            boolean grpWord = true;
            char prev = 0;
            for(int j=0;j<26;j++){
            alphabet[j]=0;
            }
            String str = scan.next();
            for(int j=0;j<str.length();j++){
                char ch = str.charAt(j);
                if(prev != ch){
                    if(alphabet[ch-'a']==1){
                        grpWord = false;
                        break;
                    }else{
                        alphabet[ch-'a']=1;
                        prev=ch;
                    }
                }
            }
            if(grpWord)
                count++;
        }
        System.out.println(count);
    }
}