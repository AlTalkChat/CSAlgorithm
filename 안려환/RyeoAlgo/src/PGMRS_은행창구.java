import java.util.HashMap;

public class PGMRS_은행창구 {
    private static int N = 1;
    private static int [][] simulation_data = {{2,3},{5,4},{6,3},{7,4}};

    public static void main(String[] args) {
        // 풀기 전 전략
        // 먼저 map 을 활용하기로 했다. n 만큼 map 의 key value 를 만들어서 거기에 sim[a][1] 을 값으로 넣어준다. 맨 처음에는 sim[a][0] + sim[a][1] 을 넣어준다.
        // 이후 다음 sim[a][0]와 같거나 작은 애가 있으면 value 에 sim[a][1]을 더해주고
        // 아니면 sim[a][0] - val 값을 result 에 넣어주고 value 중에 가장 작은 애에다가 sim[a][1]을 더해준다.
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(i,simulation_data[i][0]+simulation_data[i][1]);
        }
        int value,key,result = 0,time = 0;
        for (int i = N; i < simulation_data.length; i++) {
            value = Integer.MAX_VALUE;
            key = 0;
            for(int a: map.keySet()){
                if(map.get(a) < value){
                    value = map.get(a);
                    key = a;
                }
            } // 제일 빨리 끝나는 창구의 시간
            if(map.get(key) <= simulation_data[i][0]){  // 기다리지 않아도 된다.
                result += simulation_data[i][0] - map.get(key);
                time = map.get(key) + simulation_data[i][1];
                map.put(key,time);
            }else {
                result +=  map.get(key) - simulation_data[i][0];
                time = map.get(key) + simulation_data[i][1];
                map.put(key,time);
            }
        }
        System.out.println(result);


//        // 풀기 전 전략
//        // 먼저 map 을 활용하기로 했다. n 만큼 map 의 key value 를 만들어서 거기에 sim[a][1] 을 값으로 넣어준다. 맨 처음에는 sim[a][0] + sim[a][1] 을 넣어준다.
//        // 이후 다음 sim[a][0]와 같거나 작은 애가 있으면 value 에 sim[a][1]을 더해주고
//        // 아니면 sim[a][0] - val 값을 result 에 넣어주고 value 중에 가장 작은 애에다가 sim[a][1]을 더해준다.
//        HashMap<Integer,Integer> map = new HashMap<>();  // 사용할 HashMap 을 선언한다.
//        for (int i = 0; i < N; i++) { // N 만큼의 창구를 만들기 위한 반복문이다.
//            map.put(i,simulation_data[i][0]+simulation_data[i][1]);  // N개의 창구에 온 고객의 상담 종료 시간을 적어둔다.
//        }
//        int value,key,result = 0,time = 0;  // 가장 빨리 끝날 창구에 대한 시간을 담을 value 와 그에 해당하는 key 그리고 시간 계산을 할 time 정수를 초기화해둔다.
//        for (int i = N; i < simulation_data.length; i++) {  // 입장하는 모든 고객에 대해 처리하기 위한 반복문
//            value = Integer.MAX_VALUE;  // 최소값을 찾기 위한 Integer max value 로 초기화한다.
//            key = 0;  // key 도 초기화해둔다.
//            for(int a: map.keySet()){  // map 을 돌면서 가장 작은 값을 찾기 위한 반복문이다.
//                if(map.get(a) < value){  // 작은 값을 비교하기 위한 조건문이다.
//                    value = map.get(a);  // 작은 값(끝나는 시간) 이 가장 작은 값을 넣어준다.
//                    key = a;  // 해당하는 key 값으로 설정해준다.
//                }
//            } // 제일 빨리 끝나는 창구의 시간
//            if(map.get(key) <= simulation_data[i][0]){  // 기다리지 않아도 된다.
//                result += simulation_data[i][0] - map.get(key);  // 끝나는 시간이 더 늦어서 그만큼 온 고객은 기다려야 한다.
//                time = map.get(key) + simulation_data[i][1]; // 시작한 고객의 끝나는 시간을 계산한다.
//                map.put(key,time); // map 에 계산한 시간을 담아준다.
//            }else {  // 상담시간이 더 늦게 끝나는 경우
//                result +=  map.get(key) - simulation_data[i][0]; // 차이만큼 결과에 반영해준다.
//                time = map.get(key) + simulation_data[i][1];  // 시작한 고객의 끝나는 시간을 계산한다.
//                map.put(key,time);  // map 에 계산한 시간을 담아준다.
//            }
//        }
//        return result;  // 답안을 리턴한다.
    }
}
