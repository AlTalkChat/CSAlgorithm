import java.util.*;
class PGMRS_크레인인형뽑기게임 {
    private static int [][] boardGlobal;
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        boardGlobal = board.clone();
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int gr = 0;
        for(int i = 0; i < moves.length; i ++){
            gr = grip(moves[i]);
            if(gr > 0){
                if(!stack.isEmpty() && stack.peek() == gr){
                    answer += 2;
                    stack.pop();
                }else{
                    stack.add(gr);
                }
            }
        }
        return answer;
    }
    private static int grip(int a){
        int result;
        for(int i = 0; i < boardGlobal.length; i++){
            if(boardGlobal[i][a-1] != 0){
                result = boardGlobal[i][a-1];
                boardGlobal[i][a-1] = 0;
                return result;
            }
        }
        return -1;
    }
}