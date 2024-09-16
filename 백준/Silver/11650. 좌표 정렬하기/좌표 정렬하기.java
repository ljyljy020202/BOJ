import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();

        for(int i=0;i<n;i++){
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            Point point = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            points.add(point);
        }

        Collections.sort(points);

        for(int i=0;i<n;i++){
            System.out.println(points.get(i).toString());
        }

    }
}

class Point implements Comparable<Point>{
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    int x;
    int y;
    
    @Override
    public int compareTo(Point o) {
        if(this.x==o.x)
            return this.y-o.y;
        else
            return this.x-o.x;
    }
    @Override
    public String toString() {
        return  x + " " + y;
    }
}