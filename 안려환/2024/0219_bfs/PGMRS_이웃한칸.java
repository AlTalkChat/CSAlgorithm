import java.util.*;
class PGMRS_이웃한칸 {
    private static int[] dx = {-1,1,0,0};
    private static int [] dy = {0,0,-1,1};
    private static String [][] map;
    private static int result = 0;
    public int solution(String[][] board, int h, int w) {
        map = board.clone();
        color(h,w);
        return result;
    }
    private static void color(int h, int w){
        class Pos{
            int x;
            int y;
            private Pos(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
        Queue<Pos> que = new LinkedList<>();
        que.add(new Pos(h,w));
        int nx,ny;
        while(!que.isEmpty()){
            Pos po = que.poll();
            for(int i = 0; i < 4; i ++){
                nx = po.x + dx[i];
                ny = po.y + dy[i];
                if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && map[h][w].equals(map[nx][ny])){
                    result += 1;
                }
            }
        }
    }
}