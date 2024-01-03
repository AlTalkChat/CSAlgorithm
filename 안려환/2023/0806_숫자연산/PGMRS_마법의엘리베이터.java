import java.util.Arrays;

public class PGMRS_마법의엘리베이터 {
    private static int result;
    private static int [] arr;
    // 16 6
    // 2554 16
    public static void main(String[] args) {
        // 이제 다 main에 로직 넣어서 돌려
        int storey = 6995;
        String inp = storey + "";
        arr = new int[inp.length()];
        for (int i = 0; i < inp.length(); i++) {
            arr[i] = inp.charAt(i) -'0';
        }
        for(int i = arr.length-1; i >= 0; i--) {
            if(arr[i] > 5) {
                result += 10 - arr[i];
                if(i==0) result += 1;  // 그니까 제일 앞 자리면 올려준다.
                else arr[i-1] += 1;  // 아니면 그 다음 자리 올려준다.
                System.out.println(Arrays.toString(arr));
            }
            else if(arr[i] == 5 && i > 0 && arr[i-1] >= 5) {  // 지금 5면서 맨 앞자리 아니고 그 다음 숫자가 5보다 크면
                arr[i-1] += 1;  // 그 다음 수 1올려주고
                result += 5;  // 5는 어떻게 연산하든 5 더해지게 되는거 알지
                System.out.println(Arrays.toString(arr));
            }
            else {
                result += arr[i]; // 5보다 작거나 그 다음 수가 5보다 작아서 다른 영향주는게 안좋을 경우 그냥 더해주고 만다.
                System.out.println(Arrays.toString(arr));
            }

        }

        System.out.println(result);
    }

}
