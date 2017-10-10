
public class RemoveAlbumCommand implements Command {
	
	private Album parent;
	private Album toRemove;
	
	public RemoveAlbumCommand(Album parent, Album toRemove) {
		this.parent = parent;
		this.toRemove = toRemove;
		//execute();
	}
	
	public void execute() {
		parent.removeSubAlbum(toRemove);
	}
	
	public void undo() {
		parent.addSubAlbum(toRemove);
	}
}
