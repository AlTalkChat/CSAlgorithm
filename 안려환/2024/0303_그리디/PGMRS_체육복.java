import java.util.*;
class PGMRS_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i ++){
            map.put(i+1,1);
        }
        for(int i = 0; i < lost.length; i++){
            map.put(lost[i], 0);
        }
        for(int i = 0; i < reserve.length; i++){
            map.put(reserve[i],map.get(reserve[i]) + 1);
        }
        Arrays.sort(lost);
        int temp = 0;
        for(int i = 0; i < lost.length; i++){
            temp = lost[i];
            if(map.get(temp) < 1){
                if(map.containsKey(temp - 1) && map.get(temp - 1) > 1){
                    map.put(temp - 1 , 1);
                    map.put(temp, 1);
                }else{
                    if(map.containsKey(temp + 1) && map.get(temp + 1) > 1){
                        map.put(temp + 1, 1);
                        map.put(temp, 1);
                    }
                }
            }
        }
        for(int a:map.values()){
            if(a > 0) answer += 1;
        }
        return answer;
    }
}