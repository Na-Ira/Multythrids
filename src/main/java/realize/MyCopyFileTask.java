package realize;

import interfaces.CopyFileTask;
import interfaces.TaskExecutionFailedException;
import utils.CopyFile;

/**
 * Created by 1 on 08.06.2015.
 */
public class MyCopyFileTask extends MyTask implements CopyFileTask {

    private CopyFile copyUtils;
    private String from;
    private String to;

    public MyCopyFileTask(CopyFile copyUtils, String from, String to) {
        super();
        this.copyUtils = copyUtils;
        this.from = from;
        this.to = to;

    }

    public void execute() throws TaskExecutionFailedException {
        try {
            copyUtils.copy(from, to);
        } catch (Exception exception) {
            throw new TaskExecutionFailedException(exception.getMessage());
        }
    }

    public void setFileCopyUtils(CopyFile copyUtils) {
        this.copyUtils = copyUtils;

    }


}
