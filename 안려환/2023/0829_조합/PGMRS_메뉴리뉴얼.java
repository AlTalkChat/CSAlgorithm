import java.util.*;

public class PGMRS_메뉴리뉴얼 {
//    private static String [] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};  // "AC", "ACDE", "BCFG", "CDE" 2 3 4
//    private static String [] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}; // "ACD", "AD", "ADE", "CD", "XYZ" 2 3 5
    private static String [] orders = {"XYZ", "XWY", "WXA"}; // "WX", "XY" 2 3 4

//    private static int [] course = {2,3,5};
    private static int [] course = {2,3,4};
    private static HashMap<String, Integer> map = new HashMap<>();
    private static List<String> answerList = new ArrayList<>();
    public static void main(String[] args) {
        // 1. 각 Order 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        // 2. 각 order를 기준으로 courseLength 만큼의 조합 만들기
        for (int courseLength : course) {
            for (String order : orders)
                combination("", order, courseLength);

            // 3. 가장 많은 조합 answer에 저장
            if (!map.isEmpty()) {
                List<Integer> countList = new ArrayList<>(map.values());
                int max = Collections.max(countList);  // 최대값 찾기 Collections.max 조와쒀

                if (max > 1)
                    for (String key : map.keySet())
                        if (map.get(key) == max)
                            answerList.add(key);
                map.clear();
            }
        }

        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = answerList.get(i);

        System.out.println(Arrays.toString(answer));
    }

    private static void combination(String order, String others, int count) {
        // 탈출 조건 : count == 0
        if (count == 0) {
            map.put(order, map.getOrDefault(order, 0) + 1);
            return;
        }
        // 0부터 length까지 조합
        for (int i = 0; i < others.length(); i++)
            combination(order + others.charAt(i), others.substring(i + 1), count - 1);
    }
}
