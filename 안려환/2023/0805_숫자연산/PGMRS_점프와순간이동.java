public class PGMRS_점프와순간이동 {
    // 5 2
    // 6 2
    // 5000 5
    // k 만큼 점프하면 k 만큼의 배터리를 사용함.
    // 순간이동은 이동거리의 2배인 위치로 이동한다.
    // 몇 번의 덧셈과 곱셈으로 해당하는 수를 만들 수 있나 계산하는 것이다.
    public static void main(String[] args) {
        int n = 5000;
        int result = 0;
        while(n>0){
            if(n%2 != 0){
                n-= 1;
                result += 1;
            }else {
                n /= 2;
            }
        }
        System.out.println(result);
    }
}
//class IronSuit{
//    public int result;
//    public void move(int N){
//        while(N>0){
//            if(N%2 != 0){
//                N -= 1;
//                result += 1;
//            }else {
//                N /= 2;
//            }
//        }
//    }
//}

