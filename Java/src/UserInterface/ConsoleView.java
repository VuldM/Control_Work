package UserInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Model.*;

public class ConsoleView{ // Ввод информации о животном с консоли
    Scanner scan;

    public ConsoleView() {
        scan = new Scanner(System.in);
    }

    public String getName() {
        System.out.printf("Введите имя животного: ");
        return scan.nextLine();
    }

    public String getBirthday() {
        System.out.printf("Введите дату рождения животного в формате 'дд.мм.гггг': ");
        return scan.nextLine();
    }

    public List<String> getCommands() {
        System.out.printf("Введите через запятую список команд, исполняемых животным: ");
        String lineCommands = scan.nextLine();
        String[] commands = lineCommands.trim().split(",");
        List<String> listCommands = new ArrayList<>();
        for (String item : commands) {
            listCommands.add(item.trim());
        }
        return listCommands;
    }

    // Вывод списка всех домашних животных
    public void printAll (List<Pet> listPet) {
        if (listPet.isEmpty())
            System.out.println("Список домашних животных пуст!");
        else {
            System.out.println("Список всех домашних животных:");
            for (Pet item : listPet) {
                String id = Integer.toString(item.getPetId());
                String genus = item.getCommands().get(item.getCommands().size() - 1);
                String name = item.getName();
                String birthday = item.getBirthday();
                String commands = item.getCommands().subList(0, item.getCommands().size() - 1).toString();
                String line = id.concat(". ").concat(genus).concat(" имя: ").
                        concat(name).concat(", дата рождения: ").concat(birthday).
                        concat(", навыки: ").
                        concat(commands);
                System.out.println(line);
            }
        }
    }

}
