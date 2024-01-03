# 후기
자료구조를 공부해야겠다는 생각이 강하게 들었다. <br>
hashmap을 쓸줄을 몰라서 틀렸었다.  <br>
그리고 문제를 제대로 읽어야 겠다. 

# 링크
https://school.programmers.co.kr/learn/courses/30/lessons/138476

# 코드
```
import java.util.*;

public class PGMRS_귤고르기 {
    /**
     * 귤을 크기별로 분류했을 때 서로 다른 종류의 수글 최소화
     * 1 3 2 5 4 5 2 3 이라는 배열이 주어졌을 때 1 4 제외하면 종류가 2,3,5가 되면서 서로 다른 종류가 최소가 된다.
     *
     **/
    public static void main(String[] args) {
        int k = 6;
        Integer [] tangerine = {1,3,2,5,4,5,2,3};
//        int [] tangerine = {1, 1, 1, 1, 2, 2, 2, 3};
        Integer [] tan = new Integer[tangerine.length];
        for (int i = 0; i < tangerine.length; i++) {
            tan[i] = (Integer)tangerine[i];
        }
        tangerine_find tangerine_find = new tangerine_find();
        System.out.println(tangerine_find.find(tan,k,0)+1);
    }
}
class tangerine_find{
    public int result = Integer.MAX_VALUE;


    public int find(Integer [] tangerine , int k,int count){
        tangerine = comperator(tangerine);
        int index = 0;
        for (int i = 0; i < tangerine.length; i++) {
            count += tangerine[i];
            if(count>=k){
                return i;
            }
        }
        return -1;
    }
    public Integer[]  comperator(Integer [] tangerine){
        // 중복된 수가 많은 것부터 앞에 세워야 함
        int count = 1;
        HashMap<Integer,Integer> map = new HashMap<>();
        int curr = 0;
        for (int i = 0; i < tangerine.length; i++) {
            if(map.containsKey(tangerine[i])) {
                map.put(tangerine[i], map.get(tangerine[i]) + 1);
            } else {
                map.put(tangerine[i], 1);
            }
        }
        Integer [] tan = new Integer[map.size()];
        Arrays.sort(map.values().toArray(tan),Comparator.reverseOrder());

        return tan;
    }
}
```