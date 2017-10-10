
import java.util.Stack;
import java.util.List;
import java.util.LinkedList;

public class CommandManager {
	
	private Stack<List<Command>> undoable = new Stack<>();
	private Stack<List<Command>> redoable = new Stack<>();
	
	public CommandManager() {
		
	}
	
	public void addCommand(Command command) {
		List<Command> commandList = new LinkedList<>();
		commandList.add(command);
		undoable.add(commandList);
	}
	
	public void addCommandList(List<Command> commands) {
		undoable.add(commands);
	}
	
	public boolean undoPossible() {
		return !undoable.isEmpty();
	}
	
	public boolean redoPossible() {
		return !redoable.isEmpty();
	}
	
	public void clearRedos() {
		redoable.clear();
	}
	
	public void undoLast() {
		if (undoPossible()) {
			List<Command> commandList = new LinkedList<>();
			for (Command command : undoable.pop()) {
				command.undo();
				commandList.add(command);
			}
			redoable.push(commandList);
		}
	}
	
	public void redoLast() {
		if (redoPossible()) {
			List<Command> commandList = new LinkedList<>();
			for (Command command : redoable.pop()) {
				command.execute();
				commandList.add(command);
			}
			undoable.push(commandList);
		}
	}
}
