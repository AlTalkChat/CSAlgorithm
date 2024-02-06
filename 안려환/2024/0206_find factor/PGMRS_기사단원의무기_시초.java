import java.util.*;
public class PGMRS_기사단원의무기_시초 {
    private static boolean [] primes;
    public int solution(int number, int limit, int power) {
        List<Integer> list = new ArrayList<>();
        int count = 0, result = 0;
        primes = new boolean[number + 1];
        primes[0] = false;
        primes[1] = false;
        primes[2] = false;
        Prime(number);
        // 소수인 애들은 처음부터 2로 지정해야 한다.
        for(int i = 2; i<= number; i ++){
            // 약수를 계산할 로직
            // n이면 n-1 까지 % 연산해보고 0인 애들만 count 그래서 count
            // list 에 add 한다.
            count = 0;
            // 소수인지 확인하는 로직
            if(!primes[i]){
                count = 2;
                if(count > limit){
                    count = power;
                }
                result += count;
                continue;
            }

            for(int j = 1; j <= i; j ++){
                if(i % j == 0){
                    count ++;
                }
            }
            if(count > limit){
                count = power;
            }
            result += count;
        }

        return result + 1;
    }

    private static void Prime(int N){
        for(int i = 2; i <= Math.sqrt(N); i ++){
            if(primes[i]) continue;

            for(int j = i * i; j < primes.length; j = j + i){
                primes[j] = true;
            }
        }
    }
}
