package home_work_5.dto_classes;

import java.util.Objects;

public class Person implements Comparable<Person> {

    /**
     * Псевдоним пользователя
     */
    private String nick;

    /**
     * Пароль (от 5 до 10 символов)
     */
    private String password;

    /**
     * Имя пользователя
     */
    private String name;

    public Person(String nick, String password, String name) {

        this.nick = nick;
        setPassword(password);
        this.name = name;
    }

    private void setPassword(String password) {

        int passwordLength = password.length();

        if (passwordLength >= 5 && passwordLength <= 10) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Введена неверная длина пароля");
        }
    }

    public String getNick() {
        return this.nick;
    }

    public String getPassword() {
        return this.password;

    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "[nick: " + this.nick + ", password: " + this.password + ", name: " + this.name + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nick, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        return Objects.equals(name, other.name) && Objects.equals(nick, other.nick)
                && Objects.equals(password, other.password);
    }

    @Override
    public int compareTo(Person o) {

        if (o == null) {
            return -1;
        }

        int thisLength = this.password.length();
        int oLength = o.getPassword().length();

        if (thisLength > oLength) {
            return 1;
        } else if (thisLength < oLength) {
            return -1;
        }
        return this.nick.compareTo(o.getNick());
    }
}