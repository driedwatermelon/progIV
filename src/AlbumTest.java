import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class AlbumTest {
	
	// Testar att Album klassens konstruktor faktiskt ger den ett namn.
	@Test
	public void testConstructor() {
		Album testAlbum = new Album("Album 1");
		assertEquals("Album 1", testAlbum.getName());
	}
	
	// Testar att man kan �ndra namnet p� ett Album med setName-metoden.
	@Test
	public void testSetName() {
		Album testAlbum = new Album("Album 1");
		testAlbum.setName("Album 2");
		assertEquals("Album 2", testAlbum.getName());
	}
	
	// Testar att man kan l�gga till ett parent-album f�r ett album.
	@Test
	public void testSetParent() {
		Album testAlbum1 = new Album("Album 1");
		Album testAlbum2 = new Album("Album 2");
		
		assert testAlbum2.getParent() == null; // kollar f�rst att testAlbum2 inte har en parent
		testAlbum2.setParent(testAlbum1); // l�gger till en parent
		assert testAlbum2.getParent() == testAlbum1; // kolla att det fungerade
	}
	
	// Testar att man kan l�gga till och ta bort subalbum.
	@Test
	public void testAddRemoveSubalbum() {
		Album testAlbum1 = new Album("Album 1");
		Album testAlbum2 = new Album("Album 2");
		
		assert !testAlbum1.getSubAlbums().contains(testAlbum2); // kollar att det inte finns n�gra subalbum i det nya albumet
		testAlbum1.addSubAlbum(testAlbum2); // l�gger till ett subalbum
		assert testAlbum1.getSubAlbums().contains(testAlbum2); // kollar att det fungerade
		testAlbum1.removeSubAlbum(testAlbum2); // tar bort samma subalbum som vi lade till tidigare
		assert !testAlbum1.getSubAlbums().contains(testAlbum2); // kollar att det faktiskt �r borttaget
	}
	
	// Testar att man kan l�gga till och ta bort SoundClip.
	@Test
	public void testAddRemoveSoundClip() {
		Album testAlbum = new Album("Album 1");
		SoundClip testClip = new SoundClip(new File("blabla.waw")); // Filen beh�ver inte existera f�r
																	// detta test d� vi inte �ppnar den.
		
		assert !testAlbum.getSoundClips().contains(testClip); // kollar att det inte finns n�gra ljuklipp i det nya albumet
		testAlbum.addSoundClip(testClip); // l�gger till ett ljudklipp
		assert testAlbum.getSoundClips().contains(testClip); // kollar att det fungerade
		testAlbum.removeSoundClip(testClip); // tar bort samma ljudklipp som vi lade till tidigare
		assert !testAlbum.getSoundClips().contains(testClip); // kollar att det faktiskt �r borttaget
	}
}