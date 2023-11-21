package home_work_5.dto_classes;

import java.util.Objects;

public class Animal implements Comparable<Animal> {

    /**
     * Возраст (от 1 до 15 лет)
     */
    private int age;

    /**
     * Кличка
     */
    private String nick;

    public Animal(int age, String nick) {
        setAge(age);
        this.nick = nick;
    }

    private void setAge(int age) {
        if (age >= 0 && age <= 15) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Введен неверный возраст");
        }
    }

    public int getAge() {
        return this.age;
    }

    public String getNick() {
        return this.nick;
    }

    @Override
    public String toString() {
        return "[age: " + age + ", nick: " + nick + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, nick);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        return age == other.age && Objects.equals(nick, other.nick);
    }

    @Override
    public int compareTo(Animal o) {
        if (o == null) {
            return -1;
        }

        int oAge = o.getAge();

        if (this.age > oAge) {
            return 1;
        } else if (this.age < oAge) {
            return -1;
        }
        return this.nick.compareTo(o.getNick());
    }
}