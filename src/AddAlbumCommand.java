
public class AddAlbumCommand implements Command {
	
	private Album parent;
	private Album child;
	private MusicOrganizerWindow view;
	
	public AddAlbumCommand(Album parent, Album child) {
		this.parent = parent;
		this.child = child;
		execute();
	}
	
	public void execute() {
		parent.addSubAlbum(child);
	}
	
	public void undo() {
		parent.removeSubAlbum(child);
	}
}
	