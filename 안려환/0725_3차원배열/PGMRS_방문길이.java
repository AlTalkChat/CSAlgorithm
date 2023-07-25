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
class bfs{
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
        switch (dir){
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

