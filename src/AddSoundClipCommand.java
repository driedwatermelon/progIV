
public class AddSoundClipCommand implements Command {
	
	private Album album;
	private SoundClip soundClip;
	private MusicOrganizerWindow view;
	
	public AddSoundClipCommand(Album album, SoundClip soundClip, MusicOrganizerWindow view) {
		this.album = album;
		this.soundClip = soundClip;
		this.view = view;
		execute();
	}

	public void execute() {
		album.addSoundClip(soundClip);
		view.onClipsUpdated();
	}
	
	public void undo() {
		album.removeSoundClip(soundClip);
		view.onClipsUpdated();
	}
}
