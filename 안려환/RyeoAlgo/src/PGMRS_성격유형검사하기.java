import java.util.*;
class PGMRS_성격유형검사하기 {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        char first, second;
        int firV = 0 , secV = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);
        for(int i = 0; i < survey.length; i ++){
            // 좌측에 있는 문자에 따라서
            first = survey[i].charAt(0);
            second = survey[i].charAt(1);
            if(choices[i] / 4 > 0){  // second 에 더해줘야 한다.
                secV = map.get(second);
                secV += choices[i] % 4;
                map.put(second,secV);
            }else {  // first에 더해줘야 한다.
                firV = map.get(first);
                switch(choices[i] % 4){
                    case 1:
                        firV += 3;
                        break;
                    case 2:
                        firV += 2;
                        break;
                    case 3:
                        firV += 1;
                        break;
                }
                map.put(first,firV);
            }
        }

        if(map.get('R') > map.get('T')){
            answer.append('R');
        }else if (map.get('R') == map.get('T')){
            answer.append('R');
        }else{
            answer.append('T');
        }

        if(map.get('C') > map.get('F')){
            answer.append('C');
        }else if (map.get('C') == map.get('F')){
            answer.append('C');
        }else{
            answer.append('F');
        }

        if(map.get('J') > map.get('M')){
            answer.append('J');
        }else if (map.get('J') == map.get('M')){
            answer.append('J');
        }else{
            answer.append('M');
        }

        if(map.get('A') > map.get('N')){
            answer.append('A');
        }else if (map.get('A') == map.get('N')){
            answer.append('A');
        }else{
            answer.append('N');
        }

        return answer.toString();
    }
}