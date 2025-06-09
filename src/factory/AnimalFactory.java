package factory;

import animals.AbsAnimal;
import animals.birds.Duck;
import animals.mammals.Cat;
import animals.mammals.Dog;
import data.AnimalTypeData;
import data.ColorData;

public class AnimalFactory {
    private String name = "";
    private int age = -1;
    private int weight = -1;
    private ColorData color = null;

    public AnimalFactory(String name, int age, int weight, ColorData colorData) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = colorData;
    }

    public AbsAnimal create(AnimalTypeData animalTypeData) {
        if (animalTypeData.equals(AnimalTypeData.CAT)) {
        return new Cat(name, age, weight, color);
        }

        if (animalTypeData.equals(AnimalTypeData.DOG)) {
            return new Dog(name, age, weight, color);
        }

        if (animalTypeData.equals(AnimalTypeData.DUCK)) {
            return new Duck(name, age, weight, color);
        }

        throw new RuntimeException(String.format("Такое животное %s не поддерживается", animalTypeData.name()));
    }
}
