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
