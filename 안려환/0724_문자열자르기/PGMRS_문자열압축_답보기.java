public class PGMRS_문자열압축_답보기 {
    /**
     * 문자를 2 개 단위로 보기 abcabcdede ab ca bc de de -> abcabc2de
     * 문자를 2 개 단위로 보기 abcabcdede abc abc ded e -> 2abcdede
     * 아놔 문제 잘못이해했다리
     * 2abc2de 되는줄알고 죽을만큼 머리썼는데
     **/
    public static void main(String[] args) {
        String s = "ababaab";
        int answer = s.length();    // 압축하기 전 문자열 길이로 초기화

        for(int i = 1; i <= s.length() / 2; i++){
            int zipLevel = 1;                           // 현재 압축정도
            String zipStr = s.substring(0, i);          // 압축할 문자  2면 2개씩 3이면 3개씩
            StringBuilder result = new StringBuilder(); // 압축완료한 문자를 저장할 StringBuilder

            for(int j = i; j <= s.length(); j += i){
                // 다음 문자 추출
                String next = s.substring(j, j + i > s.length() ? s.length() : i + j);  // 2,3,4 이런식으로 길게 갈 것이니까 계속 그만큼 잘라서 확인

                // 다음 문자와 현재 문자가 같으면 zipLevel증가
                if(zipStr.equals(next)) {
                    zipLevel++;
                }
                // 다음 문자와 현재 문자가 다를 경우 -> 자르기 끝남
                else{
                    // (압축이 안되었을 경우는 공백, 압축이 되었을경우 zipLevel을 붙여줌) + 압축할 문자를 넣어줌,
                    result.append((zipLevel != 1 ? zipLevel : "") + zipStr);
                    zipStr = next;      // 다음 문자를 압축할 문자로 지정
                    zipLevel = 1;       // 압축 정도 1로 초기화
                }
            }
            result.append(zipStr);      // 마지막에 추가안된 zipStr추가
            answer = Math.min(answer, result.length()); // 가장 작은 문자열 길이 저장  2개 3개로 나눠보면서 제일 작은 값을 찾아감
        }

        System.out.println(answer);
    }
}


