
public class RemoveAlbumCommand implements Command {
	
	private Album parent;
	private Album toRemove;
	private MusicOrganizerWindow view;
	
	public RemoveAlbumCommand(Album parent, Album toRemove, MusicOrganizerWindow view) {
		this.parent = parent;
		this.toRemove = toRemove;
		this.view = view;
		execute();
	}
	
	public void execute() {
		parent.removeSubAlbum(toRemove);
		view.onAlbumRemoved(toRemove);
	}
	
	public void undo() {
		parent.addSubAlbum(toRemove);
		view.onAlbumAdded(toRemove);
	}
}
