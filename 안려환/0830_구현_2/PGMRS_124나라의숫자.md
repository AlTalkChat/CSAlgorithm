# 후기
3으로 나눠질 때 3으로 나눠떨어지지 않을 떄를 나눠서 해야하는 3으로 나눠떨어지는 수가 오면 1을 뺀 후 나머지 값의 위치를 활용해서 1 2 4 를 넣어주는 방법으로 겨우 풀었다. <br>
기존에는 123을 미리 입력받고 4부터 채워나가는 식으로 풀이했더니 사이즈 에러가 발생했다. <br>
앞으로 문제를 많이 풀어봐야 겠다는 생각을 했다.

# 결과
<img width="248" alt="image" src="https://github.com/Ryeohwan/TRL/assets/73810834/35b97862-c845-489c-80b3-49a6f130f623">

# 링크
https://school.programmers.co.kr/learn/courses/30/lessons/12899

# 정답 코드
```
public class PGMRS_124나라의숫자 {
//    private static int n = 1;	//1
//    private static int n = 2;	//2
//    private static int n = 3;	//4
    private static int n = 29;	//11
    public static void main(String[] args) {
        String[] numbers = {"4", "1", "2"}; // 0일 때 4
        String answer = "";
        int temp;
        while (n>0){
            temp = n % 3;
            n /= 3;
            if(temp == 0) n--;
            answer = numbers[temp] + answer;
        }
        System.out.println(answer);
    }

}
```

# 런타임 에러난 코드
```
import java.util.*;

public class PGMRS_124나라의숫자_dp로풀기_시초 {
//    private static int n = 1;	//1
//    private static int n = 2;	//2
//    private static int n = 3;	//4
    private static int n = 97;	//11
    private static HashMap<Integer,String> map = new HashMap<>();
    public static void main(String[] args) {
        map.put(1,"1");
        map.put(2,"2");
        map.put(3,"4");
        int temp = 4;
        String tempString;
        // 몫을 가지고 3으로 계속 나눠가면서 기존에 있는 값을 찾아간다.
        while(true){
            if(temp > n){
                break;
            }
            if(!map.containsKey(temp)){  // 지금의 값이 map에 없다면
                if(temp % 3 == 0){  // 짝수면 이전 자리 숫자에서 2를 더한다.
                    map.put(temp,(Integer.parseInt(map.get(temp-1))+2)+"");
                    temp++;
                }else {  // 홀수니까 1,2,3 있는걸 아는 상황에서
                    tempString = map.get(temp/3) + map.get(temp%3);
                    map.put(temp, tempString);
                    temp++;
                }
            }
        }
        for(Integer key : map.keySet()){
            System.out.println("key: "+key + " val: "+map.get(key));
        }
    }
}
```