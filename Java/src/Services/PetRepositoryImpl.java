package Services;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import Model.*;

public class PetRepositoryImpl implements PetRepository { // Работа со списком всех домашних животных
    private FileOperation fileOperation;

    public PetRepositoryImpl(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    // Получение списка всех животных
    @Override
    public List<Pet> getAllPets() {
        List<Pet> petList = fileOperation.readAllPets();
        return petList;
    }

    // Внесение нового животного в список
    @Override
    public int create(Pet newPet) {
        List<Pet> pets = getAllPets();
        int maxId = 0;
        for (Pet item : pets) {
            int currentId = item.getPetId();
            if (maxId < currentId) {
                maxId = currentId;
            }
        }
        int idNote = maxId + 1;
        newPet.setPetId(idNote);
        newPet.getCommands().add(newPet.getClass().getSimpleName());
        pets.add(newPet);
        writeAllPets(pets);
        return idNote;
    }

    // Запись списка всех животных в файл
    public void writeAllPets(List<Pet> pets) {
        List<String> wrPets = new ArrayList<>();
        for (Pet item : pets) {
            String petLine = String.format("%s;%s;%s;%s;%s", item.getPetId(),
                    item.getCommands().get(item.getCommands().size() - 1), item.getName(), item.getBirthday(),
                    item.getCommands().subList(0, item.getCommands().size() - 1).toString());
            wrPets.add(petLine);
        }
        fileOperation.saveAllPets(wrPets);
    }

    // Обновление информации о животном в списке
    @Override
    public void update(int id, String name, LocalDate birthday, List<String> commands) {
        List<Pet> pets = getAllPets();
        Pet updatePet = pets.stream().filter(i -> i.getPetId() == (id)).findFirst().get();
        updatePet.setName(name);
        updatePet.setBirthday(birthday);
        commands.add(updatePet.getCommands().get(updatePet.getCommands().size() - 1));
        updatePet.setCommands(commands);
        writeAllPets(pets);
    }

    // Удаление животного из списка
    @Override
    public void delete (int idPet) {
        List<Pet> pets = getAllPets();
        List<String> petLines = new ArrayList<>();
        for (Pet item : pets) {
            if (item.getPetId() != idPet) {
                String petLine = String.format("%s;%s;%s;%s;%s", item.getPetId(),
                        item.getCommands().get(item.getCommands().size() - 1), item.getName(), item.getBirthday(),
                        item.getCommands().subList(0, item.getCommands().size() - 1).toString());
                petLines.add(petLine);
            }
            fileOperation.saveAllPets(petLines);
        }
    }

    @Override
    public boolean trainCommand(int id, String command) {
        List<Pet> pets = getAllPets();
        Pet trainPet = pets.stream().filter(i -> i.getPetId() == (id)).findFirst().get();
        List<String> commands = trainPet.getCommands();
        String temp = commands.get(commands.size() - 1);
        for (int i = 0; i < commands.size() - 1; i++) {
            if (commands.get(i).trim().equals(command.trim())) {
                return false;
            }
        }
        trainPet.getCommands().set(trainPet.getCommands().size() - 1, command);
        trainPet.getCommands().add(temp);
        writeAllPets(pets);
        return true;
    }

}
