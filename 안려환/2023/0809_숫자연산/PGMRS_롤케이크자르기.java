import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PGMRS_롤케이크자르기 {
    // 동일하게 잘라야 한다. -> 동일한 수로 나눠야 한다. (철수와 동생 둘 뿐이니까 둘로만 나누면 된다.)
    // 조합으로 나눠가며 각 종류가 몇 개인지 판단해서 같은 종류만 카운트해서 풀이한다.
    // 1, 2, 1, 3, 1, 4, 1, 2 -> 2
    // 1, 2, 3, 1, 4 -> 0

    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < topping.length; i++) {
            map.put(topping[i], map.getOrDefault(topping[i], 0)+1);
        }
        Set<Integer> bro = new HashSet<>();
        for (int i = 0; i < topping.length; i++) {
            bro.add(topping[i]);
            if(map.get(topping[i])==1){
                map.remove(topping[i]);
            }else {
                map.put(topping[i],map.get(topping[i])-1);
            }
            if(bro.size() == map.size()){
                count += 1;
            } else if (bro.size() > map.size()) {
                break;
            }
        }
        System.out.println(count);
    }
}
