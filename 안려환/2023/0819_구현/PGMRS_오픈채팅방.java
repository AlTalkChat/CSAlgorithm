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
