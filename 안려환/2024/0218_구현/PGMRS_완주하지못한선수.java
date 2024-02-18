import java.util.*;
class PGMRS_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String a : participant){
            if(map.containsKey(a)){
                map.put(a,map.get(a) + 1);
            }else{
                map.put(a,1);
            }
        }

        for(String a : completion){
            if(map.containsKey(a)){
                map.put(a,map.get(a) - 1);
            }
        }

        for(String a : participant){
            if(map.get(a) != 0){
                return a;
            }
        }
        return "no";
    }
}