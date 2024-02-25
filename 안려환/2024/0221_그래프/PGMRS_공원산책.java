import java.util.*;
class PGMRS_공원산책 {
    private static int [] dx = {-1,1,0,0};
    private static int [] dy = {0,0,-1,1};
    private static Character [][] map;
    private static boolean [][] visited;
    private static class Pos{
        int x;
        int y;
        private Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[] solution(String[] park, String[] routes) {
        map = new Character[park.length][park[0].length()];
        visited = new boolean[park.length][park[0].length()];
        String temp;
        Pos start = new Pos(0,0);
        for(int i = 0; i < park.length; i ++){
            temp = park[i];
            for(int j = 0; j < park[0].length(); j ++){
                map[i][j] = temp.charAt(j);
                if(map[i][j].equals('S')){
                    start = new Pos(i,j);
                }
                if(map[i][j].equals('X')){
                    visited[i][j] = true;
                }
            }
        }
        StringTokenizer st;
        int move, nx,ny;
        boolean tempCheck;
        for(int i = 0; i < routes.length; i ++){
            st = new StringTokenizer(routes[i]);
            nx = start.x;
            ny = start.y;
            tempCheck = true;
            switch(st.nextToken()){
                case "N" :
                    move = Integer.parseInt(st.nextToken());
                    for(int j = 0; j < move; j++){
                        nx += dx[0];
                        ny += dy[0];
                        if(!check(nx,ny)) tempCheck = false;
                    }
                    if(tempCheck){
                        start = new Pos(nx,ny);
                    }
                    break;
                case "S":
                    move = Integer.parseInt(st.nextToken());
                    for(int j = 0; j < move; j++){
                        nx += dx[1];
                        ny += dy[1];
                        if(!check(nx,ny)) tempCheck = false;
                    }
                    if(tempCheck){
                        start = new Pos(nx,ny);
                    }
                    break;
                case "W":
                    move = Integer.parseInt(st.nextToken());
                    for(int j = 0; j < move; j++){
                        nx += dx[2];
                        ny += dy[2];
                        if(!check(nx,ny)) tempCheck = false;
                    }
                    if(tempCheck){
                        start = new Pos(nx,ny);
                    }
                    break;
                case "E":
                    move = Integer.parseInt(st.nextToken());
                    for(int j = 0; j < move; j++){
                        nx += dx[3];
                        ny += dy[3];
                        if(!check(nx,ny)) tempCheck = false;
                    }
                    if(tempCheck){
                        start = new Pos(nx,ny);
                    }
                    break;
            }
        }
        int[] answer = {start.x, start.y};
        return answer;
    }

    private static boolean check(int x, int y){
        if(x >= 0 && x < map.length && y >= 0 && y < map[0].length && !visited[x][y]){
            return true;
        }else{
            return false;
        }
    }
}