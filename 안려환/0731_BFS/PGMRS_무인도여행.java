import java.util.*;

public class PGMRS_무인도여행 {
    public static void main(String[] args) {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
//        String[] maps = {"XXX","XXX","XXX"};
        Island island = new Island();
        System.out.println(Arrays.toString(island.islandFinder(maps)));
    }

}
class Island{
    class Pos {
        int x;
        int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[] islandFinder(String [] maps){
        int mapLen = maps.length; // 세로
        int lineLen = maps[0].length();// 가로
        int[][] islands = new int[mapLen][lineLen];
        String line = "";
        boolean[][] visited = new boolean[mapLen][lineLen];
        List<Integer> answer = new ArrayList<>(); // 답을 저장하는 리스트

        for (int i = 0; i < mapLen; i++) {
            line = maps[i];
            for (int j = 0; j < lineLen; j++) {
                if(line.charAt(j) != 'X' && ! visited[i][j]) {
                    Queue<Pos> que = new LinkedList<Pos>();
                    que.add(new Pos(i, j));
                    visited[i][j] = true;
                    int days = islandBFS(maps, visited, que);
                    answer.add(days);
                }
            }
        }

        if (answer.isEmpty()) {
            answer.add(-1);
        } else{
            Collections.sort(answer);
        }
        return answer.stream().mapToInt(x -> x).toArray();  // list to array 방법이다. 
    }

    public int islandBFS(String[] lands, boolean[][] visited, Queue<Pos> que){
        int [] dx = {-1,1,0,0};
        int [] dy = {0,0,-1,1};
        int mapLen = lands.length;
        int lineLen = lands[0].length();
        int nx = 0;
        int ny = 0;

        int days = 0;

        while (!que.isEmpty()){
            Pos currentPos = que.poll();
            days += lands[currentPos.x].charAt(currentPos.y) - '0';
            for (int i = 0; i < 4; i++) {
                nx = currentPos.x + dx[i];
                ny = currentPos.y + dy[i];
                if(nx >= 0 && nx<mapLen && ny >= 0 && ny<lineLen && !visited[nx][ny] && lands[nx].charAt(ny) != 'X'){
                    // BFS
                    // 1. 방문체크를 하고
                    visited[nx][ny] = true;
                    // 2. 큐에 넣어준다
                    que.add(new Pos(nx, ny));
                }
            }
        }
        return days;
    }
}