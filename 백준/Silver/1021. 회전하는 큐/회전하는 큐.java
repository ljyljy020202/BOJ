import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int num[] = new int[m];
        for(int i=0;i<m;i++){
            num[i]=scan.nextInt();
        }
        Deque<Integer> deque = new ArrayDeque<>();

        // 덱에 1부터 n까지의 정수를 순서대로 삽입
        for(int i=1;i<=n;i++){
            deque.offer(i);
        }

        int cnt=0;
        // 뽑아내려고 하는 각각의 수에 대해서 반복
        for(int i=0;i<m;i++){
            int pick = num[i];
            int left=0;
            int right=0;

            // pick이 맨 앞에 올 때까지 왼쪽으로 회전
            while(deque.peek()!=pick){
                moveLeft(deque,1);
                left++;
            }
            // 되돌리기
            moveRight(deque,left);

            // pick이 맨 앞에 올 때까지 오른쪽으로 회전
            while(deque.peek()!=pick){
                moveRight(deque,1);
                right++;
            }

            // pick을 뽑아내고 left와 right 중 작은 값을 cnt에 더하기
            if(right<=left){
                deque.poll();
                cnt += right;
            }else{
                moveLeft(deque,left+right);
                deque.poll();
                cnt += left;
            }
        }

        System.out.println(cnt);
    }

    static void moveLeft(Deque<Integer> dq, int k){
        for(int i=0;i<k;i++){
            dq.offer(dq.poll());
        }
    }

    static void moveRight(Deque<Integer> dq, int k){
        for(int i=0;i<k;i++){
            dq.offerFirst(dq.pollLast());
        }
    }
}
