
import java.util.Stack;

public class CommandManager {
	
	private Stack<Command> undoable = new Stack<Command>();
	private Stack<Command> redoable = new Stack<Command>();
	
	public CommandManager() {
		
	}
	
	public void addCommand(Command command) {
		undoable.push(command);
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
			Command lastCommand = undoable.pop();
			lastCommand.undo();
			redoable.push(lastCommand);
		}
	}
	
	public void redoLast() {
		if (redoPossible()) {
			Command lastCommand = redoable.pop();
			lastCommand.execute();
			undoable.push(lastCommand);
		}
	}
}
