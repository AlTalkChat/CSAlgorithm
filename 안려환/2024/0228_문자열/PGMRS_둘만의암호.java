import java.util.*;
class PGMRS_둘만의암호 {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        //char a = 'b';
        //int b = a - 1;
        //char c = (char)b;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < skip.length(); i++){
            map.put(skip.charAt(i),skip.charAt(i) - 0);
}
        int temp;
        char tempChar;
        for(int i=0; i<s.length(); i++){
            temp = s.charAt(i);
            for(int j = 0; j < index; j++){
                temp += 1;
                while((char)temp > 'z'){
                    temp -= 26;
        }
                if(map.containsKey((char)temp)){
                    j -= 1;
                    continue;
                }
            }
            answer.append((char)temp + "");
            
}
        
        return answer.toString();
    }
}