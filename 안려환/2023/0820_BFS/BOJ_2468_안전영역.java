import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {
    private static int [] dx = {-1,1,0,0};
    private static int [] dy = {0,0,-1,1};
    private static int N;
    private static int [][] Map;
    private static int result = 0,count = 0;
    private static boolean [][]visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Map = new int[N][N];
        String [] arr = new String[N];
        int maxValue = 0;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
                maxValue = Math.max(Map[i][j],maxValue);
            }
        } // 입력부 완

        for (int i = 0; i < 101; i++) {
            if(maxValue < i){
                break;
            }else {
                count = 0;
                visited = new boolean[N][N];
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if(!visited[j][k]&&Map[j][k] > i){
                            bfs(i,j,k);
                        }
                    }
                }
                result = Math.max(result,count);
            }
        }
        System.out.println(result);
    }

    private static void bfs(int a,int x, int y){
        class Pos{
            int x;
            int y;
            private Pos(int x, int y){
                this.x = x;
                this.y = y;
            }
        }

        Queue<Pos> que = new LinkedList<>();
        que.add(new Pos(x,y));
        while (!que.isEmpty()){
            Pos po = que.poll();
            visited[po.x][po.y] = true;
            int nx,ny;
            for (int i = 0; i < 4; i++) {
                nx = po.x + dx[i];
                ny = po.y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && Map[nx][ny] > a && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    que.add(new Pos(nx,ny));
                }
            }
        }
        count += 1;
    }
}
