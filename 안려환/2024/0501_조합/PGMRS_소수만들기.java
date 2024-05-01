public class PGMRS_소수만들기 {
    private static int answer = 0;
    public int solution(int[] nums) {
        boolean[] checker = new boolean[nums.length];
        comb(nums, checker, 0,0);
        return answer;
    }
    private void comb(int[] nums, boolean[] checker, int start, int count){
        if(count == 3) {
            int temp = 0;
            for(int i = 0; i < nums.length; i++){
                if(checker[i]){
                    temp += nums[i];
                }
            }

            if(isPrio(temp)) answer += 1;
            return;
        }
        for(int i = start; i < nums.length; i++){
            checker[i] = true;
            comb(nums, checker, i + 1, count + 1);
            checker[i] = false;
        }
        return;
    }
    private boolean isPrio(int a){
        for(int i = 2; i < a; i ++){
            if(a % i == 0) return false;
        }
        return true;
    }
}
