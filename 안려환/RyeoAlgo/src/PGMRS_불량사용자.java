public class PGMRS_불량사용자 {
    private static String [] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"}, banned_id = {"fr*d*", "abc1**"}; // 2
//    private static String [] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"}, banned_id = {"*rodo", "*rodo", "******"}; // 2
//    private static String [] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"}, banned_id = {"fr*d*", "*rodo", "******", "******"}; // 3
    private static boolean [] visited;
    public static void main(String[] args) {
        boolean tempCheck = false;
        visited = new boolean[user_id.length];
        for (int i = 0; i < banned_id.length; i++) {
            for (int j = 0; j < user_id.length; j++) {
                if (banned_id[i].length() == user_id[j].length() && !visited[j]) {
                    for (int k = 0; k < user_id.length; k++) {
                        if(banned_id[i].charAt(k) != user_id[j].charAt(k) && user_id[j].charAt(k) == '*'){
                            tempCheck  = true;
                        }else {
                            tempCheck = false;
                            break;
                        }
                    }
                }
                if(tempCheck) visited[j] = true;
            }
        }

    }

    private static void dfs(){

    }
}
