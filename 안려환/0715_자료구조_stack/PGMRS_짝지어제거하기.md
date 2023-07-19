# 후기
stack 을 하도 안쓰다가 쓰다보니 사용법이 익숙하지 않았다. 
그러다 deque 라는 자료구조를 알게 되었다. 양쪽으로 데이터를 삽입할 수 있는 자료구조라고 한다. <br>
s원래는 문자를 싹 다 입력받아서 스택에 넣은 다음에 그것들을 꺼내면서 비교하고 다른 스택에 넣어서 또 돌리고 하는 식으로 하려했는데 매우 비효율적이었다. <br>
입력을 받으면서 다르면 stack 에 넣으면서 다음 문자를 확인하는 것이 훨씬 효율적이고 좋은 방법이었다.

# 코드
```
import java.util.*;
class Solution
{
    public int solution(String s)
    {
        s = s.replace(" ","");
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                if(s.charAt(i) != stack.peek()){
                    stack.push(s.charAt(i));
                }else {
                    stack.pop();
                }
            }

        }
        if(stack.size()==0){
            return 1;
        }else {
            return 0;
        }

        
    }
}
```
