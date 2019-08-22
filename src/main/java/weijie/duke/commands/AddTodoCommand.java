package weijie.duke.commands;

import weijie.duke.exceptions.DukeException;
import weijie.duke.models.Task;
import weijie.duke.models.Todo;
import weijie.duke.repos.IRepository;
import weijie.duke.responses.TaskResponse;

import java.util.Arrays;
import java.util.Collections;

public class AddTodoCommand extends AddCommand {

    public AddTodoCommand(IRepository<Task> repo) {
        super(repo);
    }

    @Override
    public TaskResponse execute(String... args) {
        String description = String.join(" ", Arrays.copyOfRange(args, 1, args.length));

        if (description.isEmpty()) {
            return new TaskResponse(new DukeException("☹ OOPS!!! The description of a todo cannot be empty."));
        }

        Task task = new Todo(description);
        repo.create(task);

        return new TaskResponse(getResponseFormat(), Collections.singletonList(task));
    }
}
