package asu.eng.models;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<ICommand> commandList = new ArrayList<>();

    public void takeCommand(ICommand command) {
        commandList.add(command);
    }

    public void executeCommands() {
        for (ICommand command : commandList){
            command.execute();
        }
        commandList.clear();
    }
}
