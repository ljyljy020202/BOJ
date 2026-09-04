class Solution {
    public int solution(int[] numbers, int target) {
        int cnt = 0;
        cnt += dfs(numbers, target, 0, 0, 1);
        cnt += dfs(numbers, target, 0, 0, -1);
        
        return cnt;
    }
    int dfs(int[] numbers, int target, int idx, int sum, int sign){
        int cnt = 0;
        sum += sign*numbers[idx];
        if(idx == numbers.length-1){
            if(sum == target)
                return 1;
            else
                return 0;
        }
        cnt += dfs(numbers, target, idx+1, sum, 1);
        cnt += dfs(numbers, target, idx+1, sum, -1);
        return cnt;
    }
}