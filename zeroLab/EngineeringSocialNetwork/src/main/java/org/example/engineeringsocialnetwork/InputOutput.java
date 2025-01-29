package org.example.engineeringsocialnetwork;

import java.util.Scanner;
import lombok.Getter;
import org.example.engineeringsocialnetwork.entities.Info;
import org.example.engineeringsocialnetwork.factory.CourseFactory;
import org.example.engineeringsocialnetwork.factory.ProjectFactory;
import org.example.engineeringsocialnetwork.factory.UserFactory;




public class InputOutput {
    @Getter
    private final String message = """
            Введите, что вы хотите вывести:
            0. Выход
            1. Основную информацию
            2. Список курсов
            3. Список проектов
            4. Список людей
            5. Юридическая информация о компании           \s
           \s""";
    private Scanner in = new Scanner(System.in);

    public void setScanner(Scanner scanner) {
        in = scanner;
    }

    @SuppressWarnings("RegexpSinglelineJava")
    int getNumInput(int leftBorder, int rightBorder, String message) {

        System.out.print(message);

        int someIntValue;

        while (true) {
            if (in.hasNextInt()) {
                someIntValue = in.nextInt();
                in.nextLine();
                if (someIntValue < leftBorder || someIntValue > rightBorder) {
                    System.out.printf("Введенное число должно быть в диапазоне от %d до %d\n\n%s\n",
                            leftBorder, rightBorder, message);
                } else {
                    return someIntValue;
                }
            } else {
                in.nextLine();
                System.out.printf("Вы ввели не число!\n\n%s\n", message);
            }
        }
    }

    @SuppressWarnings({"MagicNumber", "MissingSwitchDefault", "RegexpSinglelineJava"})
    public void getStart() {
        int answer = getNumInput(0, 5, message);
        while (answer != 0) {
            switch (answer) {
                case 1 -> System.out.println(Info.MAIN_INFO);
                case 2 -> {
                    CourseFactory courseFactory = new CourseFactory();
                    courseFactory.getCourses().forEach(System.out::println);
                    System.out.println();
                }
                case 3 -> {
                    ProjectFactory projectFactory = new ProjectFactory();
                    projectFactory.getProjects().forEach(System.out::println);
                    System.out.println();
                }
                case 4 -> {
                    UserFactory userFactory = new UserFactory();
                    userFactory.getUsers().forEach(System.out::println);
                    System.out.println();
                }
                case 5 -> System.out.println(Info.LEGAL_INFORMATION);
            }
            answer = getNumInput(0, 5, message);
        }
    }

}
