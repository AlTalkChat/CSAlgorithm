public class PGMRS_예상대진표 {
    public static void main(String[] args) {
        int n = 8, a = 4, b = 7;  // answer 3
        if(a == b){
            System.out.println(1);
            return;
        }
        int sqrt = 0;
        while(n!=1){
            n /= 2;
            sqrt += 1;
        }

        // 주어진 수가 홀수면 그 다음 짝수랑 짝지어지고 짝수면 그 전의 홀수와 짝이지어진다.
        if(a>b){
            if(b>n/2){

            }else {
                System.out.println(sqrt);
            }
        }else {
            if(a>n/2){

            }else {
                System.out.println(sqrt);
            }
        }
    }

    private int sqrt(int n){
        int seung = 0;
        while (n != 1){
            n/=2;
            seung+=1;
        }
        return seung;
    }
}
