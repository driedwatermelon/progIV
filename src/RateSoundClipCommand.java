
public class RateSoundClipCommand implements Command {
	
	private SoundClip soundClip;
	private MusicOrganizerWindow view;
	private int previousRating;
	private int newRating;
	
	public RateSoundClipCommand(SoundClip soundClip, MusicOrganizerWindow view, int newRating) {
		this.soundClip = soundClip;
		this.view = view;
		previousRating = soundClip.getRating();
		this.newRating = newRating;
		execute();
	}

	@Override
	public void execute() {
		soundClip.setRating(newRating);
		view.onClipsUpdated();
	}

	@Override
	public void undo() {
		soundClip.setRating(previousRating);
		view.onClipsUpdated();
	}
}
