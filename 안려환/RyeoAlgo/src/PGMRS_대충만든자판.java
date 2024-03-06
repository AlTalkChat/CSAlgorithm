import java.util.*;
public class PGMRS_대충만든자판 {
    public static void main(String[] args) {
//        String [] arr = {"ABACD","BCEFD"};
//        String [] inp = {"ABCD","AABB"};
        String [] keymap = {"AGZ","BSSS"};
        String [] targets = {"ASA","BGZ"};
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
        for (int i = 0; i < targets.length; i++) {
            temp = 0;
            for(int j = 0; j < targets[i].length(); j++){
                if(map.containsKey(targets[i].charAt(j))){
                    temp += map.get(targets[i].charAt(j));
                }
            }
            if(temp <= 0){
                answer[i] = -1;
            }else {
                answer[i] = temp;
            }
        }
        for(int a : answer){
            System.out.println(a);
        }
    }
}