import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018_체스판다시칠하기 {
    private static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean [][] map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String hori = br.readLine();
            for (int j = 0; j < M; j++) {
                if(hori.charAt(j)=='B'){  // ^ 연산으로 양옆을 비교해서 풀이하기 위해서 바꿔줬다.
                    map[i][j] = true;
                }
            }
        }
        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                check(map,i,j);
            }
        }
        System.out.println(result);
    }
    private static void check(boolean [][] map , int a, int b){
        int count = 0;
        boolean standard = map[a][b];
        for (int i = a; i < a+8; i++) {
            for (int j = b; j < b+8; j++) {
                if(map[i][j] != standard){
                    count++;  // 다른게 있으면 칠해야 하니까 증가시킨다.
                }
                standard = !standard;  // 이후 기준점을 변경시켜준다.
            }
            standard = !standard;
        }  // 주어진 전체를 확인

        // 이걸 생각 못했다....
        count = Math.min(count,64-count);

        result = Math.min(result,count);
    }
}
