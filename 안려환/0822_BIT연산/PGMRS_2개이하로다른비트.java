import java.util.Arrays;

public class PGMRS_2개이하로다른비트 {
    // 보니까 이게 앞에 하나를 추가하거나 아니면 맨 뒤에 추가하거나 하는 식드로 하면 될 것 같은디
    // 10 100 11 둘 중에서 2 이하로 다르면서 작은건 11 아닌감
    // 그리고 111 에서 1111 아니면 1000 인데 그냥 1111 이 답 아닌감 10111 이 제일 작네;
    // 0으로 끝나는 짝수는 1만 더해주면 된다.
    // 홀수인 경우는 앞에 1과 0 붙여주면 된다. 1111 -> 101111 or 10011 -> 10110 맨 앞에 1 더해주고 처음 만나는 0을
    // 1001 -> 1010  10110 아 뒤에서 처음 만나는 0을 1로 바꾸고 맨 뒤 0을 1로 바꾸자
    private static long [] numbers = {2,7};  // 3, 11
    public static void main(String[] args) {
        long [] answer = new long[numbers.length];
        String a;
        for (int i = 0; i < numbers.length; i++) {
            a = Long.toBinaryString(numbers[i]);
            // 1000 이면 1001 이 답이고
            if(numbers[i] % 2 == 1){  // 홀수일 경우
                if(a.contains("0")){
                    int idx = a.lastIndexOf("0");
                    // 문자열 다시 만들기
                    a = a.substring(0, idx) + "10" + a.substring(idx + 2);
                    answer[i] = Long.parseLong(a,2);
                }else {
                    a = "10"+a.substring(1,a.length());
                    answer[i] = Long.parseLong(a,2);
                }
            }else {
                answer[i] = numbers[i] + 1;
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
