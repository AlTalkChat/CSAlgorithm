import java.util.*;
public class PGMRS_두큐합같게만들기 {
//    private static int[] queue1 = {3,2,7,2},  queue2 = {4,6,5,1};

//    private static int[] queue1 = {1,2,1,2},  queue2 = {1,10,1,2};
private static int[] queue1 = {1,4},  queue2 = {4,8};
    private static long result = 0;

//    private static int[] queue1 = {1,1},  queue2 = {5,1};
    public static void main(String[] args) {
        long aMax = 0, bMax = 0;
        for (int i = 0; i < queue1.length; i++) {
            aMax = Math.max(aMax , queue1[i]);
            bMax = Math.max(bMax,queue2[i]);
        }
        long aSum = Arrays.stream(queue1).asLongStream().sum();
        long bSum = Arrays.stream(queue2).asLongStream().sum();
        long TSum =aSum + bSum;
        long half = TSum/2;
        if(half < aMax || half < bMax || TSum %2 != 0){
            System.out.println(-1);
            return;
        }  // 애시당초 안되는 애들은 제외
        Deque<Integer> list1 = new LinkedList<>();
        Deque<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < queue1.length; i++) {
            list1.add(queue1[i]);
        }
        for (int i = 0; i < queue2.length; i++) {
            list2.add(queue2[i]);
        }
        dfs(list1,list2,half);
        System.out.println(result);
    }
    private static void dfs(Deque<Integer> list1, Deque<Integer> list2, long half) {
        // 차피 한 쪽만 맞춰지면 나머지는 신경안써도 된다.
        long listSum = 0;
        for (int a : list1) {
            listSum += a;
        }
        int temp = 0;
        while (list2.size() > 0) {
            if (listSum > half) {
                temp = list1.poll();
                listSum -= temp;
                result += 1;
            } else if (listSum == half) {
                break;
            } else {
                temp = list2.poll();
                listSum += temp;
                list1.add(temp);
                result += 1;
            }
        }
        result = -1;
    }
}
