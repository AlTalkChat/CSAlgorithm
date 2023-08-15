import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class PGMRS_전력망둘로나누기 {
    private static int result = Integer.MAX_VALUE;
    private static int n = 9,length;
    private static int current;
    private static int [][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
    private static boolean [] visited;
    // answer => 3
    public static void main(String[] args) {
        length = wires.length;
        visited = new boolean[n];
        int temp;
        Arrays.sort(wires, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        System.out.println(wires[2][1]);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(!visited[j]){
                    int count = 0;
                    temp = wires[i][1];
                    wires[i][1] = -1;
                    bfs(i,temp,count);
                    wires[i][1] = temp;
                    result = Math.min(current,result);
                }
            }

        }
        System.out.println(result);
    }
    private static void bfs(int index,int value,int count){
        class Pos{
            int x,y;
            private Pos(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
        Queue<Pos> que = new LinkedList<>();
        que.add(new Pos(index,value));
        Pos temp;
        while (!que.isEmpty()){
            temp = que.poll();
            if(value != -1 && temp.y != -1){
                visited[temp.x] = true;
                count += 1;
                que.add()
            }

        }
    }


}
