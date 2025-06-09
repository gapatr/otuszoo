package animals.mammals;

import animals.AbsAnimal;
import data.ColorData;

public class Dog extends AbsAnimal {
    public Dog(String name, int age, int weight, ColorData colorData) {
        super(name, age, weight, colorData);
    }

    public void say() {
        System.out.println("Гав");
    }
}
