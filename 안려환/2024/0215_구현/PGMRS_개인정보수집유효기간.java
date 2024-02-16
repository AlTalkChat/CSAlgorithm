import java.util.*;
class PGMRS_개인정보수집유효기간 {
    static class DateO{
        int year;
        int month;
        int day;
        private DateO(int year, int month, int day){
            this.year = year;
            this.month = month;
            this.day = day;
        }

        private static boolean isBefore(DateO today, DateO date){
            if(today.year < date.year){
                return true;
            }else if(today.year == date.year){
                if(today.month < date.month){
                    return true;
                }else if(today.month == date.month){
                    if(today.day < date.day){
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            } else{
                return false;
            }
        }
    }
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        String[] temp;
        int year, month, day;

        temp = today.split("\\.");

        year = Integer.parseInt(temp[0]);
        month = Integer.parseInt(temp[1]);
        day = Integer.parseInt(temp[2]);
        DateO ttoday = new DateO(year,month,day);

        Map<String,Integer> termsMap = new HashMap<>();
        for(int i = 0; i < terms.length; i++){
            temp = terms[i].split(" ");
            termsMap.put(temp[0], Integer.parseInt(temp[1]));
        }

        String [] ddate;
        int tempY, tempM, tempD;
        for(int i = 0; i < privacies.length; i++){
            temp = privacies[i].split(" ");
            ddate = temp[0].split("\\.");
            tempY = Integer.parseInt(ddate[0]);
            tempM = Integer.parseInt(ddate[1]);
            tempD = Integer.parseInt(ddate[2]);
            DateO date = new DateO(tempY,tempM,tempD);

            if(!dayCalc(date,termsMap.get(temp[1]), ttoday)){
                list.add(i + 1);
            }
        }
        answer = new int[list.size()];
        for(int i = 0; i < answer.length; i ++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    private static boolean dayCalc(DateO date, int plus, DateO today){
        int year = date.year;
        int month = date.month;
        int day = date.day;
        int temp = month + plus;
        while(temp > 12){
            temp -= 12;
            year += 1;
        }
        DateO date1 = new DateO(year, temp, day);
        if(DateO.isBefore(today,date1)){  // 아직 파기 ㄴㄴ
            return true;
        }else return false;
    }
}
