package main.fr.birdo.electrictools.utils;

import main.fr.birdo.electrictools.ElectricTools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class ResourceLoader {

    public static BufferedImage getImage(String resourceName) {
        try {
            return ImageIO.read(Objects.requireNonNull(ElectricTools.class.getResourceAsStream("/main/resources/textures/" + resourceName)));
        } catch (IOException e) {
            throw new IllegalArgumentException("Error - Resource Finder : Image");
        }
    }

    public static BufferedReader getTranslationFile(Translation.Languages language) {
        return new BufferedReader(new InputStreamReader(Objects.requireNonNull(ElectricTools.class.getResourceAsStream("/main/resources/langs/" + language.getFile() + ".etlang"))));
    }
}