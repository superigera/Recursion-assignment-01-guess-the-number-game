import java.util.Scanner;
import java.util.Random;

public class GuessNumberGame {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\n  Guess the Number Game");
        System.out.println("  ---------------------");
        System.out.println("  入力した範囲内で出題される、\n  ランダムな数字を当てるゲーム");
        System.out.println("  ---------------------\n");

        int answer = gameInitialize();
        gameLoop(answer);
        gameShutdown();
    }

    // 最小値と最大値を入力してもらう
    private static int[] playerInitializeInput() {
        int minValue = getInput("最小値を入力してください : ");
        int maxValue = getInput("最大値を入力してください : ");

        while (minValue > maxValue) {
            System.out.println("最大値は最小値以上の値にして下さい。");
            minValue = getInput("最小値を入力してください : ");
            maxValue = getInput("最大値を入力してください : ");
        }
        return new int[] { minValue, maxValue };
    }

    // 答えを乱数で生成
    private static int generateAnswer(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    // ゲーム初期化
    private static int gameInitialize() {
        int[] range = playerInitializeInput();
        return generateAnswer(range[0], range[1]);
    }

    // 数値入力を保証する関数
    private static int getInput(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("数字を入力してください : ");
            scanner.next(); // 入力をクリア
        }
        return scanner.nextInt();
    }

    // ゲームメインループ
    private static void gameLoop(int answer) {
        System.out.println();
        System.out.println("さあ、答えの数字を当てて見て下さい。\n");

        while (true) {
            int guess = getInput("数字を入力してください : ");
            if (guess == answer) {
                System.out.println("正解!");
                break;
            }
            System.out.println("残念！ハズレ！");
        }
    }

    // ゲーム終了処理
    private static void gameShutdown() {
        System.out.println("Game Over!");
    }
}
