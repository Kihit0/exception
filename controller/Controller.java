package homework.src.controller;


import homework.src.service.ReadService;
import homework.src.service.ValidateService;
import homework.src.service.WriteService;
import homework.src.view.View;

import java.io.IOException;
import java.util.Scanner;

public class Controller {
    private final ValidateService validate = new ValidateService();
    private final WriteService write = new WriteService();
    private final ReadService read = new ReadService();
    private final View view = new View();


    private void work(){
        Scanner scanner = new Scanner(System.in);
        boolean isWork = true;
        while (isWork){
            view.viewChange();
            System.out.print("Введите число: ");
            String change = scanner.next();
            scanner.nextLine();

            switch (change){
                case "1":
                    System.out.println("Пользователь вида (Ivan Ivan Ivan 01.12.2000 899999 m). Через пробел ");
                    System.out.print("Введите пользователя: ");
                    String user = scanner.nextLine();

                    boolean isValidate = validate.init(user);

                    if(!isValidate){
                        while (!isValidate){
                            System.out.print("Введите пользователя: ");
                            user = scanner.nextLine();
                            isValidate = validate.init(user);
                        }

                    }

                    try{
                        write.tryWriteInFile(user);
                        System.out.println("Пользователь добавлен");
                    } catch (IOException e) {
                        System.out.println("Error: Не получилось создать/записать в файл");
                    }
                    break;

                case "2":
                    System.out.print("Введите фамилию пользователя: ");
                    String lastName = scanner.next();
                    try{
                        read.tryReadFile(lastName);
                    } catch (IOException e) {
                        System.out.println("Error: Не получилось найти и прочитать файл");
                    }

                    break;


                case "0":
                    isWork = false;
                    break;

                default:
                    System.out.println("Error: Такого выбора нет");

            }

        }

    }

    public void init(){
        this.work();
    }
}
