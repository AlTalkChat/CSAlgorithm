class PGMRS_달리기경주_swap_시간초과 {
    public String[] solution(String[] players, String[] callings) {
        String temp;
        class Pos{
            String name;
            int num;
            private Pos(String name, int num){
                this.name = name;
                this.num = num;
            }
        }
        Pos cache = new Pos("who",0);
        for(int i = 0; i < callings.length; i ++){
            if(cache.name.equals(callings[i])){
                temp = players[cache.num - 1];
                players[cache.num - 1] = players[cache.num];
                players[cache.num] = temp;
                cache = new Pos(cache.name,cache.num - 1);
                continue;
            }
            for(int j = 0; j < players.length; j ++){
                if(players[j].equals(callings[i])){
                    cache = new Pos(callings[i],j - 1);
                    temp = players[j - 1];
                    players[j - 1] = players[j];
                    players[j] = temp;
                    break;
                }
            }
        }
        return players;
    }
}
