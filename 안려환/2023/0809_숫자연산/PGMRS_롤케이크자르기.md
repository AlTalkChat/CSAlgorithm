# 후기
끝내 못풀어서 팀원분들이 정답을 알려주신걸 듣고 풀었다. <br>
새로 생각해내기는 못하니까 차라리 시간을 정하고 많이 풀어서 이런 지식들을 많이 쌓는 쪽으로 공부를 해야겠다.<br>
이번에 새로 배운건 HashMap 의 getOrDefault 메소드이다. 있으면 그 value를 가져오고 아니면 default 값을 줄 수 있다. 

# 링크
https://school.programmers.co.kr/learn/courses/30/lessons/132265

# 코드
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PGMRS_롤케이크자르기 {
    // 동일하게 잘라야 한다. -> 동일한 수로 나눠야 한다. (철수와 동생 둘 뿐이니까 둘로만 나누면 된다.)
    // 조합으로 나눠가며 각 종류가 몇 개인지 판단해서 같은 종류만 카운트해서 풀이한다.
    // 1, 2, 1, 3, 1, 4, 1, 2 -> 2
    // 1, 2, 3, 1, 4 -> 0

    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < topping.length; i++) {
            map.put(topping[i], map.getOrDefault(topping[i], 0)+1);
        }
        Set<Integer> bro = new HashSet<>();
        for (int i = 0; i < topping.length; i++) {
            bro.add(topping[i]);
            if(map.get(topping[i])==1){
                map.remove(topping[i]);
            }else {
                map.put(topping[i],map.get(topping[i])-1);
            }
            if(bro.size() == map.size()){
                count += 1;
            } else if (bro.size() > map.size()) {
                break;
            }
        }
        System.out.println(count);
    }
}
