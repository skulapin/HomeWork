package tower_of_hanoi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ручной режим игры Башни Ханои
 *
 * @author s.kulapin
 */
public class HanoiManual implements IHanoi, Serializable {

    /**
     * Количество попыток переставления дисков
     */
    private int tryCounter;

    /**
     * Количество успешных ходов по переставлению диска
     */
    private int moveCounter;

    /**
     * Массив содержащий информацию об игровой башне Ханои
     */
    private int[][] tower;

    /**
     * Массив, содержащий информацию о башне Ханои которая должна получиться по завершении игры
     */
    private int[][] finishTower;

    /**
     * Коллекция содержащая историю всех соверщенных ходов
     */
    private ArrayList<String> gameHistory = new ArrayList<String>();

    public int getTryCounter() {
        return this.tryCounter;
    }

    public int getMoveCounter() {
        return this.moveCounter;
    }

    public int[][] getTower() {
        return this.tower;
    }

    public int[][] getFinishTower() {
        return this.finishTower;
    }

    public ArrayList<String> getGameHistory() {
        return this.gameHistory;
    }

    @Override
    public void startGame(int[][] tower, int[][] finishTower) {
        this.tower = tower;
        this.finishTower = finishTower;

        Scanner sc = new Scanner(System.in);
        int moveFrom;
        int moveTo;
        String move;

        System.out.println(
                "Вводите в консоль команды по перемещению диска в формате '1-3'\nДля досрочного завершения игры нажмите 'q'");
        System.out.println();
        printArray(tower);

        while (!Arrays.deepEquals(tower, finishTower)) {
            while (true) {

                System.out.print("-> ");

                move = sc.nextLine();
                if (move.length() == 1 && move.charAt(0) == 'q') {
                    System.out.println("Вы досрочно завершили игру!");
                    return;
                }

                if (move.length() == 3 && Character.isDigit(move.charAt(0)) && Character.isDigit(move.charAt(2))
                        && move.charAt(1) == '-' && Integer.parseInt(move.substring(0, 1)) >= 1
                        && Integer.parseInt(move.substring(0, 1)) <= 8 && Integer.parseInt(move.substring(2)) >= 1
                        && Integer.parseInt(move.substring(2)) <= 8) {

                    moveFrom = Integer.parseInt(move.substring(0, 1));
                    moveTo = Integer.parseInt(move.substring(2));
                    break;
                }
                System.out.println("Неверный ввод, повторите попытку!");
            }

            moveRing(tower, moveFrom - 1, moveTo - 1);

            System.out.println();
            printArray(tower);

        }

        System.out.println("Поздравляем!\nВы выиграли за " + moveCounter + " ходов и " + tryCounter + " попыток.");
        gameHistory.add("Игра была пройдена за " + moveCounter + " ходов и " + tryCounter + " попыток.");

        System.out.println();
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
     * Проверяет возможность и изменяет массив, перерисовывая вид Ханойской башни после успешного хода
     *
     * @param tower    Массив с игровой башней Ханои
     * @param moveFrom Номер столбца массива с которого переместить диск
     * @param moveTo   Номер столбца массива куда переместить диск
     */
    public void moveRing(int[][] tower, int moveFrom, int moveTo) {

        if (moveFrom == moveTo) {
            System.out.println("Неверный ход, повторите попытку");
            tryCounter++;
            gameHistory.add("Ход " + tryCounter + ": Неудачная попытка переместить диск с " + moveFrom + " колышка на "
                    + moveTo + " колышек");
            return;
        }

        int startRingPosition = 0;
        int endRingPosition = 0;
        int temp;

        // находим позицию верхнего кольца
        for (int i = 0; i < tower.length; i++) {

            if (tower[i][moveFrom] != 0) {
                startRingPosition = i;
                break;
            }

            if (i == tower.length - 1) {
                System.out.println("Неверный ход, повторите попытку");
                tryCounter++;
                gameHistory.add("Ход " + tryCounter + ": Неудачная попытка переместить диск с " + moveFrom
                        + " колышка на " + moveTo + " колышек");
                return;
            }
        }

        // находим первую пустую позицию куда переносим
        for (int i = tower.length - 1; i >= 0; i--) {
            if (tower[i][moveTo] == 0) {
                endRingPosition = i;
                break;
            }
        }

        // Проверка на возможность перемещения кольца
        if (endRingPosition != tower.length - 1
                && tower[endRingPosition + 1][moveTo] < tower[startRingPosition][moveFrom]) {
            System.out.println("Неверный ход, повторите попытку");
            tryCounter++;
            gameHistory.add("Ход " + tryCounter + ": Неудачная попытка переместить диск с " + moveFrom + " колышка на "
                    + moveTo + " колышек");
            return;
        }

        temp = tower[startRingPosition][moveFrom];
        tower[startRingPosition][moveFrom] = 0;
        tower[endRingPosition][moveTo] = temp;
        tryCounter++;
        moveCounter++;
        gameHistory.add("Ход " + tryCounter + ": Перемещаем диск с " + moveFrom + " колышка на " + moveTo + " колышек");
    }
}