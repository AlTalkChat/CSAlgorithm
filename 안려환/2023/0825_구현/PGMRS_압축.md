# 후기
왤케 어려운지 모르겠다. 대충 로직은 알겠는데 자꾸 생각머리가 안돌아서 기존에 없던 단어가 온 것을 추가해주고 그리고 다시 기존 단어 탐색 인덱스로 가서 처리해주는 부분을 생각못해내서 3일동안 거의 10시간 가까이 투자했다.<br>

# 결과
<img width="258" alt="image" src="https://github.com/Ryeohwan/TRL/assets/73810834/875b07d4-70d3-4532-9080-325cd600d619">

# 링크
https://school.programmers.co.kr/learn/courses/30/lessons/17684

# 코드
```
import java.util.*;


public class PGMRS_압축_다시도전 {
    private static HashMap<String, Integer> map = new HashMap<>();
    private static List<Integer> answer = new ArrayList<>();
    private static int index = 26;
    private static String line = "";
//    private static String msg = "KAKAO";
        private static String msg = "TOBEORNOTTOBEORTOBEORNOT";
//    private static String msg = "ABABABABABABABAB";

    public static void main(String[] args) {
        for (int i = 0; i < 26; i++) {
            map.put(Character.toString((char)('A'+i)),i+1);
        }
        for (int i = 0; i < msg.length(); i++) {
            String temp = msg.charAt(i)+"";
            while(map.containsKey(temp)){  // 맨 처음 돌았을 때는
                if(i == msg.length()-1){
                    break;
                }else {
                    i += 1;
                }
                temp += msg.charAt(i)+"";  // 있우면 계속 붙여서 넣는다.
            }  // 이게 끝나면 없는 애가 나온다.
            if(!map.containsKey(temp)){   // i가 msg 마지막을 가리켜서 끝난 경우가 있을 수 있기에
                index += 1;
                map.put(temp,index);
                temp = temp.substring(0,temp.length()-1);
                i -= 1;
            }
            answer.add(map.get(temp));
        }
        System.out.println(Arrays.toString(answer.toArray()));
    }
}

```