package asu.eng.models;

import java.util.ArrayList;
import java.util.List;
import asu.eng.views.Printer;

public class Scheduler {
    private Printer printer = new Printer(); // Initialize Printer object
    private List<ICommand> commandList = new ArrayList<>();
    public void takeCommand(ICommand command) {
        if (command != null) { // Check if command exists
            printer.printMessage("Executing Command: " + command.toString()); // Print the command
        } else {
            printer.printMessage("Null Command: Cannot execute.");
        }

        commandList.add(command);
    }
    public void executeCommands() {
        for (ICommand command : commandList){
            command.execute();
        }
        commandList.clear();
    }
}
