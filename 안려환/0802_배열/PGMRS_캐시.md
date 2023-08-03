# 후기
리스트 그니까 linked List의 특성을 활용해서 푸는 문제였다.<br>
값을 입력받아서 그 값이 리스트에 있는지 조회해서 리스트의 맨 뒤로 이동시키면 그 것이 가장 최근에 참조한 값이 된다.<br>
그리고 기존 리스트에 없는 값이라면 리스트에 추가하는데 꽉 차있다면 0번 인덱스의 값을 제거하고 추가해주는 방식으로 풀이하였다.<br>
여기 문제에서 말하는 
- LRU 는 가장 오랫동안 사용되지 앟은 값을 삭제하는 알고리즘이다. <br>
- cache hit 는 캐시에 있는 값을 참조할 때 <br>
- cache miss 는 캐시에 없는 값을 참조할 때 발생하는 것이다. 


# 링크
https://school.programmers.co.kr/learn/courses/30/lessons/17680

# 코드
```
import java.util.*;

public class PGMRS_캐시 {
    public static void main(String[] args) {
//        String [] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        String [] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase();
        }
        int cacheSize = 3;
        cacheRun cacheRun = new cacheRun();
        cacheRun.cacheRun(cities,cacheSize);
        System.out.println(cacheRun.result);
    }
}

class cacheRun{
    public int result = 0;
    public void cacheRun(String [] cities, int cacheSize){
        List<String>  list = new ArrayList<>();
        if(cacheSize == 0){
            for (int i = 0; i < cities.length; i++) {
                result += 5;
            }
            return;
        }

        for (int i = 0; i < cities.length; i++) {
            if(findIndex(list,cities[i])>-1){
                result += 1;
                list.remove(findIndex(list,cities[i]));
                list.add(cities[i]);
            }else {
                System.out.println(cities[i]);
                result += 5;
                if(list.size() == cacheSize){
                    list.remove(0);
                    list.add(cities[i]);
                }else {
                    list.add(cities[i]);
                }

            }
        }
    }

    public int findIndex(List<String> list , String city){
        for (int i = 0; i < list.size(); i++) {
            if(city.equals(list.get(i))){
                System.out.println(i);
                return i;
            }

        }
        return -1;
    }

}

```