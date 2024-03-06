class PGMRS_문자열나누기 {
    public int solution(String s) {
        int answer = 0, cnt = 1, cnt2 = 0, ind = 0;
        char x;
        while(ind < s.length()){
            cnt = 1;
            cnt2 = 0;
            x = s.charAt(ind);
            ind += 1;
            while(ind < s.length() && cnt != cnt2){
                while(ind < s.length() && x == s.charAt(ind)){
                    cnt += 1;
                    ind += 1;
                    if(cnt == cnt2){
                        break;
                    }
                }
                
                while(ind < s.length() && x != s.charAt(ind)){
                    cnt2 += 1;
                    ind += 1;
                    
                    if(cnt == cnt2){
                        break;
                    }
                }
            }
            answer += 1;
        }
        return answer;
    }
}