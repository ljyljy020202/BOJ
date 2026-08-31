class Solution {
    public int solution(int[][] signals) {
        int answer = -1;
        int[] cycles = new int[signals.length];
        
        for(int i=0; i<cycles.length; i++){
            int sum = 0;
            for(int j=0; j<3; j++)
                sum += signals[i][j];
            cycles[i] = sum;
        }
        
        int cycle_lcm = 1;
        for(int i=0; i<cycles.length; i++){
            cycle_lcm = lcm(cycle_lcm, cycles[i]);
        }
        
        char[] stats = new char[cycles.length];
        
        for(int i=1; i<=cycle_lcm; i++){
            changeStats(signals, cycles, stats, i);
            if(checkAllYellow(stats)){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    boolean checkAllYellow(char[] stats){
        for(int i=0; i<stats.length; i++){
            if(stats[i]!='Y')
                return false;
        }
        return true;
    }
    
    void changeStats(int[][] signals, int[] cycles, char[] stats, int time){
        for(int i=0; i<signals.length; i++){
            int remainder = time%cycles[i];
            if(remainder>0 && remainder<=signals[i][0])
                stats[i] = 'G';
            else if(remainder>signals[i][0] && remainder<= signals[i][0]+signals[i][1])
                stats[i] = 'Y';
            else
                stats[i] = 'R';
        }
    }
    
    int gcd(int a, int b){
        if(a<b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        while(b!=0){
            int remainder = a%b;
            a = b;
            b = remainder;
        }
        return a;
    }
    
    int lcm(int a, int b){
        return a / gcd(a, b) * b;
    }
}