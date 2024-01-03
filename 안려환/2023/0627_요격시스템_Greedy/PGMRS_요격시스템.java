import java.util.Arrays;

public class PGMRS_요격시스템 {  // 그리디 문제 (회의실 배정도 풀어보기) 끝나기 전에만 터뜨리면 된다고 생각해보자.
    public static void main(String[] args) {
        int [][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};

        Arrays.sort(targets,(o1,o2) -> {  // 끝나는 시간으로 정렬하는 것이 키
            return o1[1] - o2[1];  // 그래야 1,15 2,3 4,5 6,7 의 문제 해결 가능
        });

        int count = 1;
        int end = targets[0][1];
        for (int i = 1; i < targets.length; i++) {
            if(end <= targets[i][0]){  // 끝나는 수가 다음 시작하는 수보다 작을 경우에만 카운트가 증가하지 않게...
                count++;  // 이미 끝나는 순으로 정렬되어 있으니까 다음 끝나는 수는 현재의 끝나는 수보다 같거나 큰 수가 온다.
                end = targets[i][1];  // 다음 시작하는 수가 현재 끝나는 수보다 클 경우는 같이 요격이 안되는 것이니 count를 증가시켜고 end를 갱신해야 한다.
            }
        }
        System.out.print(count);

    }

}
