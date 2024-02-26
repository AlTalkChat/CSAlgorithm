import java.util.Stack;

public class PGMRS_햄버거만들기 {
    private static int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int i : ingredient){  // 햄버거가 만들어지려면 연속으로 재료가 들어가있어야 한다.
            stack.push(i);  // 다음 오는 재료를 담아주고
            if(stack.size() >= 4){  // 4개 이상 재료가 담겼을 때
                if((stack.get(stack.size() - 4) == 1) && (stack.get(stack.size() - 3) == 2) &&
                        (stack.get(stack.size() - 2) == 3)&& (stack.get(stack.size() - 1) == 1)){  // 연속으로 담겨있는지 확인 후
                    answer ++;  // 답 올려주고
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();  // 연속으로 만들어진 햄버거를 제거해준다.
                }
            }
        }
        System.out.println(answer);

    }
}
