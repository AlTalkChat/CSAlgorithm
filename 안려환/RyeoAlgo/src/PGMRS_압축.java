import java.util.*;
public class PGMRS_압축 {
    private static String msg = "KAKAO";
//    private static String msg = "TOBEORNOTTOBEORTOBEORNOT";
//    private static String msg = "ABABABABABABABAB";
    private static HashMap<String, Integer> map = new HashMap<>();
    private static int index = 26;
    private static String line = "";
    public static void main(String[] args) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char a = (char)('A' + i);
            map.put(Character.toString(a),i+1);
        }
        String temp;
        int count = 0;
        for (int i = 0; i < msg.length(); i++) {
            count = check(msg,i);
            // 글자 2개 이상이 map 에 있다는 뜻
            if(count > 0){
                i += count;
                System.out.println(line);  
                answer.add(map.get(line));  // 수정 계획
            }else {
                System.out.println(msg.charAt(i));
                answer.add(map.get(Character.toString(msg.charAt(i))));
            }
        }
        System.out.println(Arrays.toString(answer.toArray()));
//        for (String key:map.keySet()) {
//            System.out.println(map.get(key));
//            System.out.println(key);
//        }
        int [] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
    }
    private static int check (String msg, int idx){
        // 문자열을 보면서 map 에 있으면 계속 타고 가면서 없는거 나올 때까지 문자 합쳐가며 만들고 map 에 추가해준다.
        // idx = i 
        int count = -1;
        line = msg.charAt(idx)+"";
        idx++;
        while(map.containsKey(line)&&idx<msg.length()){
//            System.out.println("line was: "+line);
            line += msg.charAt(idx);
            count += 1;
            idx++;
//            if(idx != msg.length()-1){
//                idx += 1;
//                line += msg.charAt(idx);
//            }else {
//                count -=1;
//                break;
//            }
//            System.out.println("line now: "+line);
        }

        index += 1;

        if(!map.containsKey(line)){
            map.put(line,index);
        }
        if(idx == msg.length()){
            count += 1;
            return count;
        }
//        for (String ket:map.keySet()) {
//            System.out.println(ket);
//        }
        System.out.println("line added: "+line+" answer num is: "+map.get(line)+" count is: "+count + " idx where: "+idx);
        line = line.substring(0,line.length()-1);
        return count;
    }
}
