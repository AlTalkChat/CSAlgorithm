public class PGMRS_예상대진표 {
    public static void main(String[] args) {
        int n = 8, a = 4, b = 7;  // answer 3
        int count = 0;
        while(a!=b){
            a = calc(a);
            b = calc(b);
            count++;
        }
        System.out.println(count);

        // 주어진 수가 홀수면 그 다음 짝수랑 짝지어지고 짝수면 그 전의 홀수와 짝이지어진다.

    }
    public static int calc(int a){
        if(a%2 != 0){
            a = (a+1)/2;
        }else{
            a /=2;
        }
        return a;
    }

}
