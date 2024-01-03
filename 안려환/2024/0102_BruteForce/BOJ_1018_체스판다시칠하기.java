import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1018_체스판다시칠하기 {  
    private static Boolean [][] map;
    private static Boolean [][] cloneMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        String inp = "";
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        map = new Boolean[N][M];
        for (int i = 0; i < N; i++) {
            inp = br.readLine();
            for (int j = 0; j < M; j++) {
                if(inp.charAt(j) == 'W'){
                    map[i][j] = true;
                }else {
                    map[i][j] = false;
                }
            }
        } // 입력부 완

        // 전략
        // 일단 8*8 이라는 것은 고정이다. 일단 그럼 반복 수부터 그려보자
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8 ; j++) {
                // 주어진 map 에서 잘못된 구간이 나타났을 때 바꿔서 칠해보는 로직
                // 한 줄의 끝과 그 다음 줄의 시작은 같아야 한다.
                // xor 해주면서 0이 나온 곳은 count 1증가시키고 그 다음 map의 값을 바꿔준다.
                min = Math.min(checker(i,j),min);
            }
        }
        System.out.println(min);
    }

    private static int checker(int n, int m){
        int count1 = 0, count2 = 0;
        cloneMap = new Boolean[8][8];
        int indN = 0,indM = 0;
        for (int i = n; i < n+8; i++) {
            for (int j = m; j < m+8; j++) {
                cloneMap[indN][indM] = map[i][j];
                indM += 1;
            }
            indM = 0;
            indN += 1;
        }
        Boolean check = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(cloneMap[i][j] == check){
                    count1 += 1;
                }else{
                    count2 += 1;
                }
                if(j != 7)check = !check; // 다음 줄로 바뀔 때는 같은 상태여야 된다.
            }

        }
        return  Math.min(count1,count2);
    }
}
