class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int lastAttack = attacks[attacks.length-1][0];
        int bandageCnt = 0;
        int attackIdx = 0;
        
        for(int i=1; i<=lastAttack; i++){
            if(i==attacks[attackIdx][0]){
                health -= attacks[attackIdx][1];
                if(health<=0)
                    break;
                attackIdx++;
                bandageCnt = 0;
            }else{
                health += bandage[1];
                bandageCnt++;
                if(bandageCnt==bandage[0]){
                    health += bandage[2];
                    bandageCnt = 0;
                }
                if(health>maxHealth)
                    health = maxHealth;
            }
        }
        
        if(health<=0)
            return -1;
        else
            return health;
    }
}