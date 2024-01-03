# 후기
뭔가 시간을 더 단축할 수 있을 것같긴 한데 내 생각엔 이렇게 풀었다.<br>
홀수면 그 위의 수와 같은 조니까 하고 짝수면 그냥 /2 하면 된다.<br>
다른 사람은 어떻게 풀었나 궁금해서 찾아봤다.

# 링크
https://school.programmers.co.kr/learn/courses/30/lessons/12985

# 코드
```
public class PGMRS_예상대진표 {
    public static void main(String[] args) {
        int n = 8, a = 4, b = 7;  // answer 3
        int count = 0;
        while(a!=b){
            a = calc(a);
            b = calc(b);
            count++;
        }
        System.out.println(count);

        // 주어진 수가 홀수면 그 다음 짝수랑 짝지어지고 짝수면 그 전의 홀수와 짝이지어진다.

    }
    public static int calc(int a){
        if(a%2 != 0){
            a = (a+1)/2;
        }else{
            a /=2;
        }
        return a;
    }

}

```

# 다른 사람이 푼 코드
```
while(a != b){
    a = a / 2 + a % 2;
    b = b / 2 + b % 2;
    answer ++;
}
return answer;
```

- 홀수 짝수 처리 이렇게 하면 됐네 다음부터 써먹어야 겠다.