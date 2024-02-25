import java.util.*;
class PGMRS_붕대감기 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int ind = 0, aInd = 0;
        int answer = -1;
        final int max = health;
        int check = 0;  // 공격당했는지
        while(health > 0){
            if (ind == attacks[aInd][0]){      // 공격당함
                health -= attacks[aInd][1];
                check = 0;
                aInd ++;
            }else{
                if((health + bandage[1]) > max){
                    check += 1;
                    health = max;
                }else{
                    health += bandage[1];
                    check += 1;
                }
            }

            if(ind > 0 && check == bandage[0]){  // 붕대감기 성공
                health += bandage[2];
                if(health > max) health = max;
                check = 0;
            }
            ind ++;
            if(health <= 0){
                break;
            }
            if(ind > attacks[attacks.length-1][0]){
                answer = health;
                break;
            }
        }
        return answer;
    }
}
