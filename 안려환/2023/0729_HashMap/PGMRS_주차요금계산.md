# 후기
문제 또 제대로 안읽어서 이상하게 풀었다.<br>
이번 문제에서의 관건은 hashmap 의 키값에 맞게 정렬하기이다. <br>
나는 키값 배열을 정렬 후 그 키 값에 맞게 다른 배열에 값을 담아서 풀이하였다.

# 링크
https://school.programmers.co.kr/learn/courses/30/lessons/92341

# 코드
```
import java.util.*;

public class PGMRS_주차요금계산 {
    /**
     * 출차내역이 없다면 23:59 에 출차된 것으로 간주한다.
     * 기본 시간 기본 요금 단위 시간 단위 요금
     *
     * **/
    public static void main(String[] args) {
//        int [] fees = {180, 5000, 10, 600};
//        String [] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
//                "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
//                "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int [] fees = {120, 0, 60, 591};
        String  [] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        Parking parking = new Parking();
        parking.fee(fees,records);
        System.out.println(parking.fin);
    }
}
class Parking{
    public String[] result;
    public int [] fin;
    public void fee(int [] fees, String [] records){
        HashMap<String,String> inHourMap = new HashMap<>(); // 입차시간을 관리할 Map
        HashMap<String,Integer> map = new HashMap<>();  // 여긴누적 시간 누적할 map
        String time = "";
        String carNum = "";
        String type = "";
        for (int i = 0; i < records.length; i++) {
            StringTokenizer st = new StringTokenizer(records[i]);
            time = st.nextToken();
            carNum = st.nextToken();
            type = st.nextToken();
            if("IN".equals(type)){
                if(map.containsKey(carNum)) {
                    inHourMap.put(carNum,time);
                }
                else{
                    inHourMap.put(carNum,time);
                    map.put(carNum,0);
                }
            } else if("OUT".equals(type)){
                map.put(carNum,map.get(carNum)+timeCalc(carNum,fees,inHourMap.get(carNum),time));
                inHourMap.remove(carNum);
            }
        }

        for (Map.Entry<String,String> one:inHourMap.entrySet()){
            map.put(one.getKey(),map.get(one.getKey())+timeCalc(one.getKey(),fees,one.getValue(),"23:59"));
        }

        result = new String[map.size()];

        Arrays.sort(map.keySet().toArray(result));
        fin = new int [result.length];
        for (int i = 0; i < result.length; i++) {
            fin[i] = feeCalc(fees,map.get(result[i]));
        }
        System.out.println(Arrays.toString(fin));
    }

    private int timeCalc(String key,int[] fees,String inTime, String outTime){
        int inHour = Integer.parseInt(inTime.split(":")[0]);
        int inMin = Integer.parseInt(inTime.split(":")[1]);
        int outHour = Integer.parseInt(outTime.split(":")[0]);
        int outMin = Integer.parseInt(outTime.split(":")[1]);
        int time = 0;
        if(outMin < inMin){
            outMin += 60;
            outHour -= 1;
            return   (outHour - inHour)*60 + (outMin - inMin);
        }else {
            return   (outHour - inHour)*60 + (outMin - inMin);
        }

    }

    public int feeCalc(int [] fees , int time){
        if(time > fees[0]){
            int perTime = 0;
            time -= fees[0];
            if(time%fees[2]>0){
                perTime = time/fees[2] + 1;
            }else {
                perTime = time/fees[2];
            }
            return fees[1] + perTime*fees[3];
        }else {
            return fees[1];
        }
    }
}

```