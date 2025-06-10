import animals.AbsAnimal;
import data.AnimalTypeData;
import data.ColorData;
import data.CommandData;
import factory.AnimalFactory;
import tools.NumberValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static NumberValidator numberValidator = new NumberValidator();

    public static void main(String[] args) throws InterruptedException {

        List<AbsAnimal> animals = new ArrayList<>();

        List<String> commands = new ArrayList<>();

        for (CommandData commandData : CommandData.values()) {
            commands.add(commandData.name());
        }

        while (true) {
            System.out.println(String.format("Введите одну из следующих команд с клавиатуры: %s", String.join("/", commands)));

            String userConsoleCommand = scanner.nextLine().trim().replaceAll(" ", "").toUpperCase();

            if (!commands.contains(userConsoleCommand)) {
                System.out.println("Введенная вами команда: --" + userConsoleCommand.toLowerCase() + "-- не является верной");
                continue;
            }

            CommandData userCommand = CommandData.valueOf(userConsoleCommand);

            if (userCommand.equals(CommandData.ADD)) {

                System.out.println("Ожидайте, идёт обработка данных...");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Команда принята");

                List<String> animalsTypeNames = new ArrayList<>();

                for (AnimalTypeData animalTypeData : AnimalTypeData.values()) {
                    animalsTypeNames.add(animalTypeData.name());
                }

                AnimalTypeData animalTypeData = null;

                while (true) {
                    System.out.printf("Введите желаемый тип животного: %s\n", String.join(", ", animalsTypeNames));

                    String userAnimalType = scanner.nextLine().trim().replaceAll(" ", "").toUpperCase();

                    if (!animalsTypeNames.contains(userAnimalType)) {
                        System.out.println("Введен неверный тип животного! Попробуйте ещё раз.");
                        continue;
                    }

                    animalTypeData = AnimalTypeData.valueOf(userAnimalType);

                    break;
                }

                int age;
                age = -1;

                while (true) {
                    System.out.println("Введите возраст животного целым числом, но не более двух цифр.  Введите '0', если не знаете возраст.");

                    String animalAge = scanner.nextLine().trim().replaceAll(" ", "");

                    if (!numberValidator.isNumber(animalAge)) {
                        System.out.println("Введен недопустимый возраст, повторите попытку");
                        continue;
                    }

                    age = Integer.parseInt(animalAge);

                    break;
                }

                int weight;
                weight = -1;

                while (true) {
                    System.out.println("Введите вес животного целым числом, но не более двух цифр. Введите '0', если не знаете вес.");

                    String animalWeight = scanner.nextLine().trim().replaceAll(" ", "");

                    if (!numberValidator.isNumber(animalWeight)) {
                        System.out.println("Введен недопустимый вес, повторите попытку");
                        continue;
                    }

                    weight = Integer.parseInt(animalWeight);

                    break;
                }

                String name;

                while (true) {

                    System.out.println("Введите кличку животного:");

                    name = scanner.nextLine();

                    break;
                }

                List<String> animalsColor = new ArrayList<>();

                for (ColorData colorData : ColorData.values()) {
                    animalsColor.add(colorData.name());
                }

                ColorData colorData = null;
                while (true) {
                    System.out.printf("Введите цвет вашего животного из следующих вариантов: %s\n", String.join(", ", animalsColor));

                    String userColor = scanner.nextLine().trim().replaceAll(" ", "").toUpperCase();

                    if (!animalsColor.contains(userColor)) {
                        System.out.println("Введен не зарегистрированный цвет");
                        continue;
                    }

                    colorData = ColorData.valueOf(userColor);
                    break;
                }

                AbsAnimal animal = new AnimalFactory(name, age, weight, colorData).create(animalTypeData);
                animals.add(animal);

                System.out.println(animal.toString());
            }

            if (userCommand.equals(CommandData.LIST)) {
                for (AbsAnimal animal : animals) {
                    System.out.println(animal.toString());
                }
            }

            if (userCommand.equals(CommandData.EXIT)) {
                System.out.println("ПРОГРАММА ЗАВЕРШЕНА");
                System.exit(0);
            }
        }
    }
}