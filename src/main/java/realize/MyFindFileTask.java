package realize;

import interfaces.FindFilesTask;
import interfaces.TaskExecutionFailedException;
import utils.FindFile;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Created by 1 on 08.06.2015.
 */
public class MyFindFileTask extends MyTask implements FindFilesTask {
    private String directory;
    private String searchString;
    private PrintStream out;

    public MyFindFileTask(String directory, String searchString, PrintStream out) {
        super();
        this.directory = directory;
        this.searchString = searchString;
        this.out = out;

    }

    public void setDirectory(String directory) throws NullPointerException, FileNotFoundException {
        this.directory = directory;
    }

    public void setFileNameSearchString(String searchString) throws IllegalArgumentException {
        this.searchString = searchString;
    }

    public void setPrintStream(PrintStream out) {
        this.out = out;
    }

    public void execute() throws TaskExecutionFailedException {
        try {
            FindFile f = new FindFile();
            f.find(directory, searchString, out);
        } catch (Exception e) {
            throw new TaskExecutionFailedException(e.getMessage());
        }
    }
}
