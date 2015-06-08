package realize;

import interfaces.TaskExecutionFailedException;
import utils.CopyFile;
import utils.FindFile;

/**
 * Created by 1 on 08.06.2015.
 */
public class MyTest {
    public static void main(String[] args) {

        MyTaskStorage taskStorage = new MyTaskStorage();
        taskStorage.add(new MyCopyFileTask(new CopyFile(), "D:\\Programs\\JAVA\\JSON.ppt",
                "D:\\JSON.ppt"));
        taskStorage.add(new MyCopyFileTask(new CopyFile(), "D:\\JAVA_Lit_ra\\ekkel_b_filosofiya_java.djvu",
                "C:\\Users\\1\\Documents\\ekkel_b_filosofiya_java.djvu"));

        taskStorage.add(new MyFindFileTask("D:\\","sdsd",System.out));
        taskStorage.add(new MyFindFileTask("C:\\Program Files (x86)","java",System.out));
        taskStorage.add(new MyFindFileTask("C:\\Users\\1\\Desktop",".git",System.out));


        MyTaskExecutor exc1 = new MyTaskExecutor(taskStorage);
        MyTaskExecutor exc2 = new MyTaskExecutor(taskStorage);
        MyTaskExecutor exc3 = new MyTaskExecutor(taskStorage);


        exc1.start();
        exc2.start();
        exc3.start();


    }
}
