package lesson3.task4;

import java.io.Serializable;

public class Cat implements Serializable {
    String name;
    int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printInfo() {
        System.out.printf("Cat name is %s, cat age is %s", name, age);
    }
}
