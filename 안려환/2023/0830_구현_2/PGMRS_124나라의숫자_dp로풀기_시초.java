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

