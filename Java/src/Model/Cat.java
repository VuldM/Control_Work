package Model;

import java.time.LocalDate;
import java.util.List;

public class Cat extends Pet{
    public Cat() {
    }

    public Cat(int petId, String name, LocalDate birthday, List<String> commands) {
        super(petId, name, birthday, commands);
    }
}
