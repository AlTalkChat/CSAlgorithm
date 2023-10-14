import java.util.*;

public class PGMRS_책쌓기 {
    private static int [] books = {3,1,2};
    private static int [] target = {1,3,2};
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < books.length; i++) {
            deque.add(books[i]);
        }
        int result = 0;
        for (int i = 0; i < target.length; i++) {
            for(int a : deque){
                if(a == target[i]){
                    deque.remove(a);
                    deque.addFirst(a);
                    break;
                }
                result += 1;
            }
        }
        System.out.println(result);

//        // 풀기 전 전략
//        // deque 를 활용해서 값을 찾고 찾는 만큼 1씩 더해간다.
//        Deque<Integer> deque = new ArrayDeque<>();  //활용할 deque 선언
//        for (int i = 0; i < books.length; i++) {  // 주어진 books 배열에서 deque 로 옮겨담기 위한 for문
//            deque.add(books[i]); // deque 에 add 해준다.
//        }
//        int result = 0;  // 정답을 담기 위한 정수
//        for (int i = 0; i < target.length; i++) { // target 배열을 활용해서 답을 도출하기 위한 for문
//            for(int a : deque){ // deque 안에 있는 값들을 꺼내 비교한다.
//                if(a == target[i]){ // 찾는 값이라면
//                    deque.remove(a);  // 해당 위치에서 제거해주고
//                    deque.addFirst(a); // 맨 앞에 삽입해준다.
//                    break;  // 그리고 종료한다.
//                }
//                result += 1; // 여기에 위치한 이유는 0번 인덱스에 있을 때는 더해지면 안되기 때문
//            }
//        }
//        return result;  // 값을 리턴한다.

    }
}
