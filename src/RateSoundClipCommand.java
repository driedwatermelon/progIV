
public class RateSoundClipCommand implements Command {
	
	private SoundClip soundClip;
	private MusicOrganizerWindow view;
	private int previousRating;
	private int newRating;
	private GreatSoundsAlbum greatSounds;
	
	public RateSoundClipCommand(SoundClip soundClip, MusicOrganizerWindow view, int newRating, GreatSoundsAlbum greatSounds) {
		this.soundClip = soundClip;
		this.view = view;
		previousRating = soundClip.getRating();
		this.newRating = newRating;
		this.greatSounds = greatSounds;
		execute();
	}

	@Override
	public void execute() {
		soundClip.setRating(newRating);
		greatSounds.soundClipUpdated(soundClip);
		view.onClipsUpdated();
	}

	@Override
	public void undo() {
		soundClip.setRating(previousRating);
		greatSounds.soundClipUpdated(soundClip);
		view.onClipsUpdated();
	}
}
