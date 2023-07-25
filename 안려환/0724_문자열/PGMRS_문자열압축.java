import java.util.*;

public class PGMRS_문자열압축 {
    public static void main(String[] args) {
        String s = "ababcdcdababcdcd";
        List<Character> arr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            arr.add(s.charAt(i));
        }
        boolean [] visited = new boolean[arr.size()];
        Queue<Character> before = new LinkedList<>();
        before.add(arr.get(0));
        /**
         *
         * que에 다른게 나타나면
         * 큐의 맨 앞에 있는 문자와 비교해서 같으면 큐의 그 다음 문자와 주어진 문자의 다음 문자가 같은지 또 비교 이렇게 끝까지 다 같으면 이를 한 문자로 묶어서 만들어둔다.
         * 이걸 계속 반복해나간다.
         *
         **/
        int count = 1;
        int index = 0;
        List<Character> temp = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if(before.size()>0 && check(before,arr,i)>1){
                for (int j = 0; j < check(before,arr,i); j++) {

                }
            }else {
                count = 1;
                before.add(arr.get(i));
            }
        }
    }

     private static int check (Queue<Character> before, List<Character> arr,int j){
        int count = 1;
        for (int i = j; i < before.size(); i++) {
            if(before.poll().equals(arr.get(i))){
                count ++;
            }else {
                return count;
            }
        }
        return count;
    }
}
