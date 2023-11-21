package home_work_5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;

import home_work_5.dto_classes.Animal;
import home_work_5.dto_classes.Person;
import home_work_5.utils.GenerateStringUtils;

/*
Коллекции, полиморфизм, DTO, Supplier*, Comparator:
1.Создаём классы только для хранения информации об объектах (DTO):
	1.1. Написать класс Person который содержит поля:
		1.1.1. Строку nick - псевдоним пользователя
		1.1.2. Строку password - пароль (от 5 до 10 символов)
		1.1.3. Строку name - имя пользователя
	1.2. Написать класс Animal:
		1.2.1. Число age - возраст (от 1 до 15 лет)
		1.2.2. Строка nick - кличка
2. Для имён:
	2.1 Генерировать рандомную строку (не важно из чего состоит)
	2.2 Генерировать рандомную строку (состоящую из русских букв)
	2.3 Генерировать рандомное имя (настоящее имя)
	2.4* Генерировать рандомное имя (имена получать из файла)
3. Для клички:
	3.1 Генерировать рандомную строку (не важно из чего состоит)
	3.2 Генерировать рандомную строку (состоящую из русских букв)
	3.3 Генерировать рандомное имя (настоящие клички животных)
	3.4* Генерировать рандомное имя (клички получать из файла)
4. Для псевдонимов:
	4.1 Генерировать рандомную строку (не важно из чего состоит)
	4.2 Генерировать рандомную строку (состоящую из анлийских букв)
	4.3* Генерировать рандомное имя (псевдонимы получать из файла)
5. Создать компараторы (Comparator) для классов которые сравнивают:
	5.1. Длину пароля пользователей
	5.2. Длину пароля пользователей и псевдонимы пользователей по алфавиту (Смотрите уточнение в пункте 5.99)
	5.3. Возраст животных
	5.4. Возраст животных и клички животных по алфавиту (Смотрите уточнение в пункте 5.99)
	5.99. Особенность данных компораторов в том что у вас при сортировке должна получиться группировка, сначала по
	первому полю, потом по второму. Пример для класса Animal
		К примеру: есть список животных [{age: 10, nick: "Анатолий"}, {age: 10, nick: "Игнат"},
		{age: 1, nick: "Люцифер"}, {age: 10, nick: "Ярик"}].
		После сортировки должно получиться: [{{age: 1, nick: "Люцифер"}, {age: 10, nick: "Анатолий"},
		{age: 10, nick: "Игнат"}, {age: 10, nick: "Ярик"}].
		Так как сначала сортируется по возрасту в порядке возрастания, а потом в рамках группу (пример: age = 10),
		сортируется по кличке по возрастанию (по алфавиту).
6. Работа с коллекциями. Выполняем действия над экземплярами классов созданных на основания задания 1:
	6.0* В идеале можно, используя полиморфизм, написать метод который будет выполнять основную работу над коллекциями
	наполненными любыми данными + методы для каждого из класса из пункта 1. Например метод который генерирует Person и
	заполняет ими указанную вами коллекцию указанным количеством  Person. Получившуюся коллекцию передаём во второй
	метод который выполняет все остальные прописанные действия.
	6.1. При помощи рандома генерируем 1_000_000 (Если компьютер глючит сделать 100_000) разных объектов одного класса.
	Поля заполняются рандомными данными.
	6.2. Заполняем:
		6.2.1. LinkedList
		6.2.2. ArrayList
		6.2.3. HashSet
		6.2.4. TreeSet
	6.3. Отсортировать коллекции используя компараторы созданные в этом ДЗ. 
		6.3.1. Сортируем встроенными средствами jdk
		6.3.2.* Сортируем собственным методом сортировки
	6.4. Замерить время и распечатать в консоль скорость каждой перечисленной операции: "Операция: ХХХХ. Заняла YYYY мс".
	Для замера использовать метод из jdk System.currentTimeMillis():
		6.4.1. Заполнения коллекции
		6.4.2. Итерирования коллекции:
			6.4.2.1. При помощи iterator
			6.4.2.2. При помощи любого другого способа (не foreach)
		6.4.3. Удаления всех элементов коллекции (выбрать один из):
			6.4.3.1. При помощи iterator
			6.4.3.2. При помощи любого другого способа
			*/

public class Runner {

    public static void main(String[] args) {

        List<Person> personLinkedList = new LinkedList<>();
        List<Person> personArrayList = new ArrayList<>();
        Set<Person> personHashSet = new HashSet<>();
        Set<Person> personTreeSet = new TreeSet<>();

        List<Animal> animalLinkedList = new LinkedList<>();
        List<Animal> animalArrayList = new ArrayList<>();
        Set<Animal> animalHashSet = new HashSet<>();
        Set<Animal> animalTreeSet = new TreeSet<>();

        Supplier<Person> personSupplier = () -> {
            try {
                return new Person(
                        GenerateStringUtils.getRandomString((int) (Math.random() * 30) + 10),
                        GenerateStringUtils.getRandomStringFromEngLetters((int) (Math.random() * 6) + 5),
                        GenerateStringUtils.getRandomStringFromFile("Names.txt"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return null;
        };
        Supplier<Animal> animalSupplier = () -> new Animal((int) (Math.random() * 15) + 1,
                GenerateStringUtils.getRandomStringFromRusLetters((int) (Math.random() * 30) + 10));

        RunnerEngine.run(personLinkedList, 100_000, personSupplier);
        RunnerEngine.run(personArrayList, 100_000, personSupplier);
        RunnerEngine.run(personHashSet, 100_000, personSupplier);
        RunnerEngine.run(personTreeSet, 100_000, personSupplier);

        RunnerEngine.run(animalLinkedList, 100_000, animalSupplier);
        RunnerEngine.run(animalArrayList, 100_000, animalSupplier);
        RunnerEngine.run(animalHashSet, 100_000, animalSupplier);
        RunnerEngine.run(animalTreeSet, 100_000, animalSupplier);
    }
}