# 후기
진짜 하루를 다 썼다. 
처음 풀었을 땐 기본 주어진 테스트 케이스만 생각하고 단순한 2차원 방문처리 배열로 풀었더니
35점 나오더라. <br>
다른 모양들 그려가면서 문제를 찾아냈는데 8이랑 + 모양이 문제였다. <br>
결국 생각해낸 답안은 방향을 주는 것이다. 그렇게 하려면 방문처리 배열을 3차원 배열을 활용해야 한다.<br>
그래서 한 쪽으로 갔으면 도착점에서 출발점으로 가는 그니까 1 -> 2 로 이동이면 2 -> 1 도 같이 방문처리를 해줘야하는 것이다.

# 코드
```
public class PGMRS_방문길이 {
    public static void main(String[] args) {
//        String dirs = "ULURRDLLU";  // 7
//        String dirs = "ULLLLLLLLLLLLLLLLLU";  // 7

//        String dirs = "ULDRDLURULDDURLL"; // 8 나와야 한다.
        String dirs = "RLUDLRDU";  // 4
        char [] moves = new char[dirs.length()];
        for (int i = 0; i < dirs.length(); i++) {
            moves[i] = dirs.charAt(i);
        }
        bfs bfs = new bfs();
        System.out.println(bfs.bfs(moves));
    }
}
class bfs{  // 나는 그래프 이동이면 무조건 bfs라 부르고 본다. 고치겠다 다음엔 
    int [] dx = {0,0,-1,1};
    int [] dy = {-1,1,0,0};
    int count = 0;
    boolean [][][] visited = new boolean[11][11][4];  // 3차원 배열을 활용해서 양쪽 방향에 전부 방문처리를 해간다.

    class Pos{
        int x;
        int y;
        private Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int bfs(char[] moves){
        int dir = 0;
        Pos po = new Pos(5,5);
        for (int i = 0; i < moves.length; i++) {
            switch (moves[i]){
                case 'L':
                    System.out.println("L");
                    dir = 2;
                    if(check(dir,po)){
                        couldCount(dir,po);
                        moves(dir,po);
                    }
                    break;
                case 'U':
                    System.out.println("U");
                    dir = 0;
                    if(check(dir,po)){
                        couldCount(dir,po);
                        moves(dir,po);
                    }
                    break;
                case 'R':
                    System.out.println("R");
                    dir = 3;
                    if(check(dir,po)){
                        couldCount(dir,po);
                        moves(dir,po);
                    }
                    break;
                case 'D':
                    System.out.println("D");
                    dir = 1;
                    if(check(dir,po)){
                        couldCount(dir,po);
                        moves(dir,po);
                    }
                    break;
                default:
                    System.out.println("Invalid Character");
                    break;
            }
        }
        return count;
    }
    public void moves(int dir, Pos po){  // 이동 메소드
        visited[po.y][po.x][dir] = true;
        po.x = po.x + dx[dir];
        po.y = po.y + dy[dir];
        switch (dir){  // 이 부분이 이제 내가 말한 반대 방향도 방문처리하는 것이다.
            case 0:
                visited[po.y][po.x][1] = true;
                break;
            case 1:
                visited[po.y][po.x][0] = true;
                break;
            case 2:
                visited[po.y][po.x][3] = true;
                break;
            case 3:
                visited[po.y][po.x][2] = true;
                break;
            default:
                break;
        }
    }
    public boolean check(int dir,Pos po){  // 이동 가능한지 확인하는 메소드
        if(po.x + dx[dir] < 0 || po.x + dx[dir] > 10 || po.y + dy[dir] < 0 || po.y+dy[dir] > 10){
            return false;
        }
        System.out.println("current: "+ visited[po.y][po.x][dir]);
        System.out.println("current pos.y: "+(po.y + dy[dir])+" current pos.x: "+(po.x + dx[dir])+ " now count: "+count);
        return true;
    }
    public void couldCount(int dir,Pos po){  // 움직일 수 있는지 확인하는 메소드
        if(!visited[po.y][po.x][dir]){
            count++;
            System.out.println("-----------count up!!!---------");
        }
    }
}


```

# 신경 쓴점
- AOP 를 활용해 최대한 중복되는 기능은 재사용할 수 있게 메소드로 분리하였다. main 에서는 입력과 호출만, class에 로직을 넣는다.
- 무조건 static으로 선언하는게 아니라 class 로 빼내서 호출하는 방식으로 썼다.


