import java.util.*;
class PGMRS_대충만든자판 {
    public int[] solution(String[] keymap, String[] targets) {
        int [] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                if(map.containsKey(keymap[i].charAt(j))){
                    if(map.get(keymap[i].charAt(j)) > j+1){
                        map.put(keymap[i].charAt(j),j+1);
                    }
                }else {
                    map.put(keymap[i].charAt(j),j+1);
                }
            }
        }
        int temp;
        boolean check;
        for (int i = 0; i < targets.length; i++) {
            temp = 0;
            check = false;
            for(int j = 0; j < targets[i].length(); j++){
                if(map.containsKey(targets[i].charAt(j))){
                    temp += map.get(targets[i].charAt(j));
                }else{
                    check = true;
                }
            }
            if(temp <= 0 || check){
                answer[i] = -1;
            }else {
                answer[i] = temp;
            }
        }
        return answer;
    }
}