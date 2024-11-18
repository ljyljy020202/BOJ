import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String board[][];
        String dir[][];
        int direction;  // 방향 정보 저장 (오른쪽, 아래, 왼쪽, 위 순서대로 0,1,2,3)
        Deque<Point> snake = new ArrayDeque<>();    // 뱀의 위치 정보
        int n = scan.nextInt();
        int sec;
        boolean end;

        // 보드의 상태를 'A(사과)', 'S(뱀)', 'null(빈칸)' 중 하나로 표시
        board = new String[n+1][n+1];

        int k = scan.nextInt();
        while(k-->0){
            int row = scan.nextInt();
            int col = scan.nextInt();
            board[row][col] = "A";
        }

        int l = scan.nextInt();
        // 방향 변환 정보를 시간, 방향 순으로 저장
        dir = new String[l][2];
        for(int i=0;i<l;i++){
            dir[i][0] = scan.next();
            dir[i][1] = scan.next();
        }

        // 시작
        board[1][1] = "S";
        snake.offer(new Point(1,1));    // 뱀의 머리 위치를 덱에 넣음
        direction = 0;  // 초기 이동 방향은 오른쪽
        sec = 0;    // 시간 체크용
        end = false;

        for(int i=0;i<l;i++){
            int num = Integer.parseInt(dir[i][0]);
            while(sec<num){
                end = move(board, snake, direction);
                sec++;
                if(end){
                    System.out.println(sec);
                    return;
                }
            }
            // 방향 전환
            direction = changeDir(direction, dir[i][1]);
        }

        // 벽에 부딪힐 때까지 이동
        while(!move(board,snake,direction))
            sec++;
        System.out.println(sec+1);
    }

    static boolean move(String[][] board, Deque<Point> snake, int dir){
        Point head = snake.peekLast();
        Point target;
        switch(dir){
            case 0: target = new Point(head.x+1,head.y); break;
            case 1: target = new Point(head.x,head.y+1); break;
            case 2: target = new Point(head.x-1,head.y); break;
            case 3: target = new Point(head.x,head.y-1); break;
            default: target = head;
        }

        // 벽에 부딪힌 경우
        if(target.x<1 || target.x>board.length-1 || target.y<1 || target.y>board.length-1){
            return true;
        }

        String newHead = board[target.y][target.x];
        if(newHead==null){  // 아무것도 없는 경우
            snake.offer(target);
            board[target.y][target.x] = "S";
            Point tail = snake.poll();
            board[tail.y][tail.x] = null;
        }else if(newHead.equals("S")){    // 자기 자신과 부딪힌 경우
            return true;
        }else if(newHead.equals("A")){  // 사과를 만난 경우
            snake.offer(target);
            board[target.y][target.x] = "S";
        }
        return false;
    }

    private static int changeDir(int curDir, String change) {
        if(change.equals("L"))
            return (curDir+3)%4;
        else
            return (curDir+1)%4;
    }

}
