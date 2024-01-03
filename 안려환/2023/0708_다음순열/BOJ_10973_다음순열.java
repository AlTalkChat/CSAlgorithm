import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int temp = 0;
        int index = 0;
        int curr = 0;
        for (int i = N-2; i >= 0; i--) {
            if(arr[i] < arr[i+1]){  // 앞에꺼보다 뒤에꺼가 더 크면 거기가 변곡점이다.
                temp = arr[i];  // 계속 비교해서 만들기 위함
                curr = Integer.MAX_VALUE;
                // 정렬 알고리즘을 넣어야 한다. -> swap 을 활용해 보자. (2중 for문으로 활용가능할 듯) 뒷쪽에 역정렬을 해야한다.
                for (int j = N-1; j >= i+1; j--) {
                    if(temp<arr[j]){
                        if(curr != Math.min(curr, arr[j])){
                            index = j;
                            curr = arr[j];
                        }
                    }
                }
                swap(arr,i,index);
                for (int j = i+1; j <N-1 ; j++) {
                    for (int k = i+1; k < N-1; k++) {
                        if(arr[k]>arr[k+1]){
                            swap(arr,k,k+1);
                        }
                    }
                }
                break;
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
