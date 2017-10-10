
public class AddAlbumCommand implements Command {
	
	private Album parent;
	private Album child;
	private MusicOrganizerWindow view;
	
	public AddAlbumCommand(Album parent, Album child, MusicOrganizerWindow view) {
		this.parent = parent;
		this.child = child;
		this.view = view;
		execute();
	}
	
	public void execute() {
		parent.addSubAlbum(child);
		view.onAlbumAdded(child);
	}
	
	public void undo() {
		parent.removeSubAlbum(child);
		view.onAlbumRemoved(child);
	}
}
	