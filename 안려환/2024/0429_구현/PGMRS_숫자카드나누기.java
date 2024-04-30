import java.util.*;
// 먼저 각각 배열을 돌면서 공약수가 있는 배열들을 고른다.
// 공약수가 없다면 그 배열은 못나눈다.
// 공약수가 있는 배열에서 최대공약수를 구하면 된다.
// 둘 다 공약수가 있다면
// 각각 공약수의 배열을 내림차순으로 정리해서 번갈아가며 서로를 나눌 수 없는가 체크한다.

// 최대 공약수를 구하는 방법은 유클리드 호제법이라는 것이 있었음.
// 두 수의 크기를 비교해서 작은건 b 큰건 a 로 둔다.
// 그래서 재귀적으로 b 를 a 로 두고 b 자리는 큰 수를 작은수로 나눈 나머지로 둔다.
// 탈출 조건은 a 를 b로 나눈 나머지가 0이 나올 때까지 계산한다.
public class PGMRS_숫자카드나누기 {
    private static List<Integer> listA = new ArrayList<>();
    private static List<Integer> listB = new ArrayList<>();
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int gcbA = arrayA[0];
        int gcbB = arrayB[0];
        for(int i = 1; i < arrayA.length; i++){
            gcbA = gcb(arrayA[i],gcbA);
            gcbB = gcb(arrayB[i],gcbB);
        }

        if(checker(arrayA, gcbB)){
            answer = Integer.max(answer, gcbB);
        }
        if(checker(arrayB, gcbA)){
            answer = Integer.max(answer, gcbA);
        }
        return answer;
    }
    public int gcb(int a , int b){
        if(a % b == 0) return b;
        else return gcb(b, a % b);
    }
    public boolean checker(int[] array , int b){  // 나눌 수 없는 수여야하니까
        for(int a: array){
            if(a % b == 0){
                return false;
            }
        }
        return true;
    }
}
