import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PGMRS_전력망둘로나누기 {
    private static int result = Integer.MAX_VALUE;
    private static int n,length;
    private static int current;
    private static int [][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
    // answer => 3
    public static void main(String[] args) {
        length = wires.length;
        int temp;
        for (int i = 0; i < length; i++) {
            temp = wires[i][1];
            wires[i][1] = -1;
            bfs();
            wires[i][1] = temp;
            result = Math.min(current,result);
        }
        System.out.println(result);
    }
    private static void bfs(){
        class Pos{
            int x,y;
            private Pos(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
        while (true){
            
        }
    }


}
