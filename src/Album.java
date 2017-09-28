
import java.util.HashSet;
import java.util.Set;

public class Album {

	private String name;
	private Album parentAlbum = null;
	private Set<SoundClip> soundClips = new HashSet<>();
	private Set<Album> subAlbums = new HashSet<>();

	public Album(String name) {
		assert name != null;
		assert !name.isEmpty();
		this.name = name;
		assert this.name == name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		assert name != null;
		assert !name.isEmpty();
		this.name = name;
		assert this.name == name;
	}

	public Album getParent() {
		return parentAlbum;
	}

	public void setParent(Album parentAlbum) {
		// Ingen "assert parentAlbum != null" eftersom 
		// root-albumet inte har en "parent".
		this.parentAlbum = parentAlbum;
		assert this.parentAlbum == parentAlbum;
	}

	public Set<Album> getSubAlbums() {
		return subAlbums;
	}

	// Lägger till ett sub-album i detta album.
	public void addSubAlbum(Album toAdd) {
		assert toAdd != null;
		subAlbums.add(toAdd);
		assert subAlbums.contains(toAdd);
	}

	// Tar bort ett sub-album ur detta album.
	public void removeSubAlbum(Album toRemove) {
		assert toRemove != null;
		subAlbums.remove(toRemove);
		assert !subAlbums.contains(toRemove);
	}

	public Set<SoundClip> getSoundClips() {
		return soundClips;
	}

	// Lägger till ett ljudklipp i detta album.
	public void addSoundClip(SoundClip toAdd) {
		assert toAdd != null;
		soundClips.add(toAdd);
		assert soundClips.contains(toAdd);
	}

	// Tar bort ett ljudklipp ur detta album.
	public void removeSoundClip(SoundClip toRemove) {
		assert toRemove != null;
		soundClips.remove(toRemove);
		assert !soundClips.contains(toRemove);
	}
}
