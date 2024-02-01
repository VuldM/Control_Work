package Model;

public enum PetGenus { // Разновидности домашних животных
    Cat,
    Dog,
    Hamster;

    // Получение вида животного по id
    public static PetGenus getGenus (int genusId){
        switch (genusId){
            case 1:
                return PetGenus.Cat;
            case 2:
                return PetGenus.Dog;
            case 3:
                return PetGenus.Hamster;
            default:
                return null;
        }
    }
}
