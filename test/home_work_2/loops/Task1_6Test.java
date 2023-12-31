package home_work_2.loops;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1_6Test {
    private final Task1_6 task = new Task1_6();

    @Test
    public void multiplicationTable() {
        String table = task.multiplicationTable();
        assertEquals(
                "2 x  1 =  2 | 3 x  1 =  3 | 4 x  1 =  4 | 5 x  1 =  5\n" +
                        "2 x  2 =  4 | 3 x  2 =  6 | 4 x  2 =  8 | 5 x  2 = 10\n" +
                        "2 x  3 =  6 | 3 x  3 =  9 | 4 x  3 = 12 | 5 x  3 = 15\n" +
                        "2 x  4 =  8 | 3 x  4 = 12 | 4 x  4 = 16 | 5 x  4 = 20\n" +
                        "2 x  5 = 10 | 3 x  5 = 15 | 4 x  5 = 20 | 5 x  5 = 25\n" +
                        "2 x  6 = 12 | 3 x  6 = 18 | 4 x  6 = 24 | 5 x  6 = 30\n" +
                        "2 x  7 = 14 | 3 x  7 = 21 | 4 x  7 = 28 | 5 x  7 = 35\n" +
                        "2 x  8 = 16 | 3 x  8 = 24 | 4 x  8 = 32 | 5 x  8 = 40\n" +
                        "2 x  9 = 18 | 3 x  9 = 27 | 4 x  9 = 36 | 5 x  9 = 45\n" +
                        "2 x 10 = 20 | 3 x 10 = 30 | 4 x 10 = 40 | 5 x 10 = 50\n" +
                        "-----------------------------------------------------\n" +
                        "6 x  1 =  6 | 7 x  1 =  7 | 8 x  1 =  8 | 9 x  1 =  9\n" +
                        "6 x  2 = 12 | 7 x  2 = 14 | 8 x  2 = 16 | 9 x  2 = 18\n" +
                        "6 x  3 = 18 | 7 x  3 = 21 | 8 x  3 = 24 | 9 x  3 = 27\n" +
                        "6 x  4 = 24 | 7 x  4 = 28 | 8 x  4 = 32 | 9 x  4 = 36\n" +
                        "6 x  5 = 30 | 7 x  5 = 35 | 8 x  5 = 40 | 9 x  5 = 45\n" +
                        "6 x  6 = 36 | 7 x  6 = 42 | 8 x  6 = 48 | 9 x  6 = 54\n" +
                        "6 x  7 = 42 | 7 x  7 = 49 | 8 x  7 = 56 | 9 x  7 = 63\n" +
                        "6 x  8 = 48 | 7 x  8 = 56 | 8 x  8 = 64 | 9 x  8 = 72\n" +
                        "6 x  9 = 54 | 7 x  9 = 63 | 8 x  9 = 72 | 9 x  9 = 81\n" +
                        "6 x 10 = 60 | 7 x 10 = 70 | 8 x 10 = 80 | 9 x 10 = 90", table);
    }
}