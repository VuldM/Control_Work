package Services;

import Model.Pet;

import java.util.List;

public interface FileOperation {
    // Получение из файла списка всех животных
    List<Pet> readAllPets();

    // Запись в файл списка всех животных
    void saveAllPets(List<String> pets);

}
