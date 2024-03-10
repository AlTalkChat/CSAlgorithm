import java.util.*;
class PGMRS_가장많이받은선물 {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int [][] check = new int [friends.length][friends.length];
        boolean [][] isChecked = new boolean[friends.length][friends.length];
        int [] result = new int [friends.length];
        Map<String, Integer>map = new HashMap<>();

        int [] tempArr = new int[friends.length];
        for(int i = 0; i < friends.length; i ++){
            map.put(friends[i], i);
        }
        StringTokenizer a;
        String from,to;
        int fromInd, toInd;
        for(int i = 0; i < gifts.length; i ++){
            a = new StringTokenizer(gifts[i]);
            from = a.nextToken();
            to = a.nextToken();
            fromInd = map.get(from);
            toInd = map.get(to);

            check[fromInd][fromInd] += 1;
            check[fromInd][toInd] += 1;
            check[toInd][fromInd] -= 1;
            check[toInd][toInd] -= 1;
        }

        for(int i = 0; i < friends.length; i ++){
            for(int j = 0; j < friends.length; j ++){
                if(i != j && !isChecked[i][j]){
                    if(check[i][j] > 0){
                        result[i] += 1;
                    }else if(check[i][j] == 0){
                        if(check[i][i] < check[j][j]){
                            result[j] += 1;
                        }
                        if(check[i][i] > check[j][j]){
                            result[i] += 1;
                        }
                    }else{
                        result[j] += 1;
                    }
                    isChecked[i][j] = true;
                    isChecked[j][i] = true;
                }
            }
        }

        Arrays.sort(result);
        return result[result.length-1];
    }
}
