package utils;

import java.io.*;

/**
 * Created by 1 on 03.06.2015.
 */
public class CopyFile {
    public void copy(String pathFrom, String pathTo) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(pathFrom));
            bos = new BufferedOutputStream(new FileOutputStream(pathTo));

            int c = 0;
            while (true) {
                c = bis.read();
                if (c != -1)
                    bos.write(c);
                else
                    break;

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bis.close();
                bos.flush(); // освобождает буфер, принудительно записывая содержащее буфера в файл
                bos.close(); // закрывает поток записи (обязательно!!)
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
