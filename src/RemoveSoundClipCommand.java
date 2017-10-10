
public class RemoveSoundClipCommand implements Command {
	
	private Album album;
	private SoundClip soundClip;
	
	public RemoveSoundClipCommand(Album album, SoundClip soundClip) {
		this.album = album;
		this.soundClip = soundClip;
		//execute();
	}
	
	public void execute() {
		album.removeSoundClip(soundClip);
	}
	
	public void undo() {
		album.addSoundClip(soundClip);
	}
}
