package main.fr.birdo.electrictools.utils;

import main.fr.birdo.electrictools.ElectricTools;

import java.io.*;

public class Translation {

    public enum Languages {
        FR_fr("Français", "France", "FR_fr"),
        GB_en("English", "Great Britain", "GB_en");

        final String name;
        final String country;
        final String file;

        Languages(String name, String country, String file) {
            this.name = name;
            this.country = country;
            this.file = file;
        }

        public String getName() {
            return this.name;
        }

        public String getCountry() {
            return this.country;
        }

        public String getFile() {
            return this.file;
        }
    }

    public static String getTranslation(String word) {
        try {
            BufferedReader reader = ResourceLoader.getTranslationFile(ElectricTools.language);
            String line = reader.readLine();
            while (line != null) {
                if (line.split("'")[1].equalsIgnoreCase(word))
                    return line.split("'")[2].substring(1);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return word;
    }
}
