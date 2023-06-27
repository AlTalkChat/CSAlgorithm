import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 큰수의법칙 {
    // 가보자 할 수 있숴
    // 5 8 3
    // 2 4 5 4 6

    // 차피 제일 큰 수들을 순서로 더해가면 무조건 정답이 나올 것 -> 그리디이다.
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int N = Integer.parseInt(a.split(" ")[0]);
        int M = Integer.parseInt(a.split(" ")[1]);
        int K = Integer.parseInt(a.split(" ")[2]);
        int [] arr = new int[N] ; // 정렬하여 가장 큰 수들을 더해주기 위함
        a = br.readLine();
        String [] aArr = a.split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(aArr[i]);
        }

        Arrays.sort(arr);
        int [] rarr = new int [N];
        for (int i = 0; i < arr.length; i++) {
            rarr[i] = arr[arr.length-i-1];
        }

        // 입력부 완
        int roop = K;
        int ind = 0;
        int sum = 0;
        for (int i = 0; i < M; i++) {  // M번 더해야하니까
            if(roop==0){
                ind += 1;
                sum += rarr[ind];
                ind = 0;
                roop = K;
            }else{
                sum += rarr[ind];
                roop -= 1;
            }
        }
        System.out.println(sum);
    }
}