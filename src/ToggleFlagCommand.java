
public class ToggleFlagCommand implements Command {
	
	private SoundClip soundClip;
	private MusicOrganizerWindow view;
	
	public ToggleFlagCommand(SoundClip soundClip, MusicOrganizerWindow view) {
		this.soundClip = soundClip;
		this.view = view;
		execute();
	}

	@Override
	public void execute() {
		soundClip.flagToggle();
		view.onClipsUpdated();
	}

	@Override
	public void undo() {
		soundClip.flagToggle();
		view.onClipsUpdated();
	}
}
