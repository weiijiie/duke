package weijie.duke.commands;


import weijie.duke.responses.TaskResponse;

import java.util.Optional;

public class UndoCommand implements ITaskCommand {

    private CommandHistory history;

    UndoCommand(CommandHistory history) {
        this.history = history;
    }

    @Override
    public TaskResponse execute(String... args) {
        return history.undo();
    }

    @Override
    public Optional<CommandState> getCommandState() {
        return Optional.empty();
    }
}
