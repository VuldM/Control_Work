package Model;

public class PetCreator extends Creator { // Класс - Определение вида нового домашнего животного
    @Override
    protected Pet createNewPet (PetGenus genus) {
        switch (genus) {
            case Cat:
                return new Cat();
            case Dog:
                return new Dog();
            case Hamster:
                return new Hamster();
        }
        return null;
    }
}
