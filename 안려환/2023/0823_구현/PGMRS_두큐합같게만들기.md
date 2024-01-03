# 후기
막무가내로 완탐은 역시 안좋은 것 같다. <br>
그래도 푸는데는 성공했는데 이제 로직을 생각해내는 단계까지는 왔다.<br>
Arrays.stream() 에 대해 알게 되었다. 그냥 for 문 활용하는게 빠르고 long 으로 쓰려면  long aSum = Arrays.stream(queue1).asLongStream().sum(); 아렇게 써줘야 맞게 나온다.

# 결과
1. Arrays.stream 사용한 결과
<img width="274" alt="image" src="https://github.com/Ryeohwan/TRL/assets/73810834/5d7bff8f-b21f-4582-89b5-4c7dbb73b629">

2. for 문을 사용한 결과
<img width="285" alt="image" src="https://github.com/Ryeohwan/TRL/assets/73810834/1c2e4887-977f-4e34-8c52-818811763bb5">

# 링크
https://school.programmers.co.kr/learn/courses/30/lessons/118667#qna

# 코드
```
import java.util.*;
class Solution {
    private static int result = 0;
    public int solution(int[] queue1, int[] queue2) {
        long aSum = 0, bsum = 0, aMax = 0, bMax = 0;
        for (int i = 0; i < queue1.length; i++) {
            aSum += queue1[i];
            aMax = Math.max(aMax , queue1[i]);
            bsum += queue2[i];
            bMax = Math.max(bMax,queue2[i]);
        }

        long TSum =aSum + bsum;
        long half = TSum/2;
        // long aMax = 0, bMax = 0;
        // for (int i = 0; i < queue1.length; i++) {
        //     aMax = Math.max(aMax , queue1[i]);
        //     bMax = Math.max(bMax,queue2[i]);
        // }
        // long aSum = Arrays.stream(queue1).asLongStream().sum();
        // long bSum = Arrays.stream(queue2).asLongStream().sum();
        // long TSum =aSum + bSum;
        // long half = TSum/2;
        if(half < aMax || half < bMax || TSum %2 != 0){
            return -1;
        }  // 애시당초 안되는 애들은 제외
        Deque<Integer> list1 = new LinkedList<>();
        Deque<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < queue1.length; i++) {
            list1.add(queue1[i]);
            list2.add(queue2[i]);
        }
        dfs(list1,list2,half);
        return result;
    }
    private static void dfs(Deque<Integer> list1, Deque<Integer> list2, long half) {
        // 차피 한 쪽만 맞춰지면 나머지는 신경안써도 된다.
        long listSum = 0;
        for (int a : list1) {
            listSum += a;
        }
        int temp = 0;

        while (list2.size() > 0) {
            if (listSum > half) {
                temp = list1.poll();
                listSum -= temp;
                result += 1;
            } else if (listSum == half) {
                return;
            } else {
                temp = list2.poll();
                listSum += temp;
                list1.add(temp);
                result += 1;
            }
        }
        result = -1;
    }
}
```