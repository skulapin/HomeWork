package tower_of_hanoi;

/**
 * Автоматический режим игры Башни Ханои. Компьютер знает правила и сразу знает что куда перемещать и не делает
 * неправильные ходы. Алгоритм ходов выполнен методом рекурсивного спуска (Да-да Илья писал в файле ДЗ, что так делать
 * не надо :) В домашке и слезах не закопался, т.к. нашел в гугле исходник с алгоритмом на несколько строк)
 * Исходный код:
 * https://proglang.su/java-examples/method-tower
 *
 * @author s.kulapin
 */
public class HanoiAutoSmart implements IHanoi {

    /**
     * Количество успешных ходов по переставлению диска
     */
    private int moveCounter;

    /**
     * Массив содержащий информацию об игровой башне Ханои
     */
    int tower[][];

    @Override
    public void startGame(int[][] tower, int[][] finishTower) {

        this.tower = tower;
        int diskNumber = this.tower.length;
        int startRod = 1;
        int rodNumber = this.tower[0].length;

        System.out.println();
        printArray(tower);
        move(diskNumber, startRod, rodNumber);
        System.out.println("Поздравляем!\nВы выиграли за " + moveCounter + " ходов.");
    }

    @Override
    public void printArray(int[][] tower) {
        for (int i = 0; i < tower.length; i++) {
            for (int j = 0; j < tower[i].length; j++) {
                if (tower[i][j] == 0) {
                    System.out.print("* ");
                } else {
                    System.out.print(tower[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Алгоритм перемещения дисков, метод рекурсивного спуска. Корректно отрабатывает на 3 стержнях с неограниченным
     * количеством дисков.
     *
     * @param n        Номер диска соответствующий его размеру
     * @param startRod Номер первого колышка
     * @param endRod   Номер последнего колышка
     */
    public void move(int n, int startRod, int endRod) {
        int startRingPosition = 0;
        int endRingPosition = 0;
        int temp;

        if (n == 0) {
            return;
        }

        int intermediateRod = 6 - startRod - endRod;
        move(n - 1, startRod, intermediateRod);
        System.out.println("Переместить " + n + " из " + startRod + " в " + endRod);

        // находим кольцо
        for (int i = 0; i < tower.length; i++) {
            if (tower[i][startRod - 1] == n) {
                startRingPosition = i;
                break;
            }
        }
        // находим куда переместить кольцо
        for (int i = tower.length - 1; i >= 0; i--) {
            if (tower[i][endRod - 1] == 0) {
                endRingPosition = i;
                break;
            }
        }

        temp = tower[startRingPosition][startRod - 1];
        tower[startRingPosition][startRod - 1] = 0;
        tower[endRingPosition][endRod - 1] = temp;
        moveCounter++;

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        printArray(tower);
        move(n - 1, intermediateRod, endRod);
    }
}