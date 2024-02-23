import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2667_단지번호붙이기 {
    private static int N;
    private static int [][] map;
    private static boolean [][] visited;
    private static List<Integer> list = new ArrayList<>();
    private static int [] dx = {-1,1,0,0};
    private static int [] dy = {0,0,-1,1};
    static class Pos{
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        StringBuilder st = new StringBuilder();
        st.append("asdw");
        st.replace(2,3,"");
        System.out.println(st);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        String arr;
        for (int i = 0; i < N; i++) {
            arr = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = arr.charAt(j)-'0';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] > 0) {
                    bfs(i,j);
                }
            }
        }
        System.out.println(list.size());
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    private static void bfs(int i, int j){
        int count = 1;
        visited[i][j] = true;
        Queue<Pos> que = new LinkedList<>();
        que.add(new Pos(i,j));
        int nx,ny;
        while (!que.isEmpty()){
            Pos po = que.poll();
            for (int k = 0; k < 4; k++) {
                nx = po.x + dx[k];
                ny = po.y + dy[k];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] > 0) {
                    visited[nx][ny] = true;
                    count += 1;
                    que.add(new Pos(nx,ny));
                }
            }
        }
        list.add(count);
    }
}
