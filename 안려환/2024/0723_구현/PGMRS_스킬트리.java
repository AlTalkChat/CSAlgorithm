import java.util.*;
class PGMRS_스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Set<Character> set = new HashSet();
        for(int i = 0; i < skill.length(); i++){
            set.add(skill.charAt(i));
        }
        boolean [] visited;
        StringBuilder sb;
        Boolean check;
        int ind;
        for(int i = 0; i < skill_trees.length; i ++){
            ind = 0;
            sb = new StringBuilder();
            check = true;
            sb.append(skill_trees[i]);
            visited = new boolean[skill.length()]; // 초기화
            for(int j = 0; j < sb.length(); j ++){
                if(set.contains(sb.charAt(j))){
                    // 내 skill 에서 몇 번째 글자인지 확인해서
                    // 그 위치의 글자가 현재 올바른 순서로 스킬을 배우고 있는지 확인하면 된다.
                    // 여기서 올바른 위치란 선행 스킬의 조건이 true 인 상황을 말한다.
                    // 올바르지 않은 위치에 있다면 전체가 false
                    for(int k = 0; k < visited.length; k ++){
                        if(!visited[k]){
                            ind = k;
                            break;
                        }
                    }

                    if(sb.charAt(j) != skill.charAt(ind)){
                        visited = new boolean[skill.length()];
                        check = false;
                        break;
                    }else{
                        visited[ind] = true;
                    }
                }
            }
            if(check){
                answer += 1;
            }
        }
        return answer;
    }

}