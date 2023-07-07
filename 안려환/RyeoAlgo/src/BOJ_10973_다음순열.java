import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ_10973_다음순열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // 입력부 완

        // 기저조건
        boolean flag = false;
        for (int i = N-2; i >= 0; i--) {
            if(arr[i]<arr[i+1]){
                flag = true;
            }
        }
        if(!flag){
            System.out.print(-1);
            return;
        }

        for (int i = N-1; i >= 0; i--) {
            if(arr[i] > arr[i-1]){  // 앞에꺼보다 뒤에꺼가 더 크면 거기가 변곡점이다.
                // 정렬 알고리즘을 넣어야 한다. -> swap 을 활용해 보자. (2중 for문으로 활용가능할 듯)
                for (int j = N-1; j >= 0; j--) {
                    for (int k = N-1; k >= 0 ; k--) {
                         b 
                    }
                }

            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    private static Integer[] swap(Integer [] arr, int i , int j){
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
}
