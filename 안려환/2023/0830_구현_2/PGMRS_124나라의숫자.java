public class PGMRS_124나라의숫자 {
//    private static int n = 1;	//1
//    private static int n = 2;	//2
//    private static int n = 3;	//4
    private static int n = 29;	//11
    public static void main(String[] args) {
        String[] numbers = {"4", "1", "2"}; // 0일 때 4
        String answer = "";
        int temp;
        while (n>0){
            temp = n % 3;
            n /= 3;
            if(temp == 0) n--;
            answer = numbers[temp] + answer;
        }
        System.out.println(answer);
    }

}

