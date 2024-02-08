import java.util.*;

class PFMRS_키패드누르기 {
    private static int [] dx = {0,0,-1,1};
    private static int [] dy = {-1,1,0,0};
    private static Map<Integer, Pos> phone = new HashMap<>();
    private static int [][] map = new int [4][3];
    private static int left,right;
    static class Pos{
        int x;
        int y;
        public Pos( int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int num = 1;
        for(int i = 0; i < 3; i ++) {
            for(int j = 0; j < 3; j ++){
                phone.put(num,new Pos(i,j));
                num ++;
            }
        }
        phone.put(10,new Pos(3,0));  // *
        phone.put(11,new Pos(3,1));  // 0
        phone.put(12,new Pos(3,2));  // #
        int current = 0;
        left = 10;
        right = 12;
        boolean check = false;
        for(int i = 0; i < numbers.length; i ++){
            check = false;
            switch(numbers[i]){
                case 1:
                    left = 1;
                    answer.append("L");
                    check = true;
                    break;
                case 2:
                    current = 2;
                    break;
                case 3:
                    right = 3;
                    answer.append("R");
                    check = true;
                    break;
                case 4:
                    left = 4;
                    answer.append("L");
                    check = true;
                    break;
                case 5:
                    current = 5;
                    break;
                case 6:
                    right = 6;
                    answer.append("R");
                    check = true;
                    break;
                case 7:
                    left = 7;
                    answer.append("L");
                    check = true;
                    break;
                case 8:
                    current = 8;
                    break;
                case 9:
                    right = 9;
                    answer.append("R");
                    check = true;
                    break;
                case 0:
                    current = 11;
                    break;
            }

            if(check){
                continue;
            }
            answer.append(distance(current,hand));
        }
        return answer.toString();
    }

    private static String distance(int num, String hand){
        // 동일하니
        if(num == left){
            left = num;
            return "L";
        }
        if(num == right){
            right = num;
            return "R";
        }
        // 둘 다 먼데 가까운거 찾기
        // 00 01 02
        // 10 11 12
        // 20 21 22
        int dis = 0 , LDis = 0, RDis = 0;
        LDis = Math.abs(phone.get(num).x - phone.get(left).x) +  Math.abs(phone.get(num).y - phone.get(left).y);
        RDis = Math.abs(phone.get(num).x - phone.get(right).x) +  Math.abs(phone.get(num).y - phone.get(right).y);
        if(LDis > RDis){ // 왼쪽이 더 멀다.
            right = num;
            return "R";
        }else if(LDis < RDis){  // 오른쪽이 더 멀다.
            left = num;
            return "L";
        }else{  // 동일하다.
            if(hand.equals("right")){
                right = num;
                return "R";
            }
            else {
                left = num;
                return "L";
            }
        }
    }
}