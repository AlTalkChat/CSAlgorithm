import java.util.Arrays;

public class PGMRS_프렌즈4블록 {
    private static int [] dx = {0,0,1,1} , dy = {0,1,1,0};
    private static int m = 5,n = 6, result = 0;
    private static boolean check = false, tempCheck = true;
    private static char [][] map;
    private static boolean [][] exploded;
    private static String [] board = {"AAAAAA", "BBAATB", "BBAATB", "JJJTAA", "JJJTAA"};  // 15
    public static void main(String[] args) {
        map = new char[m][n];
        exploded = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }  // 맵을 구성한다.

        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        int count = 1;
        while (!check){
            System.out.println(count++);
            check = true;
            for (int i = 0; i < m-1; i++) {
                for (int j = 0; j < n-1; j++) {
                    if(map[i][j] != '@' && map[i][j] >='A' && map[i][j] <= 'Z'){
                        find(i,j,map[i][j]);
                    }
                }
            }
            System.out.println(" 맵 적용 전");
            for (int i = 0; i < m; i++) {
                System.out.println(Arrays.toString(exploded[i]));
            }
            collapse();
            System.out.println("맵 적용 후");
            for (int i = 0; i < m; i++) {
                System.out.println(Arrays.toString(map[i]));
            }
            exploded = new boolean[m][n];
            if(check) break;
        }

        System.out.println(result);
    }
    private static void find(int x, int y, char a){
        int nx,ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if(map[nx][ny] != a) return;
        }
        // 여기에 도달했다는건 2 x 2 가 완성되었다.
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if(!exploded[nx][ny]){
                exploded[nx][ny] = true;
                result += 1;
            }
        }
        check = false;
    }

    private static void collapse(){
        int x,y;
        for (int i = m-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if(exploded[i][j] && lineCheck(i,n)){
                    map[i][j] = '@';
                    System.out.println(i +" and j: "+j);
                    x = i;
                    y = j;
                    while(true){
                        x -= 1;
                        if(x >= 0 && map[x][y] != '@' && !exploded[x][y]){
                            System.out.println("change to x: "+ x +" y: "+y);
                            map[i][j] = map[x][y];
                            map[x][y] = '@';
                            exploded[x][y] = true;
                            break;
                        }
                        if(x < 0){
                            break;
                        }
                    }
                }
            }
        }
    }
    private static boolean lineCheck(int i, int n){
        for (int k = 0; k < n; k++) {
            if(map[i][k]>= 'A' && map[i][k] <= 'Z'){
                return true;
            }
        }
        return false;
    }
}
