package home_work_4;

public class DataContainerRunner {

    public static void main(String[] args) {

        DataContainer<String> container1 = new DataContainer<>(new String[0]);

        int stringIndex1 = container1.add("Привет");
        int stringIndex2 = container1.add("Как дела");
        int stringIndex3 = container1.add("Работаю");
        int stringIndex4 = container1.add("Давай потом");
        String text1 = container1.get(stringIndex1);
        String text2 = container1.get(stringIndex2);
        String text3 = container1.get(stringIndex3);
        String text4 = container1.get(stringIndex4);

        System.out.println(text1); // Привет
        System.out.println(text2); // Как дела
        System.out.println(text3); // Работаю
        System.out.println(text4); // Давай потом
        container1.delete(text1);
        System.out.println(container1.get(stringIndex1)); // Как дела
        container1.sort(new StringCompare()); // Сортируется по длине
        System.out.println(container1); // ["Работаю", "Как дела", "Давай потом"]

        for (String text : container1) {
            System.out.print(text + " ");
        }

        System.out.println();

        DataContainer<Integer> container2 = new DataContainer<>(new Integer[0]);

        int integerIndex1 = container2.add(Integer.valueOf(2));
        int integerIndex2 = container2.add(Integer.valueOf(3));
        int integerIndex3 = container2.add(Integer.valueOf(1));
        int integerIndex4 = container2.add(Integer.valueOf(777));
        int integerIndex5 = container2.add(Integer.valueOf(3));

        System.out.println(container2.get(integerIndex1));
        System.out.println(container2.get(integerIndex2));
        System.out.println(container2.get(integerIndex3));
        System.out.println(container2.get(integerIndex4));
        System.out.println(container2.get(integerIndex5));

        container2.delete(Integer.valueOf(3));

        System.out.println(container2.get(integerIndex2));
        container2.sort(new IntegerCompare());
        System.out.println(container2);

        for (Integer number : container2) {
            System.out.print(number + " ");
        }
    }
}