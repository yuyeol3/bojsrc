class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int t = 0;
        int healInARow = 0;
        
        int atkIdx = 0;
        while (true) {
            t++;
            if (attacks[atkIdx][0] == t) {
                health -= attacks[atkIdx][1];
                if (health <= 0) break;
                
                healInARow = 0;
                if (++atkIdx == attacks.length) break;
                continue;
            }
                
            health = Math.min(maxHealth, health+bandage[1]);
            healInARow++;
            if (healInARow == bandage[0]) {
                healInARow = 0;
                health = Math.min(maxHealth, health + bandage[2]);
            }
            
        }
        
        return health <= 0 ? -1 : health;
    }
}