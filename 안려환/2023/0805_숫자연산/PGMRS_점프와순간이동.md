# 후기 
내가 그간 객체지향적으로 코드를 짜기 위해서 AOP 를 최대한 지키면서 알고리즘 문제를 풀었는데<br>
그게 문제였다. 이게 프로그래머스에서는 객체를 생성할 때 시간이 엄청 소요되는 것 같다.....<br>
## 객체 생성 안하는 버전
<img width="400" alt="image" src="https://github.com/Ryeohwan/TRL/assets/73810834/6a2ee218-6ca9-401f-876a-689d91f536f8">

## 객체 생성한 버전
<img width="400" alt="image" src="https://github.com/Ryeohwan/TRL/assets/73810834/b10bd55f-cead-4157-8ad4-04911c3499ea">

- 시간이 10배나 차이가 난다..... 이런거 하지 말자.

# 링크
https://school.programmers.co.kr/learn/courses/30/lessons/12980

# 코드
```
public class PGMRS_점프와순간이동 {
    // 5 2
    // 6 2
    // 5000 5
    // k 만큼 점프하면 k 만큼의 배터리를 사용함.
    // 순간이동은 이동거리의 2배인 위치로 이동한다.
    // 몇 번의 덧셈과 곱셈으로 해당하는 수를 만들 수 있나 계산하는 것이다.
    public static void main(String[] args) {
        int n = 5000;
        int result = 0;
        while(n>0){
            if(n%2 != 0){
                n-= 1;
                result += 1;
            }else {
                n /= 2;
            }
        }
        System.out.println(result);
    }
}
//class IronSuit{
//    public int result;
//    public void move(int N){
//        while(N>0){
//            if(N%2 != 0){
//                N -= 1;
//                result += 1;
//            }else {
//                N /= 2;
//            }
//        }
//    }
//}


```