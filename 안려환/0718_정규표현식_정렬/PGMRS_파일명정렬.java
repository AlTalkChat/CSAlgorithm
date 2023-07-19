import java.util.Arrays;
import java.util.Comparator;

public class PGMRS_파일명정렬 {
    public static void main(String[] args) {
        String[] files = {"A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"};
        // 전처리해야할 것들. -> 띄어쓰기 다 없애고 전부 upper 등으로 바꾼다. 그리고 알파벳순으로 정렬 -> switch 활용해서 바꿔
        // 파일명 제거
//        String[] nufiles = files.clone();
//
//        for (int i = 0; i < files.length; i++) {
//            nufiles[i] = nufiles[i].replace(" ", "");
//            nufiles[i] = nufiles[i].replace("-", "");
//            if (nufiles[i].split(".").length > 0) {
//                nufiles[i] = nufiles[i].split(".")[0];
//            }
//            nufiles[i] = nufiles[i].toUpperCase();
//        }
//        Arrays.sort(nufiles);
//
//        for (int i = 0; i < nufiles.length; i++) {
//            int index = 0;
//            while (index < nufiles[i].length()) {
//                if (nufiles[i].charAt(index) >= 'A' || nufiles[i].charAt(index) <= 'Z') {
//                    index++;
////                try {  // 오늘의 미친 생각
////                    int temp = Integer.parseInt(nufiles[i].charAt(index)+"");
////                    System.out.println(temp);
////                    nufiles[i] = nufiles[i].substring(i);
////                    break;
////                } catch(Exception e){
////                    System.out.println("hi");
////                    index++;
////                }
//                }
//            }
//            System.out.println(Arrays.toString(nufiles));
//        }
        // 위 코드의 문제점 -> 다른 배열을 하나 더 만들어서 진행했기 때문에 순서를 기억해야 한다. -> 그래서 비교할 때 대문자로 바꿔서 비교를 해주는 식으로 진행하면 된다.

        Arrays.sort(files, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String head1 = s1.split("[0-9]")[0];
                String head2 = s2.split("[0-9]")[0];
                s1 = s1.replace(head1, "");
                s2 = s2.replace(head2, "");

                head1 = head1.toUpperCase();
                head2 = head2.toUpperCase();  // 잘라서 대문자들로 바꿔서 보관한다.

                // compareTo 비교해서 -1 , 0 , 1 로 나눠준다.
                int headCompareValue = head1.compareTo(head2);
                if (headCompareValue == 0) {

                    // head정렬 값이 같으므로 number로 정렬
                    String num1 = "";
                    for (char c : s1.toCharArray()) {  // 숫자 나오는 만큼 담는다.
                        if (!(c >= '0' && c <= '9')) break;
                        num1 += c;
                    }
                    String num2 = "";
                    for (char c : s2.toCharArray()) {
                        if (!(c >= '0' && c <= '9')) break;
                        num2 += c;
                    }
                    return (Integer.parseInt(num1) - Integer.parseInt(num2));  // 오름차순으로 정렬
                } else {
                    return headCompareValue;  // 헤드부분이 다르면 그거에 맞게 정렬해준다.
                }
            }
        });
        System.out.println(Arrays.toString(files));

    }
}
