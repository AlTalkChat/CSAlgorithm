import java.util.*;
class SoluPGMRS_신고결과받기tion {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer;
        Map<String , Integer> userReportCount = new HashMap<>();
        Map<String , Integer> map = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i ++){
            userReportCount.put(id_list[i],0);
            map.put(id_list[i],i);
        }
        
        String[] temp;
        boolean [][] check = new boolean[id_list.length][id_list.length];
        
        String reporter, bad;
        for(int i = 0; i < report.length; i ++){
            temp = report[i].split(" ");
            reporter = temp[0];
            bad = temp[1];
            if(!check[map.get(reporter)][map.get(bad)]){
                userReportCount.put(bad,userReportCount.get(bad) + 1);
                check[map.get(reporter)][map.get(bad)] = true;
            }
        }
        
        answer = new int[id_list.length];
        for(int i = 0; i < report.length; i ++){
            temp = report[i].split(" ");
            reporter = temp[0];
            bad = temp[1];
            if(userReportCount.get(bad) >= k && check[map.get(reporter)][map.get(bad)]){
                answer[map.get(reporter)] += 1;
                check[map.get(reporter)][map.get(bad)] = false;
            }
        }
        return answer;
    }
}