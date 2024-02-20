import java.util.*;
class PGMRS_바탕화면정리 {
    private static char [][] map;
    public int[] solution(String[] wallpaper) {
        String temp;
        map = new char[wallpaper.length][wallpaper[0].length()];
        int top = Integer.MAX_VALUE,left = Integer.MAX_VALUE, right = 0, down = 0;
        for(int i = 0; i < wallpaper.length; i ++){
            temp = wallpaper[i];
            for(int j = 0; j < wallpaper[0].length(); j ++){
                map[i][j] = temp.charAt(j);
                if(map[i][j] != '.'){
                    top = Math.min(i,top);
                    left = Math.min(j,left);
                    right = Math.max(j,right);
                    down = Math.max(i,down);
                }
            }
        }
        right += 1;
        down += 1;
        int[] answer = {top,left,down,right};
        return answer;
    }
}
