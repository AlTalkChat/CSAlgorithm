import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16918_봄버맨 {

    // 문제 이해
    /**
     *
     * 먼저 O 로 표시된 폭탄이 주어진다. 1초가 지난 상태이다.
     * 그리고 1초가 지나면 .인 위치에 O 로 폭탄이 채워진다.
     * 그리고 또 1초가 지나면 먼저 설치된 폭탄이 터지는데 사방으로 터지면서 . 으로 만들고 나머지 폭탄은 그대로 -> 방문체크된 폭탄만 터지는 것
     * 그 다음 기존에 있던 폭탄들이 터지고 나중에 설치된 폭탄은 남아있다.
     *
     * **/


    private static int result = 0;
    private static int[] x = {0,0,-1,1};
    private static int [] y = {-1,1,0,0};
    private static Queue<Pos> que = new LinkedList<>();
    private static class Pos{
        int x,y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        String str = "";
        char [][] map = new char[R][C];
        boolean [][] visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'O'){
                    visited[i][j] = true;
                }
            }
        }  // 입력부 완
        que.add(new Pos(0,0));
        bfs(map,visited,R,C,N);
    }

    private static void bfs(char[][] map,boolean [][] visited, int R, int C, int N){
        for (int i = 0; i < 4; i++) {

        }
    }
}
