import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Problem {

    /**
     *
     * # 를 강
     * O(알파벳 대문자 o) 를 돌
     *
     * 20의 길이의 돌다리를 끝까지 건너게 하는게 매우 희박한 확률로 건너짐
     * 돌다리만으로 다리를 구축하여 진행할 시 성공적으로 건너는 것을 확인할 수 있음
     *
     * **/

    private static final int BRIDGE_LENGTH = 20; // 다리 길이 20으로 고정
    private static final int NUM_STONES = 10;    // 강 10개 -> 다리 길이 20이니 확정
    private static final int MAX_GAMES = 3; // 랜덤하게 만들어지는 다리에서 20칸을 전부 건너게 될 확률이 매우 희박하여 3게임 정도로 제한.

    // final 로 한 이유는 각 게임마다 이 값들은 항상 고정이 되어야 하기 때문이다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 사용자 입력
        Random random = new Random();

        int totalGamesPlayed = 1;  // 안하는 경우는 없으니까
        long totalGameTimeInSeconds = 0; // 게임 시간

        while (totalGamesPlayed < MAX_GAMES)  {
            System.out.println("Starting Game " + totalGamesPlayed);
            String bridgeLayout = generateBridgeLayout(random);

            char[] bridge = bridgeLayout.toCharArray();

            int diceRolls = -1;  // 주사위가 1 이면 0번 인덱스로 이동하게 설정
            int bridgesRebuilt = 0;  // 다리 다시 만든 횟수 (재시도 횟수로 사용)
            int currentPosition = 0;  // 현재 위치
            boolean crossedAllRivers = false;  // 다리를다 건넜나 판단

            long startTime = System.currentTimeMillis();
            while (!crossedAllRivers) {
                System.out.println("Bridge Layout: " + bridgeLayout);
                System.out.print("Press enter to roll the dice...");
                br.readLine();  // 사용자에게 enter를 입력받아 주사위 던지기

                int diceRoll = random.nextInt(4) + 1; // 주사위 1 에서 4까지의 숫자를 반환하게 만든다.
                System.out.println("dice: "+diceRoll);
                System.out.println("current position: "+currentPosition);
                int newPosition = currentPosition + diceRoll;  // 현재 위치 + 주사위 눈으로 새로운 위치 설정

                if (newPosition < BRIDGE_LENGTH && isFourOrMoreInARow(bridge, newPosition)) {
                    currentPosition = 0; // 다시 처음 위치로 이동
                    diceRolls = 0;  // 주사위 처음으로
                    bridgesRebuilt++;  // 재시도 횟수 올려주기
                    System.out.println("Four or more characters in a row.");
                    bridgeLayout = generateBridgeLayout(random);  // 다리 다시 만들기
                    bridge = bridgeLayout.toCharArray();
                } else {
                    if (newPosition < BRIDGE_LENGTH && bridge[newPosition] == '#') {  // 강에 빠진 경우
                        currentPosition = 0;
                        System.out.println("Bridge Layout: " + bridgeLayout);
                        System.out.println("You fell into the river. Rebuilding bridge");
                        bridgeLayout = generateBridgeLayout(random);  // 다리 다시 만들기
                        bridge = bridgeLayout.toCharArray();
                    } else {
                        currentPosition = newPosition;
                        diceRolls++; // 돌다리로 이동한 경우
                    }

                    if (currentPosition >= BRIDGE_LENGTH-1) {
                        crossedAllRivers = true;   // 다리 건너기 성공
                    }
                }
            }
            long endTime = System.currentTimeMillis();  // 게임 시간 측정
            long gameDurationInMillis = endTime - startTime;
            long gameDurationInSeconds = gameDurationInMillis / 1000;
            totalGameTimeInSeconds += gameDurationInSeconds;

            System.out.println("You crossed the bridge in " + diceRolls + " dice throws.");   // 결과 출력부
            System.out.println("Retrial times: " + bridgesRebuilt);
            System.out.println("Game time: " + gameDurationInSeconds + " seconds.");
        }

        long averageGameTimeInSeconds = totalGameTimeInSeconds / MAX_GAMES;  // 평균 게임 시간
        System.out.println("Average game time: " + averageGameTimeInSeconds);
    }

    private static String generateBridgeLayout(Random random) {  // 다리 만들기 메소드
        int numStones = NUM_STONES;  // 돌의 개수
        StringBuilder bridge = new StringBuilder();

        for (int i = 0; i < BRIDGE_LENGTH; i++) {
            if (numStones > 0 && random.nextBoolean()) {  // random 을 활용하여 무작위의 다리를 만들어준다.
                bridge.append('O'); // 돌
                numStones--;
            } else {
                bridge.append('#'); // 강
            }
        }
        return bridge.toString();
    }

    // 한 줄에 강이 4개가 넘게 있는지 판단하는 로직 -> 이것의 리턴값을 가지고 판단하여 다리를 재구성해야할지 정하게 된다.
    private static boolean isFourOrMoreInARow(char[] bridge, int position) {  // 해당 위치의 다리정도부터 앞전의 3칸을 더 봐서 4칸이 연속적으로 강으로 되어있는지 판단한다.
        if (position >= 3 && bridge[position] == '#') {
            char currentChar = bridge[position];  // 현재의 위치
            if (bridge[position - 1] == currentChar && bridge[position - 2] == currentChar && bridge[position - 3] == currentChar) {
                return true;
            }
        }
        return false;
    }
}