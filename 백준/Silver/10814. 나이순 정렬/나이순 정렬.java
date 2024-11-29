import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Member> members = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        while(n-->0){
            String tmp[] = br.readLine().split(" ");
            members.add(new Member(Integer.parseInt(tmp[0]),tmp[1]));
        }

        Collections.sort(members);

        for(int i=0;i<members.size();i++){
            System.out.println(members.get(i));
        }
    }
}

class Member implements Comparable<Member>{
    int age;
    String name;
    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString() {
        return age + " " + name;
    }
    @Override
    public int compareTo(Member o) {
        return this.age-o.age;
    }
}