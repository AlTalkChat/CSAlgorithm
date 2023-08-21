public class PGMRS_2개이하로다른비트 {
    private static long [] numbers = {2,7};  // 3, 11
    public static void main(String[] args) {
        String a;
        long b;
        // 보니까 이게 앞에 하나를 추가하거나 아니면 맨 뒤에 추가하거나 하는 식드로 하면 될 것 같은디
        // 10 100 11 둘 중에서 2 이하로 다르면서 작은건 11 아닌감
        // 그리고 111 에서 1111 아니면 1000 인데 그냥 1111 이 답 아닌감 1011
        for (int i = 0; i < numbers.length; i++) {
            a = Long.toBinaryString(numbers[i]);
            // 1000 이면 1001 이 답이고
            b = Long.parseLong(a);
            System.out.println(b);
        }
    }
}
