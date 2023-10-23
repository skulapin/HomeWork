package tower_of_hanoi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Запускает конкретный режим игры, формирует стартовые данные. Сохраняет и загружает файлы. Двумя словами - стартовое окно
 *
 * @author s.kulapin
 */
public class HanoiEngine {

    /**
     * Режим игры: 1 - ручной, 2 - автоматический
     */
    private int mode;

    /**
     * Режим автоматической игры. 1 - Компьютер всегда делает правильные шаги и заканчивает игру за минимальное
     * количество шагов, 2 - компьютер наугад пытается переставлять кольца
     */
    private int autoMode;

    /**
     * Режим ручной игры: 1 - новая игра, 2 - загрузить сохраненную игру, 3 - загрузить пройденную игру
     */
    private int manualMode;

    /**
     * Массив, представляющий информацию о текущем состоянии игровой башни
     */
    private int[][] gameTower;

    /**
     * Массив, представляющий информации в каком виде должна быть законченная игровая башня
     */
    private int[][] endTower;

    /**
     * Ссылка на объект интерфейса IHanoi
     */
    private IHanoi hanoi;

    /**
     * Конструктор класса HanoiEngine заполняюший игровой и финальный массивы игры
     *
     * @param mode       Режим игры
     * @param manualMode Режим ручной игры
     * @param autoMode   Режим автоматической игры
     * @param diskNumber Количество дисков
     * @param rodNumber  Количество штырей
     */
    public HanoiEngine(int mode, int manualMode, int autoMode, int diskNumber, int rodNumber) {

        this.mode = mode;
        this.manualMode = manualMode;
        this.autoMode = autoMode;
        this.gameTower = new int[diskNumber][rodNumber];
        this.endTower = new int[diskNumber][rodNumber];
        fillArray(gameTower, 0);
        fillArray(endTower, rodNumber - 1);
    }

    /**
     * Создает башню Ханои, заполняя заданную вертикаль массива последовательностью цифр начиная с 1
     *
     * @param tower Массив для заполнения
     * @param rod   Номер вертикального ряда
     */
    private void fillArray(int[][] tower, int rod) {

        for (int i = 0; i < tower.length; i++) {
            tower[i][rod] = i + 1;
        }
    }

    /**
     * Выбирает и запускает соответствующий режим игры Ханойская Башня. Включает в себя 3 режима (1 ручной и 2
     * автоматических). Выбор режима осуществляется в зависимости от переданных параметров при создании экземпляра класса
     */
    public void play() {

        Scanner sc = new Scanner(System.in);
        String answer;

        if (mode == 1) {
            if (manualMode != 3) {
                if (manualMode == 1) {
                    hanoi = new HanoiManual();
                    hanoi.startGame(gameTower, endTower);
                } else {
                    System.out.print("Введите название файла для загрузки: ");
                    hanoi = downloadGame();
                    hanoi.startGame(((HanoiManual) hanoi).getTower(), ((HanoiManual) hanoi).getFinishTower());
                }
                System.out.print("Хотите сохранить результат игры? Введите 'y' или 'n': ");

                answer = sc.nextLine();

                while (!answer.equals("y") && !answer.equals("n")) {
                    System.out.println("Неверный ввод, повторите попытку!");
                    answer = sc.nextLine();
                }
                if (answer.equals("y")) {

                    String savedFileName;

                    System.out.print("Введите название файла: ");

                    savedFileName = saveGame(hanoi);

                    System.out.print("Сохранен файл под названием " + savedFileName);
                }
            } else {

                System.out.print("Введите название файла для загрузки: ");

                hanoi = downloadGame();

                System.out.println();

                for (String history : ((HanoiManual) hanoi).getGameHistory()) {
                    System.out.println(history.toString());
                }
            }
        } else {
            if (autoMode == 1) {
                hanoi = new HanoiAutoSmart();
            } else {
                hanoi = new HanoiAutoStupid();
            }
            hanoi.startGame(gameTower, endTower);
        }
    }

    /**
     * Загружает прогресс сохраненной игры
     *
     * @return экземпляр интерфейса IHanoi
     */
    public IHanoi downloadGame() {

        IHanoi downloadHanoi = null;
        Scanner sc = new Scanner(System.in);
        String fileName;

        fileName = sc.nextLine();
        fileName += ".ser";
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
            downloadHanoi = (IHanoi) is.readObject();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return downloadHanoi;
    }

    /**
     * Сохраняет в файл текущий прогресс игры
     *
     * @param writeHanoi Объект типа IHanoi для сохранения, хранящий необходимые данные
     * @return Название сохраненного файла
     */
    public String saveGame(IHanoi writeHanoi) {

        Scanner sc = new Scanner(System.in);
        String fileName = "";
        try {

            fileName = sc.nextLine();
            fileName += ".ser";

            FileOutputStream fs = new FileOutputStream(fileName);
            ObjectOutputStream os = new ObjectOutputStream(fs);

            os.writeObject((HanoiManual) writeHanoi);
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }
}