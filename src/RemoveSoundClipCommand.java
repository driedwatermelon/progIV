
public class RemoveSoundClipCommand implements Command {
	
	private Album album;
	private SoundClip soundClip;
	private MusicOrganizerWindow view;
	
	public RemoveSoundClipCommand(Album album, SoundClip soundClip, MusicOrganizerWindow view) {
		this.album = album;
		this.soundClip = soundClip;
		this.view = view;
		execute();
	}
	
	public void execute() {
		album.removeSoundClip(soundClip);
		view.onClipsUpdated();
	}
	
	public void undo() {
		album.addSoundClip(soundClip);
		view.onClipsUpdated();
	}
}
