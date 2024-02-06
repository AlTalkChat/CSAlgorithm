import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class BOJ_16928_뱀과사다리게임 {
    private static int N, M;
    private static int[] ladder = new int[101];
    private static int[] snake = new int[101];
    private static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {  // 다 더한다.
            st = new StringTokenizer(br.readLine(), " ");
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            if (i < N) ladder[before] = after;  // N 동안은 사다리
            else snake[before] = after;
        } // 입력부 완
        bfs();
    }

    // 뱀이든 사다리든 전부 다 타봐야 한다. 그래서 이동하면서 가장 먼저 도달한 곳을 체크해가면 된다.
    private static void bfs(){
        Queue<Integer> que = new LinkedList<>();
        que.add(1);

        int cnt = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            cnt++;  // 여기서 더해줘야 한 주사위 던짐에서 이동

            for (int i = 0; i < size; i++) {  // qua 에 들어있는 인자만큼만 반복
                int now = que.poll();
                for (int j = 1; j <= 6; j++) {
                    int current = now + j;  // 이동 후
                    if (current > 100) continue;  // 범위를 벗어나면 안됨
                    if (ladder[current] > 0) {  // 사다리가 있다면
                        current = ladder[current];  // 사다리를 타
                    } else if (snake[current] > 0) {  // 뱀이 있다면
                        current = snake[current];  // 뱀을 타
                    }
                    if (visited[current]) continue;  // 방문한 적이 있다면 넘어가

                    if (current == 100) {  // 딱 100번째 자리
                        System.out.println(cnt);
                        return;
                    }
                    visited[current] = true;  // 방문처리 후
                    que.add(current);  // 위치 지정
                }
            }
        }
    }
}
