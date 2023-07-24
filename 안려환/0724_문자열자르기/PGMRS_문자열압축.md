# 후기
뽀모도로 공부법을 처음으로 활용해보았다. <br>
정말 신기하게도 먹혔다. <br>
근데 큰 문제는 이거 이틀에 거쳐서 풀었는데 첫 날에 문제를 단단히 잘못이해했다는 것이다. <br>
그런 말이 있다. 상한 재료로는 1류 요리사를 불러도 상한 요리밖에 만들지 못한다는 것을... <br>
하여간 여기서 배운건 String 관련 연산이 복잡해질 것 같으면 StringBuilder를 쓰자는 것이다. 그리고 문제를 제대로 읽자는 것이다.

# 정답 코드
```
public class PGMRS_문자열압축_답보기 {
    /**
     * 문자를 2 개 단위로 보기 abcabcdede ab ca bc de de -> abcabc2de
     * 문자를 2 개 단위로 보기 abcabcdede abc abc ded e -> 2abcdede
     * 아놔 문제 잘못이해했다리
     * 2abc2de 되는줄알고 죽을만큼 머리썼는데
     **/
    public static void main(String[] args) {
        String s = "ababaab";
        int answer = s.length();    // 압축하기 전 문자열 길이로 초기화

        for(int i = 1; i <= s.length() / 2; i++){
            int zipLevel = 1;                           // 현재 압축정도
            String zipStr = s.substring(0, i);          // 압축할 문자  2면 2개씩 3이면 3개씩
            StringBuilder result = new StringBuilder(); // 압축완료한 문자를 저장할 StringBuilder

            for(int j = i; j <= s.length(); j += i){
                // 다음 문자 추출
                String next = s.substring(j, j + i > s.length() ? s.length() : i + j);  // 2,3,4 이런식으로 길게 갈 것이니까 계속 그만큼 잘라서 확인

                // 다음 문자와 현재 문자가 같으면 zipLevel증가
                if(zipStr.equals(next)) {
                    zipLevel++;
                }
                // 다음 문자와 현재 문자가 다를 경우 -> 자르기 끝남
                else{
                    // (압축이 안되었을 경우는 공백, 압축이 되었을경우 zipLevel을 붙여줌) + 압축할 문자를 넣어줌,
                    result.append((zipLevel != 1 ? zipLevel : "") + zipStr);
                    zipStr = next;      // 다음 문자를 압축할 문자로 지정
                    zipLevel = 1;       // 압축 정도 1로 초기화
                }
            }
            result.append(zipStr);      // 마지막에 추가안된 zipStr추가
            answer = Math.min(answer, result.length()); // 가장 작은 문자열 길이 저장  2개 3개로 나눠보면서 제일 작은 값을 찾아감
        }

        System.out.println(answer);
    }
}



```

# 잘못이해하고 풀다가 포기한 코드
```
import java.util.*;

public class PGMRS_문자열압축 {
    public static void main(String[] args) {
        String s = "ababcdcdababcdcd";
        List<Character> arr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            arr.add(s.charAt(i));
        }
        boolean [] visited = new boolean[arr.size()];
        Queue<Character> before = new LinkedList<>();
        before.add(arr.get(0));
        /**
         *
         * que에 다른게 나타나면
         * 큐의 맨 앞에 있는 문자와 비교해서 같으면 큐의 그 다음 문자와 주어진 문자의 다음 문자가 같은지 또 비교 이렇게 끝까지 다 같으면 이를 한 문자로 묶어서 만들어둔다.
         * 이걸 계속 반복해나간다.
         *
         **/
        int count = 1;
        int index = 0;
        List<Character> temp = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if(before.size()>0 && check(before,arr,i)>1){
                for (int j = 0; j < check(before,arr,i); j++) {

                }
            }else {
                count = 1;
                before.add(arr.get(i));
            }
        }
    }

     private static int check (Queue<Character> before, List<Character> arr,int j){
        int count = 1;
        for (int i = j; i < before.size(); i++) {
            if(before.poll().equals(arr.get(i))){
                count ++;
            }else {
                return count;
            }
        }
        return count;
    }
}

```

