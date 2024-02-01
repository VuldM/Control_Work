package Services;

import Model.Pet;

import java.time.LocalDate;
import java.util.List;

public interface PetRepository { // Интерфейс для работы со списком всех домашних животных

        // Получение списка всех животных
        List<Pet> getAllPets();

        // Запись всех животных в файл
        void writeAllPets(List<Pet> pets);

        // Внесение нового животного в список
        int create(Pet pet);

        // Обновление информации о животном в списке
        void update(int id, String name, LocalDate birthday, List<String> commands);

        // Удаление животного из списка
        void delete (int idPet);

        // Обучить животное новой команде
        boolean trainCommand(int idPet, String command);
}
