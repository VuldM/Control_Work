package Model;

import java.time.LocalDate;
import java.util.List;

public abstract class Creator { // Класс - Создание нового животного
    // Определение вида нового домашнего животного
    protected abstract Pet createNewPet(PetGenus petGenus);

    // Создание нового домашнего животного на основе его вида
    public Pet createPet(PetGenus petGenus, String name, LocalDate birthday, List<String> commands) {
        Pet newPet = createNewPet(petGenus);
        newPet.setName(name);
        newPet.setBirthday(birthday);
        newPet.setCommands(commands);
        return newPet;
    }
}
