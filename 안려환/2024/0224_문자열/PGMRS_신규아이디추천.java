import java.util.*;
class PGMRS_신규아이디추천 {
    public String solution(String new_id) {
        String answer = "";
        StringBuilder st = new StringBuilder();
        // stage 1:
        st.append(new_id.toLowerCase());

        // stage 2:
        List<Character> list = new ArrayList<>();

        for(int i = 0; i < st.length(); i ++){
            if(Character.isAlphabetic(st.charAt(i))){
                list.add(st.charAt(i));
            }

            if(st.charAt(i) == '-' ||  st.charAt(i) == '_' || st.charAt(i) == '.') {
                list.add(st.charAt(i));
            }

            if(Character.isDigit(st.charAt(i))){
                list.add(st.charAt(i));
            }
        }
        List<Character> dotList = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        // stage 3
        for(char a : list){
            if(a == '.'){
                stack.add('.');
            }else{
                if(stack.isEmpty()){
                    dotList.add(a);
                }else{
                    dotList.add('.');
                    dotList.add(a);
                    stack.clear();
                }
            }
        }

        if(dotList.size() == 0){
            dotList.add('a');
        }

        // stage 4
        if('.' == dotList.get(0)){
            dotList.remove(0);
        }

        if('.' == dotList.get(dotList.size()-1)){
            dotList.remove(dotList.size()-1);
        }

        // stage 5
        if(dotList.size() == 0){
            dotList.add('a');
        }

        // stage 6
        while(dotList.size()>=16){
            dotList.remove(dotList.size()-1);
        }

        if('.' == dotList.get(dotList.size()-1)){
            dotList.remove(dotList.size()-1);
        }

        // stage 7
        char lastc = dotList.get(dotList.size()-1);
        while(dotList.size() < 3){
            dotList.add(lastc);
        }

        st = new StringBuilder();
        for(char a : dotList){
            st.append(a+"");
        }
        return st.toString();
    }
}