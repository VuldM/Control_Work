package Model;

import java.time.LocalDate;
import java.util.List;

public class Dog extends Pet { // Класс - Собака
    public Dog() {
    }

    public Dog(int petId, String name, LocalDate birthday, List<String> commands) {
        super(petId, name, birthday, commands);
    }
}
