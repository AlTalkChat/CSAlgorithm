# 후기
복잡한 구현 문제.. <br>
나는 어떻게 풀었냐면 전략은 시계방향으로 돌면서 같은 문자인지 확인해서 터질 블록을 count 하는 식으로 찾고 블록을 내리는 것은 터질 블럭은 @ 로 바꿔줘서 아래부터 탐색을 한다. <br>
 @ 인 블럭(터질 블럭)을 만나면 그 위로 올라가면서 터지지 않은 블럭을 찾아 map의 값만 변경하는게 아니라 터짐 처리도 바꿔줬어야 했는데 안해줘서 틀렸었다... <br>
 나 이거 11점이나 받았숴ㅎㅎㅎ

# 결과
<img width="264" alt="image" src="https://github.com/Ryeohwan/TRL/assets/73810834/6dd5b7a4-c969-41ec-b9a7-317700ef1cc4">

# 링크
https://school.programmers.co.kr/learn/courses/30/lessons/17679#qna

# 코드
```
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

```