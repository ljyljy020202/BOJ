import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        String[] words = message.split(" ");
        int[] word_idxs = new int[message.length()];
        
        int idx = 0;
        for(int i=0; i<message.length(); i++){
            if(message.charAt(i)==' '){
                word_idxs[i] = -1;
                idx++;
            }else
                word_idxs[i] = idx;
        }
        
        boolean[] spoilers = new boolean[words.length];
        for(int i=0; i<spoiler_ranges.length; i++){
            int start = spoiler_ranges[i][0];
            int end = spoiler_ranges[i][1];
            for(int j=start; j<=end; j++){
                int word_idx = word_idxs[j];
                if(word_idx != -1)
                    spoilers[word_idx] = true;
            }
        }
        
        int answer = 0;
        Set<String> revealed = new HashSet<>();
        for(int i=0; i<words.length; i++){
            if(!spoilers[i])
                revealed.add(words[i]);
        }
        
        for(int i=0; i<words.length; i++){
            if(spoilers[i] && !revealed.contains(words[i])){
                spoilers[i] = false;
                revealed.add(words[i]);
                System.out.println("revealed "+words[i]);
                answer++;
            }
        }
        return answer;
    }
}