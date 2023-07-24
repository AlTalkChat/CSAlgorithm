import java.util.*;

public class PGMRS_뒤에있는큰수찾기 {
    public static void main(String[] args) {
        int[] s = {2, 3, 3, 5};
        int[] sClone = s.clone();
        Arrays.sort(sClone);
        for (int i = 1; i < s.length; i++) {
            if (s[i] == sClone[sClone.length - 1]) {
                s[i] = -1;
            } else {
                s[i] = find(s, i);
            }
        }
        System.out.println(Arrays.toString(s));
    }

    private static int find(int[] arr, int a) {
        Arrays.sort(arr);
        for (int i = a + 1; i < arr.length; i++) {
            if (arr[i] > arr[a]) {
                return arr[i];
            }
        }
        return -1;
    }



}
