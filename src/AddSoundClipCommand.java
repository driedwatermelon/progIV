
public class AddSoundClipCommand implements Command {
	
	private Album album;
	private SoundClip soundClip;
	
	public AddSoundClipCommand(Album album, SoundClip soundClip) {
		this.album = album;
		this.soundClip = soundClip;
		//execute();
	}

	public void execute() {
		album.addSoundClip(soundClip);
	}
	
	public void undo() {
		album.removeSoundClip(soundClip);
	}
}
