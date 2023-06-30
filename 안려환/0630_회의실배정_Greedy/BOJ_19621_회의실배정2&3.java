import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 회의실배정2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] times = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
            times[i][2] = Integer.parseInt(st.nextToken());
        }

        int [] dp = new int[N];

        if(N == 1){  // 아놔 딱 하나 있을 경우를 고려안했네
            System.out.print(times[0][2]);
        }else{
            dp[0] = times[0][2];
            dp[1] = Math.max(dp[0],times[1][2]);
            for (int i = 2; i < N; i++) {
                dp[i] = Math.max(dp[i-1],dp[i-2]+times[i][2]);
            }
            System.out.print(dp[dp.length-1]);
        }

    }

}