import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931_회의실배정 {
    // 끝나는 시간으로 정렬한 배열 하나랑
    // 시작하는 시간으로 정렬한 배열 하나로 나눠
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = "";
        int [][] times = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");   // split
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());

        }

//         그리디를 활용한 풀이 
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }else return o1[1] - o2[1];
            }
        });

//
        int count = 1;
        int end = times[0][1]; // 끝나는 시간이 빠른 것으로 정렬되어 있으니...
        for (int i = 1; i < N; i++) {
            if(end <= times[i][0]){
                count++;
                end = times[i][1];
            }
        }
        System.out.print(count);

    }

//    private static void dfs(int [][] times, int N, int current, int index,int end){
//        if(index == N){
//            count = Math.max(count,current);
//            return;
//        }
//
//        for (int i = index; i < N; i++) {
//            if(end <= times[i][0]){
//                dfs(times,N,current+1,i+1,times[i][1]);
//            }
//        }
//    }

}
