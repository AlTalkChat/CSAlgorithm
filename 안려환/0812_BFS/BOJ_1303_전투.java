import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1303_전투 {
    private static char [][] map;
    private static boolean [][] visited;
    private static int W,B;
    private static int [] dx = {-1,1,0,0};
    private static int [] dy = {0,0,-1,1};
    private static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char [M][N];
        visited = new boolean[M][N];
        String temp = "";
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            temp = st.nextToken();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j);
            }
        }  // 입력부 완
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    bfs(map[i][j],i,j);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(W).append(" ").append(B);
        System.out.println(sb);
    }
    private static void bfs(char now,int x,int y){
        class Pos{
            int x;
            int y;
            public Pos(int x , int y){
                this.x = x;
                this.y = y;
            }
        }

        Queue<Pos> que = new LinkedList<>();
        que.add(new Pos(x,y));
        visited[x][y] = true;
        int tempW = 1;
        int tempB = 1;


        while(!que.isEmpty()){
            Pos po = que.poll();
            int nx = 0;
            int ny = 0;
            for (int i = 0; i < 4; i++) {
                nx = po.x + dx[i];
                ny = po.y + dy[i];
                if(nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && now == map[nx][ny]){
                    visited[nx][ny] = true;
                    if(now == 'B'){
                        tempB += 1;
                    }else {
                        tempW += 1;
                    }
                    que.add(new Pos(nx,ny));
                }
            }
        }
        if(now == 'W'){
            W += tempW * tempW;
        }else {
            B += tempB * tempB;
        }


    }
}

