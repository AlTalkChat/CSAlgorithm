public class PGMRS_2개이하로다른비트 {
    private static long [] numbers = {2,7};  // 3, 11
    public static void main(String[] args) {
        String a;
        long b;
        for (int i = 0; i < numbers.length; i++) {
            a = Long.toBinaryString(numbers[i]);
            // 1000 이면 1001 이 답이고
            b = Long.parseLong(a);
            System.out.println(b);
        }
    }
}
