import Controller.PetController;
import Model.Pet;
import Services.FileOperation;
import Services.FileOperationImpl;
import Services.PetRepository;
import Services.PetRepositoryImpl;
import UserInterface.ConsoleMenu;
import Model.Constants;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl(Constants.FILENAME);
        PetRepository petRepository = new PetRepositoryImpl(fileOperation);
        PetController petController = new PetController(petRepository);
        new ConsoleMenu (petController).start();
    }
}