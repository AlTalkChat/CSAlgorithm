import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

// 2 8 4 6 7, 3, 1, 9 -> 한 바퀴를 돌며 확인하기 위해
val dx = listOf(0, 0, -1, 1, -1, 1, -1, 1)
val dy = listOf(-1, 1, 0, 0, 1, -1, -1, 1)
val n = 50
val m = 100
val map = Array(n, { IntArray(m, { 0 }) })
val visited = Array(n, { BooleanArray(m, { false }) })
var original = Array(n, { IntArray(m, { 0 }) })
var isOver = false
var flagCnt = 0



/**
 * 클릭을 하면 연결된 값이 빈 애들이 쫙 다 선택이 되고
 * 그 주위를 둘러싼 숫자들이 드러난다.
 * 이 주위를 둘러쌌다는 것은 빈 값을 기준으로 8방을 전부 오픈한다고 보면 된다.
 * 지뢰의 수는 맵의 칸 수의 15퍼로 한다.
 * **/

/**
 * 1. 맵을 그리는 함수
 *  ㄱ. 먼저 랜덤한 위치에 지뢰들을 뿌려준다.
 * 2. 한 좌표를 선택했을 때 체크할 함수
 * 3. 체크 후 전파될 함수
 * **/
fun main() {
    var mineCnt = (n * m) * 15 / 100  // 15퍼센트 지뢰로 설정
    flagCnt = mineCnt
    for (i in 1..mineCnt) {
        var (x, y) = listOf<Int>(makeRandPos(n), makeRandPos(m))
        while (visited[x][y]) {
            x = makeRandPos(n)
            y = makeRandPos(m)
        }
        map[x][y] = 9
        visited[x][y] = true
        surround(x, y)
    }  // map 성공
    original = map.copyOf()
    visualMap()
    while (!isOver) {
        println("x좌표 y좌표 flag(10)인지 click(11)인지 를 입력하세요")
        println("ex) 3 5 10")
        println("ex) 3 5 11")
        println("둘 수 있는 깃발의 수 ${flagCnt}")
        var inp = readln()
        var st = StringTokenizer(inp)
        var (x, y, type) = listOf<Int>(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt())

        if (flagCnt == 0 && type == 10) {
            println("더이상 깃발 못둡니다. click 하거나 기존 Flag를 변경하십시오")
            continue
        }
        clickMap(x, y, type)
        visualMap()
    }
    if (gameCheck()) {
        println("게임에 승리하였습니다.")
    } else println("지뢰가 터졌습니다....")
}

fun makeRandPos(num: Int): Int {
    return (0 until num).random()
}

fun surround(x: Int, y: Int) {
    var nx = 0
    var ny = 0
    for (i in 0..7) {
        nx = x + dx[i]
        ny = y + dy[i]
        if (nx in 0 until n && ny in 0 until m && !visited[nx][ny]) {
            map[nx][ny] += 1
        }
    }
}

fun clickMap(x: Int, y: Int, type: Int) {  // bfs 돌리면 된다
    when(type){
        10 -> if(map[x][y] == 10){
            map[x][y] = original[x][y]
            visited[x][y] = false
            flagCnt += 1
        }else {
            map[x][y] = 10
            visited[x][y] = true
            flagCnt -= 1
        }
        11 -> if(map[x][y] == 9){
            isOver = true
        }else{
            bfs(x,y)
        }
        else -> println("타입을 10 또는 11만 입력하세요")
    }
}

fun bfs(x:Int,y:Int){
    class Pos(var x: Int,var y: Int)
    var que : Queue<Pos> = LinkedList<Pos>()
    que.add(Pos(x,y))
    while (que.size > 0){
        var po  = que.poll()
        var (nx,ny) = arrayOf(0,0)
        for (i in 0 until 8){
            nx = po.x + dx[i]
            ny = po.y + dy[i]
            if(nx in 0 until n && ny in 0 until m && !visited[nx][ny]){
                visited[nx][ny] = true
                if(map[nx][ny] == 0){
                    que.add(Pos(nx,ny))
                }
            }
        }
    }

}

fun gameCheck(): Boolean {
    var check = false
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!visited[i][j]) {
                check = true
            }
        }
    }
    return if (flagCnt == 0 && !check) true else false
}

fun visualMap() {
    for (i in 0 until n) {
        for (j in 0 until m) {
            if(visited[i][j] && map[i][j] != 9)
                if(map[i][j] == 10){
                    print("^")
                }else print(map[i][j])
            else
                print("*")
        }
        println()
    }
}

//
//전략 설명회 갑니다.
//
//        맵을 그리는 함수를 만들겁니다.
//        그래서 지뢰의 수는 칸의 15퍼로 지정하고 깃발의 수 = 지뢰의 수
//        아무 것도 지정 안되면 0 부터 8까지가 힌트 9 지뢰 10이 깃발
//        그래서 범위가 지정된 랜덤함수를 사용해서 맹글어갈 때 지뢰를 둔 위치에서 8방 탐색을 돌면서 주변을 다 1로 만든다. 지뢰 둘 때마다 8방을 다 1씩 더해줌
//        지뢰의 cnt만큼 돌면서 맵을 그립니다.
//
//        이후 입력을 받음돠 x 와 y를 입력받아
//        입력받은 곳이 지뢰라면? -> 게임 종료
//        지뢰가 아니라면? -> 이제 클릭한 곳의 8방을 전부 확인해서 유효성 검사를 합니다. 이미 0이 드러난 칸인지 -> 방문처리 배열을 가지고 유효성 검사
//        -> false 면 맵의 값이 1이면 게임 종료 0이면 맵 체크해가는 로직을 호출합니다.빈 칸이 눌렸다면 -> 그 빈 칸의 8방을 다 돌면서 방문 처리 안된 애들이면서 0인 애들은 드러냅니다.
//        그래서 숫자가 드러나면 방문처리도 되면서 그 방문처리 된 곳에서는 8방 체크를 하지 않습니다.0이 드러났다면 얘도 방문처리를 합니다.
//        근데 flag라는게 있다. 그럼 거기 지뢰라고 생각한 곳이니까 이제 그 클릭한 곳을 눌렀을 때 8방 체크할 때
//        123
//        456
//        789
//
//
//        bfs 써서 해야할 것 같음................
