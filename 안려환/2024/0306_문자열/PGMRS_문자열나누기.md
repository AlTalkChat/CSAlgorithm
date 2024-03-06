문자열 연산의 문제. while을 너무 여러번 사용했다. 다른 풀이를 보니 이렇게도 해결 할 수 있었다. 다음엔 최적화를 더 해봐야겠다.

```java
class Solution {
    public int solution(String s) {
        int answer = 0;

        int first = 0;
        int second = 0;
        char compare = s.charAt(0);

        for(int i = 0; i < s.length();i++){

            if(compare == s.charAt(i)){
                first++;
            }else{
                second++;
            }

            if(first == second){
                answer++;
                first = 0;
                second = 0;
                if(i+1 < s.length()){
                    compare = s.charAt(i+1);
                }
            }
        }

        if(first != 0 || second !=0)
            answer++;

        return answer;
    }
}
```

이렇게 하면 2뎁스로 풀이할 수 있다. 
같은 횟수의 반복일 때 처리 후 인덱스 밖으로 나가지 않게 설정한다.
그리고 맨 처음 같을 때가 아니라면 더해주는 방식으로 풀이이다.