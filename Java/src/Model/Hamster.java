package Model;

import java.time.LocalDate;
import java.util.List;

public class Hamster extends Pet{ // Класс - Хомяк
    public Hamster() {
    }

    public Hamster(int petId, String name, LocalDate birthday, List<String> commands) {
        super(petId, name, birthday, commands);
    }
}
