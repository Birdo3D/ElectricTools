package main.fr.birdo.electrictools.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserVars {

    private static final List<String> recents = new ArrayList<>(); //name, path

    public static List<String> getRecentsPath() {
        return recents;
    }

    public static void addRecentProject(String path) {
        recents.add(path);
    }

    public static void removeRecentProject(int index) {
        recents.remove(index);
    }
}
