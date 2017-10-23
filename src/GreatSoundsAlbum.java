
public class GreatSoundsAlbum extends SearchBasedAlbum {

	public GreatSoundsAlbum(String name) {
		super(name);
	}

	@Override
	public void soundClipUpdated(SoundClip soundClip) {
		if (soundClip.getRating() >= 4) {
			addSoundClip(soundClip);
		} else {
			removeSoundClip(soundClip);
		}
	}
}
