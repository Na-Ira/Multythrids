package realize;

import com.sun.javafx.tk.Toolkit;
import interfaces.Task;
import interfaces.TaskExecutionFailedException;

/**
 * Created by 1 on 08.06.2015.
 */
public abstract class MyTask implements Task {
    private int tryCount = 0;

    public int getTryCount() {
        return this.tryCount;
    }

    public void incTryCount() {
        this.tryCount++;

    }


}
