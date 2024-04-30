public class PGMRS_옹알이_2 {
    public int solution(String[] babbling) {
        int answer = 0;
        String before;
        boolean check;
        for(String a : babbling){
            before = "";
            check = true;
            for(int i = 0; i < a.length(); i++){
                if(check){
                    switch(a.charAt(i)){
                        case 'a':
                            if(i + 1 < a.length() && a.charAt(i + 1) == 'y' && i + 2 < a.length() && a.charAt(i+2) == 'a'){
                                if(before != "aya"){
                                    before = "aya";
                                }else{
                                    check = false;
                                }
                                i += 2;
                                continue;
                            }else{
                                check = false;
                            }
                            break;
                        case 'y':
                            if(i + 1 < a.length() && a.charAt(i + 1) == 'e'){
                                if(before != "ye"){
                                    before = "ye";
                                }else{
                                    check = false;
                                }
                                i += 1;
                                continue;
                            }else{
                                check = false;
                            }
                            break;
                        case 'w':
                            if(i + 1 < a.length() && a.charAt(i + 1) == 'o' && i + 2 < a.length() && a.charAt(i + 2) == 'o'){
                                if(before != "woo"){
                                    before = "woo";
                                }else{
                                    check = false;
                                }
                                i += 2;
                                continue;
                            }else{
                                check = false;
                            }
                            break;
                        case 'm':
                            if(i + 1 < a.length() && a.charAt(i+1) == 'a'){
                                if(before != "ma"){
                                    before = "ma";
                                }else{
                                    check = false;
                                }
                                i += 1;
                                continue;
                            }else{
                                check = false;
                            }
                            break;
                        default:
                            check = false;
                            break;
                    }
                }
            }
            before = "";
            if(check){
                answer += 1;
            }
        }
        return answer;
    }
}
