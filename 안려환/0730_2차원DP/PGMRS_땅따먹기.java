public class PGMRS_땅따먹기 {
    public static void main(String[] args) {
        int [][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
//        int [][] land = {{1,2,3,5},{5,6,7,8}};
        LandGame landGame = new LandGame();
        boolean [][] visited = new boolean[land.length][4];
        landGame.DpPlay(land);
        System.out.println(landGame.mapMax);
    }
}

class LandGame{
    public int mapMax = 0;
    public void GreedyPlay(int [][] land,boolean [][] visited, int index, int count){  // 시초엔딩
        if(index == land.length-1){
            mapMax = Math.max(count,mapMax);
            return;
        }

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                if(!visited[i][j]){
                    if(i<land.length-1){
                        visited[i][j] = true;
                        visited[i+1][j] = true;
                        GreedyPlay(land,visited,index+1,count+land[i][j]);
                        visited[i][j] = false;
                        visited[i+1][j] = false;
                    }else {
                        visited[i][j] = true;
                        GreedyPlay(land,visited,index+1,count+land[i][j]);
                        visited[i][j] = false;
                    }
                }
            }
        }
    }

    public void DpPlay(int [][] land){
        int [][] dp = new int [land.length][4];
        for (int i = 0; i < 4; i++) {  // 0은 land 와 맞춰준다.
            dp[0][i] = land[0][i];
        }
        for (int i = 1; i < land.length; i++) { // 그 다음부터는 dp 를 채워간다.
            for (int j = 0; j < 4; j++) {
                dp[i][j] = fillingDp(dp,i,j)+land[i][j];
            }
        }
        mapMax = fillingDp(dp,land.length,-1); // 마지막 줄의 최댓값을 알기 위함이다.
    }

    private int fillingDp(int [][] dp , int i, int j){  // dp의 각 위치에서의 최대값을 담기 위한 메소드
        int result = 0;
        for (int k = 0; k < 4; k++) {
            if(k != j){
                result = result < dp[i-1][k] ? dp[i-1][k] : result;
            }
        }
        return result;
    }
}
