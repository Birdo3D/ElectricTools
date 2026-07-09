package main.fr.birdo.electrictools.utils;

import main.fr.birdo.electrictools.items.Breaker;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class FileSaver {

    public static void saveSwitchboard(Breaker[] breakers) {

    }

    public static void writeToFile(String list, String name, String extend) throws IOException, URISyntaxException {
        String userpath = FileSaver.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        File f = new File(userpath.substring(0, userpath.lastIndexOf("/")) + "/" + name + "." + extend);
        FileWriter fw = new FileWriter(f, true);
        try {
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(list);
            bw.flush();
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<String> readFile(String name, String extend) throws URISyntaxException {
        String userpath = FileSaver.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        File f = new File(userpath.substring(0, userpath.lastIndexOf("/")) + "/" + name + "." + extend);
        List<String> output = new ArrayList<>();
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                output.add(br.readLine());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return output;
    }
}
