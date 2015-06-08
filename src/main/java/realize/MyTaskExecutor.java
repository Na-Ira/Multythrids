package realize;

import interfaces.Task;
import interfaces.TaskExecutionFailedException;
import interfaces.TaskExecutor;
import interfaces.TasksStorage;

/**
 * Created by 1 on 08.06.2015.
 */
public class MyTaskExecutor implements Runnable, TaskExecutor {
    private TasksStorage storage;
    private boolean stopFlag;

    public MyTaskExecutor(MyTaskStorage storage) {
        this.storage = storage;
    }

    public void run() {
        while (!stopFlag) {
            Task task = this.storage.get();
            if (task == null) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    task.execute();
                } catch (TaskExecutionFailedException e) {
                    int i = task.getTryCount();
                    if (i < 5) {
                        this.storage.add(task);
                    } else {
                        System.out.println("Task ne vozmogno vypolnit" + task);
                    }
                }
            }
        }
    }

    public void setStorage(TasksStorage storage) throws NullPointerException {
        this.storage = storage;
    }

    public TasksStorage getStorage() {
        return this.storage;
    }

    public void start() throws NullPointerException, IllegalStateException {
        Thread thread = new Thread(this);
        thread.start();
    }

    public void stop() throws IllegalStateException {
        this.stopFlag = true;
    }
}
