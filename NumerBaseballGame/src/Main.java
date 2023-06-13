import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] computer = new int[3];
        int[] users = new int[3];
        int attempts = 0;

        // 무작위 3개 숫자 생성
        for (int i = 0; i < 3; i++) {
            computer[i] = (int)(Math.random() * 9 + 1);
            for (int j = 0; j < i; j++){
                if (computer[i] == computer[j]){
                    i--;
                    break;
                }
            }
        }
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요 !!");

        Scanner scanner = new Scanner(System.in);

        // 게임 시작
        int t = 1;
        while (true) {
            System.out.print(t + "번째 시도 : ");
            int input = scanner.nextInt();

            // 사용자가 입력한 숫자를 배열에 저장
            for (int i = 2; i >= 0; i--) {
                users[i] = input % 10;
                input /= 10;
            }
            int strikes = 0;
            int balls = 0;

            // 스트라이크, 볼 계산
            for (int i = 0; i < 3; i++) {
                if (users[i] == computer[i]){
                    strikes++;
                } else {
                    for (int j = 0; j < 3; j++){
                        if (users[i] == computer[j]){
                            balls++;
                            break;
                        }
                    }
                }
            }
            // 결과 출력
            System.out.println(strikes + "S" + balls + "B");

            // 게임 종료
            if (strikes == 3){
                System.out.println("축하합니다! " + t + "번 시도 후에 맞추셨습니다." );
                break;
            }
            t++;
        }
    }
}
