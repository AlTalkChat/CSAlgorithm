# 후기
간단한 문제였는데 배열이라 인덱스 위치 잘 따졌어야했는데 안해서 틀렸다. 그래서 list 로 바꿔서 풀이했고 맞았다. 

# 링크
https://school.programmers.co.kr/learn/courses/30/lessons/42888

# 결과
<img width="353" alt="image" src="https://github.com/Ryeohwan/TRL/assets/73810834/65818c23-c5e8-4bf7-8454-703574284ec3">

# 코드
```
import java.util.*;

public class PGMRS_오픈채팅방 {
    private static String [] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
    public static void main(String[] args) {
        HashMap<String,String> enterMap = new HashMap<>();
        List<List<String>> resultList = new ArrayList();
        List<String> tempList;
        String [] answer;
        StringTokenizer st;
        String uid,name;
        int count= 0;
        for (int i = 0; i < record.length; i++) {
            tempList = new ArrayList<>();
            st = new StringTokenizer(record[i]);
            switch (st.nextToken()){
                case "Enter":
                    uid = st.nextToken();
                    name = st.nextToken();
                    enterMap.put(uid,name);
                    tempList.add(uid);
                    tempList.add("님이 들어왔습니다.");
                    resultList.add(tempList);
                    count +=1;
                    break;
                case "Change":
                    uid = st.nextToken();
                    name = st.nextToken();
                    enterMap.put(uid,name);
                    break;
                case "Leave":
                    count +=1;
                    uid = st.nextToken();
                    tempList.add(uid);
                    tempList.add("님이 나갔습니다.");
                    resultList.add(tempList);
                    break;
                default:
                    break;
            }
        }
        answer = new String[count];
        for (int i = 0; i < answer.length; i++) {
                answer[i] = enterMap.get(resultList.get(i).get(0))+resultList.get(i).get(1);
                System.out.println(answer[i]);
        }
    }
}

```