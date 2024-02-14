package lite;
import java.io.IOException;
import java.util.Scanner;

import lite.task.TaskList;
import lite.util.LiteException;
import lite.util.Printer;


public class Chatbot {
    private TaskList tasks;


    public Chatbot() {
        this.tasks = new TaskList();
    }

    /**
     * Starts the chatbot
     */
    public void start() {
        try {
            this.tasks = new TaskList(Storage.load());
        } catch (IOException e) {
            LiteException.loadFileException();
        }
    }

    public String getResponse(String input) {
        Ui ui = new Ui(input);
        return ui.executeCommand(tasks);
    }


}
