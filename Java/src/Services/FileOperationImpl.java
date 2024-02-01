package Services;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Model.*;

public class FileOperationImpl implements FileOperation {
    private String fileName;

    public FileOperationImpl(String fileName) {
        this.fileName = fileName;
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Получение из файла списка всех животных
    @Override
    public List<Pet> readAllPets() {
        List<String> petLines = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            if (line != null && line.equals("") == false) {
                petLines.add(line);
            }
            while (line != null) {
                line = bufferedReader.readLine();
                if (line != null && line.equals("") == false) {
                    petLines.add(line);
                }
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл с домашними животными " + fileName + " отсутствует!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Pet> allPets = new ArrayList<Pet>();
        for (String item : petLines) {
            String[] petData = item.trim().split(";");
            String[] commands = petData[4].trim().substring(1, petData[4].length() - 1).split(",");
            List<String> listCommands = new ArrayList<>();
            for (String itemCom : commands) {
                listCommands.add(itemCom.trim());
            }
            listCommands.add(petData[1]);
            int id = 0;
            try {
                 id = Integer.parseInt(petData[0]);
            } catch (RuntimeException e) {
                System.out.println("В файле со списком животных ошибка в формате id!");
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate dateBirthday = null;
            try {
                dateBirthday = LocalDate.parse(petData[3], formatter);
            } catch (RuntimeException e) {
                System.out.println("В файле со списком животных ошибка в формате даты рождения!");
            }
            allPets.add(new Pet(id, petData[2], dateBirthday, listCommands));
        }
        return allPets;
    }

    // Запись в файл списка всех животных
    @Override
    public void saveAllPets(List<String> pets) {
        try {
            createDataFile(fileName);
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        try (FileWriter fileWriter = new FileWriter(fileName, false)) {
            for (String line : pets) {
                fileWriter.write(line);
                fileWriter.append('\n');
            }
            fileWriter.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Создание файла со списком всех животных, если он отсутствует
    public void createDataFile(String fileName) throws IOException {
        File file = new File(fileName);
        boolean created = file.createNewFile();
    }

}
