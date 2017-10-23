import java.io.File;

/**
 * SoundClip is a class representing a digital
 * sound clip file on disk.
 */
public class SoundClip {

	private final File file;
	private boolean flagged = false;
	private int rating = -1;
	
	/**
	 * Make a SoundClip from a file.
	 * Requires file != null.
	 */
	public SoundClip(File file) {
		assert file != null;
		this.file = file;
	}

	/**
	 * @return the file containing this sound clip.
	 */
	public File getFile() {
		return file;
	}
	
	public String toString(){
		String flag = flagged ? " F" : "";
		String rating = this.rating != -1 ? " " + this.rating + "/5" : "";
		return file.getName() + flag + rating;
	}
	
	@Override
	public boolean equals(Object obj) {
		return 
			obj instanceof SoundClip
			&& ((SoundClip)obj).file.equals(file);
	}
	
	@Override
	public int hashCode() {
		return file.hashCode();
	}
	
	public void flagToggle() {
		flagged = !flagged;
	}
	
	public void setRating(int newRating) {
		if (newRating < -1 || newRating > 5) return;
		rating = newRating;
	}
	
	public boolean isFlagged() {
		return flagged;
	}
	
	public int getRating() {
		return rating;
	}
}
