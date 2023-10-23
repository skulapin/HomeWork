package tower_of_hanoi;

import java.util.Arrays;
import java.util.Random;

/**
 * Автоматический режим игры Башни Ханои. Компьютер не знает правила и как пользователь может совершать ошибки
 *
 * @author s.kulapin
 */
public class HanoiAutoStupid extends HanoiManual {

    @Override
    public void startGame(int[][] tower, int[][] finishTower) {

        System.out.println();
        printArray(tower);

        while (!Arrays.deepEquals(tower, finishTower)) {
            int moveFrom;
            int moveTo;

            Random rand = new Random();

            moveFrom = rand.nextInt(tower[0].length) + 1;
            moveTo = rand.nextInt(tower[0].length) + 1;

            System.out.println("Попробуем переместить диск с " + moveFrom + " колышка на " + moveTo + " колышек");

            moveRing(tower, moveFrom - 1, moveTo - 1);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println();
            printArray(tower);
        }
        System.out.println(
                "Поздравляем!\nВы выиграли за " + getMoveCounter() + " ходов и " + getTryCounter() + " попыток.");
    }
}