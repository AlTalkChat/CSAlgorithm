import java.util.*;
class PGMRS_할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> resultMap = new HashMap<>();
        for(int i = 0; i < want.length; i ++){
            wantMap.put(want[i],number[i]);
        }
        for(int i = 0; i < 10; i ++){
            resultMap.put(discount[i],resultMap.getOrDefault(discount[i],0) + 1);
        }
        if(checker(wantMap, resultMap)) answer += 1;
        int start = 0;
        int end = 9;

        for(int i = 1; i < discount.length - 9; i ++){
            if(resultMap.get(discount[start]) - 1 <= 0){
                resultMap.remove(discount[start]);
            } else {
                resultMap.put(discount[start],resultMap.get(discount[start])- 1);
            }
            start += 1;
            end += 1;
            resultMap.put(discount[end],resultMap.getOrDefault(discount[end],0) + 1);
            if(checker(wantMap,resultMap)){
                answer += 1;
            }
        }
        return answer;
    }

    public boolean checker(Map<String,Integer> wantMap, Map<String,Integer> resultMap){
        if(wantMap.keySet().size() != resultMap.keySet().size()) {
            return false;
        }
        for(String a : wantMap.keySet()){
            if(wantMap.get(a) != resultMap.getOrDefault(a,-1)){
                return false;
            }
        }
        return true;
    }
}