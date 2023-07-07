import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10974_모든순열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
        boolean [] visited = new boolean[N];
        List<Integer> res = new ArrayList<>();
        dfs(N,arr,visited,res);
    }
    private static void dfs(int N, int [] arr, boolean [] visited,List<Integer> res){
        if(res.size() == N){
            for (int i = 0; i < N; i++) {
                System.out.print(res.get(i) + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            if(visited[i] != true){
                res.add(arr[i]);
                visited[i] = true;
                dfs(N,arr,visited,res);
                res.remove(res.size()-1);
                visited[i] = false;
            }
        }
    }
}
