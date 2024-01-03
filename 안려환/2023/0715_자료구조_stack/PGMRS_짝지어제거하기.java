import java.util.*;

public class PGMRS_짝지어제거하기 {
    public static void main(String[] args) {
        String s = "baabaa" ;
        s = s.replace(" ","");
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                if(s.charAt(i) != stack.peek()){
                    stack.push(s.charAt(i));
                }else {
                    stack.pop();
                }
            }

        }
        if(stack.size()==0){
            System.out.print(1);
        }else {
            System.out.print(0);
        }
    }
}
