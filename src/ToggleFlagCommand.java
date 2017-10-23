
public class ToggleFlagCommand implements Command {
	
	private SoundClip soundClip;
	private MusicOrganizerWindow view;
	private FlaggedSoundsAlbum flaggedSounds;
	
	public ToggleFlagCommand(SoundClip soundClip, MusicOrganizerWindow view, FlaggedSoundsAlbum flaggedSounds) {
		this.soundClip = soundClip;
		this.view = view;
		this.flaggedSounds = flaggedSounds;
		execute();
	}

	@Override
	public void execute() {
		soundClip.flagToggle();
		flaggedSounds.soundClipUpdated(soundClip);
		view.onClipsUpdated();
	}

	@Override
	public void undo() {
		soundClip.flagToggle();
		flaggedSounds.soundClipUpdated(soundClip);
		view.onClipsUpdated();
	}
}
