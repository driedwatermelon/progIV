import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.JFileChooser;

public class MusicOrganizerController {

	private MusicOrganizerWindow view;
	private SoundClipBlockingQueue queue;
	private Album root;
	private CommandManager commandManager;

	public MusicOrganizerController() {

		root = new Album("All Sound Clips");

		// Create the View in Model-View-Controller
		view = new MusicOrganizerWindow(this);

		// Create the blocking queue
		queue = new SoundClipBlockingQueue();
		
		commandManager = new CommandManager();

		// Create a separate thread for the sound clip player and start it
		(new Thread(new SoundClipPlayer(queue))).start();
		
		updateUndoRedoEnabled();
	}

	/**
	 * Load the sound clips found in all subfolders of a path on disk. If path is
	 * not an actual folder on disk, has no effect.
	 */
	public Set<SoundClip> loadSoundClips(String path) {
		Set<SoundClip> clips = SoundClipLoader.loadSoundClips(path);

		return clips;
	}

	/**
	 * Returns the root album
	 */
	public Album getRootAlbum() {
		return root;
	}

	/**
	 * Adds an album to the Music Organizer
	 */
	public void addNewAlbum() { 

		// Set Album title, create a new Album and designate root folder.
		String name = view.promptForAlbumName();
		if (name == null||name.trim().isEmpty()) return;
		Album newAlbum = new Album(name);
		Album selectedAlbum = view.getSelectedAlbum();
		if (selectedAlbum == null) selectedAlbum = root;
		
		if (!root.containsAlbum(newAlbum)) {
			commandManager.addCommand(new AddAlbumCommand(selectedAlbum, newAlbum, view));
			commandManager.clearRedos();
		}
		updateUndoRedoEnabled();
	}

	/**
	 * Removes an album from the Music Organizer
	 */
	public void deleteAlbum() { 
		// Delete the currently selected album and it's subalbums.
		Album toDelete = view.getSelectedAlbum();
		if (toDelete == null || toDelete == root) return;		
		//toDelete.getParent().removeSubAlbum(toDelete);
		commandManager.addCommand(new RemoveAlbumCommand(toDelete.getParent(), toDelete, view));
		commandManager.clearRedos();
		updateUndoRedoEnabled();
	}

	/**
	 * Adds sound clips to an album
	 */
	public void addSoundClips() { 
		
		// Set parent album
		Album selectedAlbum = view.getSelectedAlbum();
		if (selectedAlbum == null) selectedAlbum = root;
		
		// Initiate a filechooser instance.
		JFileChooser chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(true);

		// Show the dialog; wait until dialog is closed.
		chooser.showOpenDialog(view);

		// Retrieve the selected files.
		File[] soundClips = chooser.getSelectedFiles();

		// Add the selected files to the root album.
		List<Command> commandList = new LinkedList<>();
		for (int i = 0; i < soundClips.length; i++) {
			SoundClip toAdd = new SoundClip(soundClips[i]);
			//selectedAlbum.addSoundClip(toAdd);
			commandList.add(new AddSoundClipCommand(selectedAlbum, toAdd, view));
		}
		commandManager.addCommandList(commandList);
		commandManager.clearRedos();
		updateUndoRedoEnabled();
	}
	

	/**
	 * Removes sound clips from an album
	 */
	public void removeSoundClips() { 

		// Get the list of selected sound clips.
		List<SoundClip> l = view.getSelectedSoundClips();
		Album selectedAlbum = view.getSelectedAlbum();
		if (selectedAlbum == null) return;

		// Loop through the list and remove them from the Album one by one.
		List<Command> commandList = new LinkedList<>();
		for (int i = 0; i < l.size(); i++) {
			//selectedAlbum.removeSoundClip(l.get(i));
			commandList.add(new RemoveSoundClipCommand(selectedAlbum, l.get(i), view));
		}
		commandManager.addCommandList(commandList);
		commandManager.clearRedos();
		updateUndoRedoEnabled();
	}
	
	public void undo() {
		commandManager.undoLast();
		updateUndoRedoEnabled();
	}
	
	public void redo() {
		commandManager.redoLast();
		updateUndoRedoEnabled();
	}
	
	private void updateUndoRedoEnabled() {
		view.setUndoEnabled(commandManager.undoPossible());
		view.setRedoEnabled(commandManager.redoPossible());
	}

	/**
	 * Puts the selected sound clips on the queue and lets the sound clip player
	 * thread play them. Essentially, when this method is called, the selected sound
	 * clips in the SoundClipTable are played.
	 */
	public void playSoundClips() {
		List<SoundClip> l = view.getSelectedSoundClips();
		for (int i = 0; i < l.size(); i++)
			queue.enqueue(l.get(i));
	}
}
