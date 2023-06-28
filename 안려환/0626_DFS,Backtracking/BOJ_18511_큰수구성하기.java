import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18511_큰수구성하기 {
    private static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String N = input.split(" ")[0];  // 각 자리 수의 크기를 비교하기 위함
        int K = Integer.parseInt(input.split(" ")[1]);
        input = br.readLine();
        List<Integer> kl = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            kl.add(Integer.parseInt(input.split(" ")[i]));
        }
        // 입력부 완
        Collections.sort(kl, Collections.reverseOrder());
        int [] Narr = new int[N.length()];
        for (int i = 0; i < N.length(); i++) {
            Narr[i] = N.charAt(i) - '0';
        }
        dfs(kl,Narr,Integer.parseInt(N),0,0,false);
        int result = max;
        check(0,kl,Integer.parseInt(N));
        System.out.print(max);
    }

    private static void dfs(List<Integer> kl, int [] Narr, int N, int index,int current,boolean flag){
        if(current > N){  // 백트래킹 현재 수보다 큰 수 나오면 끝내
            return;
        }
        if(index == Narr.length){  // 끝까지 왔다면
            max = Math.max(max,current); // 큰 수 비교해서 처리
            return;
        }
        if(flag == true){  // 주어진 자리의 수보다 작은 수가 앞자리에 왔다면
            while((current+"").length() < (N+"").length()){
                current *= 10;
                current += kl.get(0);  // 그 뒤는 가장 큰 수로 채워버려
            }
            max = Math.max(max,current); // 그리고 큰 수 비교
            return;
        }

        for (int i = 0; i < kl.size(); i++) {
            if(Narr[index] > kl.get(i)){
                dfs(kl,Narr,N,index+1,current*10+kl.get(i),true);  // 작은 수로 채우게 되었다. flag 처리
            } else if (Narr[index] == kl.get(i)) {
                dfs(kl,Narr,N,index+1,current*10+kl.get(i),false); // 같은 수라 뒤에도 수를 체크해야 한다.
            }
        }
    }
    private static void check(int result, List<Integer> kl,int N){
        if(max == -1){ // 같은 자리수에 해당하는 수가 없을 때
            while((result+"").length() < (N+"").length()){
                result *= 10;
                result += kl.get(0);  // 그보다 작은 자리로 제일 큰 수로 채우자.
            }
            max = result/10;
        }


    }
}
