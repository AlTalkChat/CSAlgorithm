# 후기
평범한 순열 문제였다. <br>
내가 헷갈렸던거는 ++ 와 +1 의 차이때문이었다. <br>
다시 공부해야겠다. <br>

## 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/87946

# 코드
```
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PGMRS_피로도 {
    public static void main(String[] args) {
        int k = 80;
        int [][] dungeons = {{80,80},{50,40},{30,10}};
        boolean [] visited = new boolean[dungeons.length];
        List<int []> list = new ArrayList<>();
        for (int [] a: dungeons) {
            list.add(a);
        }
        status status = new status();
        status.status(k,list,visited,0);
        System.out.println(status.result);
    }
}

class status{
    public int result = 0;
    public void status(int k , List<int[]> dungeons,boolean [] visited,int count){
        if(k<=0){
            System.out.println("작아졌니");
            result = Math.max(result,count);
            return;
        }
        if(!check(k,dungeons,visited)){
            System.out.println("visited: "+ Arrays.toString(visited));
            System.out.println("현재 count : "+count);
            result = Math.max(result,count);
            System.out.println("현재 result : "+result);
            return;
        }
        System.out.println("count : "+count);
        for (int i = 0; i < dungeons.size(); i++) {
            if(dungeons.get(i)[0] <= k && !visited[i]){
                visited[i] = true;
                status(k-dungeons.get(i)[1],dungeons,visited,count+1);
                visited[i] = false;
            }
        }

    }

    public boolean check(int k, List<int[]> list,boolean [] visited){
        for (int i = 0; i < list.size(); i++) {
            if(!visited[i] && list.get(i)[0]<=k){
                System.out.println("k: "+k+" list[0]: "+list.get(i)[0]+" list[1]: "+list.get(i)[1]+" 가능");
                return true;
            }
        }
        return false;

    }

}

```

