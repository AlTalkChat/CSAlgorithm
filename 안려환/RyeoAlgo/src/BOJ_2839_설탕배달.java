import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839_설탕배달 {
    private static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while(N>0){
            if(N % 5 == 0){
                result += N / 5;
                break;
            }else {
                N -= 3;
                result += 1;
            }
        }
        if(N < 0){
            System.out.println(-1);
        }else {
            System.out.println(result);
        }

    }
}
