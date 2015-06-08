package utils;

import java.io.File;
import java.io.PrintStream;

/**
 * Created by 1 on 03.06.2015.
 */
public class FindFile {
  //  private boolean flag;

    public String[] find(String pathToDir, String searchWord, PrintStream out) {
        File dir = new File(pathToDir);
        File[] files = dir.listFiles();
        for (File f : files) {
            out.println(f.getAbsoluteFile());
        }

        String[] result = new String[2];
        return result;

    }
}
