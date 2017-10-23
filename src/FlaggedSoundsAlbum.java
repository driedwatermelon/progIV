
public class FlaggedSoundsAlbum extends SearchBasedAlbum {

	public FlaggedSoundsAlbum(String name) {
		super(name);
	}

	@Override
	public void soundClipUpdated(SoundClip soundClip) {
		if (soundClip.isFlagged()) {
			addSoundClip(soundClip);
		} else {
			removeSoundClip(soundClip);
		}
	}
}
