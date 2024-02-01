package UserInterface;

import java.util.Scanner;
import Controller.*;

import Model.Pet;
import Model.PetGenus;

public class ConsoleMenu {

    PetController petController;
    Scanner scan = new Scanner(System.in);

    public ConsoleMenu(PetController controller) {
        this.petController = controller;
    }

    // Главное меню
    public int mainMenu() {
        System.out.println("Введите номер команды:");
        System.out.println("1 - Вывести список всех животных");
        System.out.println("2 - Завести новое животное");
        System.out.println("3 - Удалить запись о животном");
        System.out.println("4 - Изменить информацию о животном");
        System.out.println("5 - Обучить животное новой команде");
        System.out.println("6 - Выход");
        try {
            int choise = Integer.parseInt(prompt("Ваш выбор: "));
            return choise;
        } catch (Exception e) {
            System.out.println("Введено некорректное значение!");
        }
        return 8;
    }

    private String prompt(String message) {
        System.out.print(message);
        return scan.nextLine();
    }

    public void start() {
        try (Counter count = new Counter()) {
            boolean flag = true;
            int id;
            while (flag) {
                int command = mainMenu();

                switch (command) {
                    // Вывести список всех животных
                    case 1:
                        petController.getAllPet();
                        break;

                    // Завести новое животное
                    case 2:
                        PetGenus genus = genusChoice();
                        if (genus != null) {
                            try {
                                petController.createPet(genus);
                                count.add();
                                System.out.println("Новое животное успешно создано!");
                                System.out.println(count.toString());
                            } catch (RuntimeException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;

                    // Удалить запись о животном
                    case 3:
                        id = idChoicePet();
                        if (id != 0)
                            try {
                                petController.deletePet(id);
                                System.out.println("Животное успешно удалено!");
                            } catch (RuntimeException e) {
                                System.out.println(e.getMessage());
                            }
                        break;

                    // Изменить информацию о животном
                    case 4:
                        id = idChoicePet();
                        if (id != 0) {
                            Pet oldPet = petController.readPet(id);
                            System.out.println("Редактрируемое животное:");
                            System.out.println("Класс: " + oldPet.getCommands().get(oldPet.getCommands().size() - 1));
                            System.out.println("Имя: " + oldPet.getName());
                            System.out.println("Дата рождения: " + oldPet.getBirthday());
                            System.out.println("Список команд: " + oldPet.getCommands().subList(0,
                                    oldPet.getCommands().size() - 1).toString());
                            System.out.println("Введите новые данные:");
                            try {
                                petController.updatePet(id);
                                System.out.println("Информация о животном успешно обновлена!");
                            } catch (RuntimeException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;

                    // Обучить животное новой команде
                    case 5:
                        id = idChoicePet();
                        if (id != 0)
                            menuTrainPet(id);
                        break;

                    case 6:
                        flag = false;
                        System.out.println("До свидания!");
                        break;
                    default:
                        System.out.println("Такого варианта нет! Попробуйте еще раз!");
                        break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Выбор вида домашнего животного
    private PetGenus genusChoice() {
        System.out.println("Какое животное Вы хотите добавить:");
        System.out.println("1 - Кошка");
        System.out.println("2 - Собака");
        System.out.println("3 - Хомяк");
        System.out.println("4 - Вернуться в основное меню");

        while (true) {
            try {
                int choise = Integer.parseInt(prompt("Ваш выбор: "));
                switch (choise) {
                    case 1:
                        return PetGenus.Cat;
                    case 2:
                        return PetGenus.Dog;
                    case 3:
                        return PetGenus.Hamster;
                    case 4:
                        return null;
                    default:
                        System.out.println("Такого варианта нет! Попробуйте еще раз!");
                        break;
                }
            } catch (RuntimeException e) {
                System.out.println("Введено некорректное значение!");
                break;
            }
        }
        return null;
    }

    // Ввод id животного
    private int idChoicePet() {
        int id = 0;
        try {
            id = Integer.parseInt(prompt("Введите id животного либо 0 для возврата в основное меню: "));
            if (id == 0)
                return id;
            petController.inputIdValidation(id);
        } catch (RuntimeException e) {
            System.out.println("Введено некорректное значение!");
        }
        return id;
    }

    // Обучить животное новой команде
    private void menuTrainPet(int petId) {
        String newCommand = prompt("Введите новую команду либо 0 для возврата в основное меню: ");
        if (newCommand.length() == 1 && newCommand.equals("0"))
            return;
        if (petController.petTrain(petId, newCommand)) {
            System.out.println("Животное обучено новой команде!");
        } else {
            System.out.println("Эту команду животное уже умеет делать!");
        }
    }
}
