import java.util.*;

public class PGMRS_전력망둘로나누기 {
    private static int result = Integer.MAX_VALUE;
    private static int n = 9,length;
    private static int [][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
//    private static int [][] wires = {{1, 2}, {2, 3}, {3, 4}};
//    private static int [][] wires = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
    private static boolean [] visited;
    // answer => 3
    public static void main(String[] args) {
        length = wires.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            list.add(temp);
        }// list 초기화해준다.
        visited = new boolean[n];

        for (int i = 0; i < length; i++) {
            list.get(wires[i][0]-1).add(wires[i][1]-1);
            list.get(wires[i][1]-1).add(wires[i][0]-1);
        }  // 인접 리스트를 만든다.

        int temp1,temp2;
        // 하나씩 끊으면서 전체 갯수를 카운트해야 한다.

        for (int i = 0; i < length; i++) {
            temp1 = wires[i][0]-1;
            temp2 = wires[i][1]-1;
            list.get(temp1).remove(Integer.valueOf(temp2));
            list.get(temp2).remove(Integer.valueOf(temp1));
            print(list);
            bfs(list,temp1);
            list.get(temp1).add(temp2);
            list.get(temp2).add(temp1);
            visited = new boolean[n];
        }
        System.out.println(result);
    }
    private static void bfs(List<List<Integer>> list,int start){
        int count = 1;  // 한 번만 bfs 돌게 되면 나머지는 노드의 수와의 차이로 계산하면 된다.
        Queue<Integer> que = new LinkedList<>();
        que.add(start);


        while (!que.isEmpty()){
            int now = que.poll();
            System.out.println("now " + now);
            visited[now] = true;
            for (int i = 0; i < list.get(now).size(); i++) {
                int next = list.get(now).get(i);
                if(!visited[next]){
                    System.out.println("i 가 뭐냐면 "+list.get(now).get(i));
                    visited[next] = true;
                    que.add(next);
                    count += 1;
                }
            }
        }
        System.out.println(count+" "+(n-count));
        count = Math.abs((n - count) - count);
        result = Math.min(result,count);
        System.out.println("bfs 끝났다.");
        System.out.println();
    }

    private static void print(List<List<Integer>> list){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j));
            }
            System.out.println();
        }
        System.out.println();
    }
}
