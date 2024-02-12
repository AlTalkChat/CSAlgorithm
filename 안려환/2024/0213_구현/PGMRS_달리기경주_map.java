import java.util.*;
class PGMRS_달리기경주_map {
    private static Map<String, Integer> name = new HashMap<>(); // 이름의 등수를 알기 위한 맵
    private static Map<Integer, String> num = new HashMap<>();  // 등수의 이름를 알기 위한 맵
    public String[] solution(String[] players, String[] callings) {
        String [] answer = new String[players.length];
        for(int i = 0; i < players.length; i ++){
            name.put(players[i],i+1);
            num.put(i+1, players[i]);
        }

        int rank;
        String rankName1, rankName2;
        for(int i = 0; i < callings.length; i ++){
            rank = name.get(callings[i]);  // 기존 등수를 가져와
            rankName1 = callings[i];
            rankName2 = num.get(rank - 1);
            name.put(rankName1,rank - 1);
            name.put(rankName2,rank);
            num.put(rank,rankName2);
            num.put(rank - 1, rankName1);
        }

        for(int i = 0; i < players.length; i ++){
            answer[i] = num.get(i+1);
        }
        return answer;
    }
}
