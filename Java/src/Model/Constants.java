package Model;

import java.io.File;

public class Constants {
    // Имя файла со всеми домашними животными
    public static final String FILENAME = String.join("\\", String.join("\\",
                    new File("").getAbsolutePath(), "\\src\\Files\\Pets.csv"));
}
