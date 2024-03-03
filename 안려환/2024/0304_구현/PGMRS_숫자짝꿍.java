import java.util.*;
class PGMRS_숫자짝꿍 {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < X.length(); i ++){
            if(map.containsKey(X.charAt(i))){
                map.put(X.charAt(i),map.get(X.charAt(i)) + 1);
            }else {
                map.put(X.charAt(i),1);   
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < Y.length(); i ++){
            if(map.containsKey(Y.charAt(i)) && map.get(Y.charAt(i)) > 0){
                map.put(Y.charAt(i),map.get(Y.charAt(i)) - 1);
                list.add(Y.charAt(i) - 48);
            }
        }
        Collections.sort(list);
        boolean check = false;
        for(int i = list.size() - 1; i >= 0; i --){
            if(list.get(i) != 0) check = true;
            answer.append(list.get(i) + "");
        }
        if(answer.length() == 0){
            check = true;
            answer.append(-1);
        }
        if(!check) return "0";
        return answer.toString();
    }
}