class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int n = diffs.length;
        int maxLevel = 0;
        for(int diff: diffs)
            maxLevel = Math.max(maxLevel, diff);
        
        int left = 1;
        int right = maxLevel;
        int answer = maxLevel;
        
        while(left <= right){
            int level = left + (right - left)/2;
            long time = 0;
            for(int i=0; i<n; i++){
                int fail = diffs[i] - level;
                if(fail>0){
                    time += (times[i-1]+times[i])*fail;
                }
                time += times[i];
            }
            if(time <= limit){
                answer = level;
                right = level - 1;
            }else{
                left = level + 1;
            }
        }
        
        return answer;
    }
}