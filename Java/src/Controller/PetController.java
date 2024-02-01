package Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import Model.*;
import Services.PetRepository;
import UserInterface.ConsoleView;

public class PetController {
    private PetRepository petRepository;
    private Creator petCreator;
    private final ConsoleView consoleView;

    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
        this.petCreator = new PetCreator();
        this.consoleView = new ConsoleView();
    }

    // Добавление нового животного
    public void createPet(PetGenus petGenus) {
        String name = consoleView.getName();
        String dateBirthday = consoleView.getBirthday();
        List<String> commands = consoleView.getCommands();
        if (isValidDate(dateBirthday)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate birthday = LocalDate.parse(dateBirthday, formatter);
            petRepository.create(petCreator.createPet(petGenus, name, birthday, commands));
        }
    }

    // Обновление информации о животном
    public void updatePet(int idPet) {
        String name = consoleView.getName();
        String dateBirthday = consoleView.getBirthday();
        List<String> commands = consoleView.getCommands();
        if (isValidDate(dateBirthday)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate birthday = LocalDate.parse(dateBirthday, formatter);
            petRepository.update(idPet, name, birthday, commands);
        }
    }

    // Получить список всех животных
    public void getAllPet() {
        try {
            consoleView.printAll(petRepository.getAllPets());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());;
        }
    }

    // Поиск животного по его ip
    public Pet readPet(int idPet) throws Exception {
        List<Pet> pets = petRepository.getAllPets();
        for (Pet item : pets) {
            if (item.getPetId() == idPet) {
                return item;
            }
        }
        throw new Exception("Животное не найдено!");
    }

    // Обучение животного новой команде
    public boolean petTrain(int idPet, String command) {
        petRepository.trainCommand(idPet, command);
        return true;
    }

    // Удаление животного
    public void deletePet(int idPet) {
        petRepository.delete(idPet);
    }

    // Проверка даты рождения животного на валидность
    private boolean isValidDate(String birthday)  {
        LocalDate date;
        Integer [] month_30 = {4, 6, 9, 11};
        int day;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            date = LocalDate.parse(birthday, formatter);
            day = date.getDayOfMonth();
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Дата рождения животного введена некорректно!");
        }

        if ((Arrays.asList(month_30).contains(date.getMonthValue()) && day > 30) ||
                (date.isLeapYear() && date.getMonthValue() == 2 && day > 29) ||
                (!date.isLeapYear() && date.getMonthValue() == 2 && day > 28)) {
            throw new RuntimeException("Дата рождения животного введена некорректно!");
        } else
            return true;
    }

    // Проверка - есть в списке животное с указанным id
    public void inputIdValidation (int inputId) throws RuntimeException {
        List<Pet> pets = petRepository.getAllPets();
        for (Pet item : pets) {
            if (item.getPetId() == inputId)
                return;
        }
        throw new RuntimeException("Животное с таким id не найдено");
    }
}
