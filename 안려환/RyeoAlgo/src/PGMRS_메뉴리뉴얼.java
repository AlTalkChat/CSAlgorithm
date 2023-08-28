import java.util.*;

public class PGMRS_메뉴리뉴얼 {
//    private static String [] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};  // "AC", "ACDE", "BCFG", "CDE" 2 3 4
//    private static String [] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}; // "ACD", "AD", "ADE", "CD", "XYZ" 2 3 5
    private static String [] orders = {"XYZ", "XWY", "WXA"}; // "WX", "XY" 2 3 4

//    private static int [] course = {2,3,5};
    private static int [] course = {2,3,4};
    public static void main(String[] args) {
        HashMap<String, List> map = new HashMap<>();
        // 적어도 두 자리부터 되어야 한다.
        for (int i = 0; i < 26; i++) {
            map.put(Character.toString((char)('A'+i)),new ArrayList<Integer>());
        };
        List<Integer> list;
        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < orders[i].length(); j++) {
                list = map.get(Character.toString(orders[i].charAt(j)));
                list.add(i);
                map.put(Character.toString(orders[i].charAt(j)),list);
            }
        }// 입력부 완료
        
        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < ; j++) {
                
            }
        }

    }
}
