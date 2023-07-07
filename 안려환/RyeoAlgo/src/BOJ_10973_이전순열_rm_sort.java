import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ_10973_이전순열_rm_sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // 입력부 완
        Integer[] arr1 = arr.clone();
        Arrays.sort(arr1);
        if (Arrays.equals(arr,arr1)) {
            System.out.print(-1);
        } else {
            int temp = N-1;
            List<Integer> list = new ArrayList<>();
            for (int i = N-2; i >= 0; i--) {
                if(arr[i] > arr[i+1]){  // 제일 처음 만난 제일 작은 수가 아닌 곳
                    Arrays.sort(arr,i+1,N);
                    while (arr[i]<arr[temp]){
                        temp--;
                    }
                    arr = swap(arr,i,temp);
                    // 나머지 역정렬해준다.
                    Arrays.sort(arr,i+1,N);
                    for (int j = N-1; j > i; j--) {
                        list.add(arr[j]);
                    }

                    int t = 0;
                    for (int j = i+1; j < N; j++) {
                        arr[j] = list.get(t++);
                    }
                    break;
                }
            }

            for (int i = 0; i < N; i++) {
                System.out.print(arr[i]+" ");
            }
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
