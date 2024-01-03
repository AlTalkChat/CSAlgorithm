import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436_영화감독숌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int goal = 1;
        // 666부터 하나씩 수 키워간다. +1 할 때마다 문자열로 바꿔서 안에 666있나 확인 작은 수부터 갈거라 무줙권 순서는 맞다.
        int bruteNum = 666;
        while (goal != N){
            String checkStr = bruteNum+"";
            if(checkStr.contains("666")){
                goal ++;
                bruteNum++;
            }else {
                bruteNum++;
            }
        }
        System.out.println(bruteNum);
    }
}
