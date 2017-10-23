
public abstract class SearchBasedAlbum extends Album {

	public SearchBasedAlbum(String name) {
		super(name);
	}
	
	@Override
	public boolean addSubAlbum(Album toIgnore) {
		return false;
	}
	
	@Override
	public boolean removeSubAlbum(Album toIgnore) {
		return false;
	}
	
	public abstract void soundClipUpdated(SoundClip soundClip);
}
