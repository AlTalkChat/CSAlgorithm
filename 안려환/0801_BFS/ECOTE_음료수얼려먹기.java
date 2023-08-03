import java.util.*;

public class ECOTE_음료수얼려먹기 {
    public static void main(String[] args) {
        int [] rowCol = {15,14};
        String [] juiceMap = {"00000111100000", "11111101111110", "11011101101110", "11011101100000",
                "11011111111111", "11011111111100", "11000000011111",
                "01111111111111", "00000000011111", "01111111111000",
                "00011111111000", "00000001111000", "11111111110011",
                "11100011111111", "11100011111111"};
        int [][] map = new int [rowCol[0]][rowCol[1]];
        String line = "";
        for (int i = 0; i < rowCol[0]; i++) {
            line = juiceMap[i];
            for (int j = 0; j < rowCol[1]; j++) {
                map[i][j] = line.charAt(j)-'0';
            }
        }
        boolean [][] visited = new boolean[rowCol[0]][rowCol[1]];
        Juice juice = new Juice();
        juice.mapSeek(map,visited);
        System.out.println(juice.result);
    }

}

class Juice{
    public int result;
    private int [] dx = {0,0,-1,1};
    private int [] dy = {-1,1,0,0};

    class Pos{
        int x;
        int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public void mapSeek(int [][] map, boolean[][] visited){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 0){
                    bfs(map,visited,i,j);
                }
            }
        }
    }
    public void bfs(int [][] map, boolean[][] visited,int i , int j) {
        boolean check = false;
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(i,j));
        visited[i][j] = true;
        while (!queue.isEmpty()){
            Pos cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if(nx>=0 && nx<map.length && ny>= 0 && ny < map[0].length && !visited[nx][ny] && map[nx][ny] == 0){
                    visited[nx][ny] = true;
                    queue.add(new Pos(nx,ny));
                    check = true;
                }
            }
        }
        if(check){
            result +=1 ;
        }
    }
}