package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Pet { // Класс - Домашнее животное
    protected int petId; // id
    protected String name; // Имя
    protected LocalDate birthday; // Дата рождения
    protected List<String> commands; // Список команд, исполняемых животным

    public Pet(int petId, String name, LocalDate birthday, List<String> commands) {
        this.petId = petId;
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }

    public Pet() {
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getPetId() {
        return petId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBirthday(LocalDate date) {
        this.birthday = date;
    }

    public LocalDate getBirthdayDate(){
        return birthday;
    }

    public String getBirthday() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return formatter.format(birthday);
    }

    @Override
    public String toString() {
        return String.format("имя: %s, дата рождения: %s, навыки: %s ",
                name, getBirthday(), getCommands());
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }
}
