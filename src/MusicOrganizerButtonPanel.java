import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class MusicOrganizerButtonPanel extends JPanel {

	private MusicOrganizerController controller;
	
	private JButton newAlbumButton;
	private JButton deleteAlbumButton;
	private JButton addSoundClipsButton;
	private JButton removeSoundClipsButton;	
	private JButton playButton;
	private JButton undoButton;
	private JButton redoButton;
	private JButton flagButton;
	private JButton rateButton;

	
	public MusicOrganizerButtonPanel(MusicOrganizerController contr){
		super(new BorderLayout());

		controller = contr;
				
		JToolBar toolbar = new JToolBar();
		
		newAlbumButton = createNewAlbumButton();
		toolbar.add(newAlbumButton);

		deleteAlbumButton = createDeleteAlbumButton();
		toolbar.add(deleteAlbumButton);

		addSoundClipsButton = createAddSoundClipsButton();
		toolbar.add(addSoundClipsButton);

		removeSoundClipsButton = createRemoveSoundClipsButton();
		toolbar.add(removeSoundClipsButton);

		playButton = createPlayButton();
		toolbar.add(playButton);
		
		undoButton = createUndoButton();
		toolbar.add(undoButton);
		
		redoButton = createRedoButton();
		toolbar.add(redoButton);
		
		flagButton = createFlagButton();
		toolbar.add(flagButton);
		
		rateButton = createRateButton();
		toolbar.add(rateButton);
		
		this.add(toolbar);
	}
	
	/**
	 * Note: You can replace the text strings in the instantiations of the JButtons
	 * below with ImageIcons if you prefer to have buttons with icons instead of
	 * buttons with text strings
	 * 
	 *  Example:
	 *  ImageIcon newAlbumIcon = new ImageIcon("icons/folder_add_32.png");
	 *  JButton newAlbumButton = new JButton(newAlbumIcon);
	 *  
	 *  will put the imageIcon on the button, instead of the text "New Album", as 
	 *  done below
	 * 
	 */
	
	private JButton createNewAlbumButton() {
		//ImageIcon newAlbumIcon = new ImageIcon("icons/folder_add_32.png");
		JButton newAlbumButton = new JButton("New Album");
		newAlbumButton.setToolTipText("New Album");
		newAlbumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.addNewAlbum();
			}
		});
		return newAlbumButton;
	}
	
	private JButton createDeleteAlbumButton() {
		//ImageIcon deleteAlbumIcon = new ImageIcon("icons/folder_delete_32.png");
		JButton deleteAlbumButton = new JButton("Remove Album");
		deleteAlbumButton.setToolTipText("Delete Selected Album");
		deleteAlbumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.deleteAlbum();
			}
		});
		return deleteAlbumButton;
	}

	private JButton createAddSoundClipsButton() {
		//ImageIcon addSoundClipsIcon = new ImageIcon("icons/document_add_32.png");
		JButton addSoundClipButton = new JButton("Add Sound Clips");
		addSoundClipButton.setToolTipText("Add Selected Sound Clips To Selected Album");
		addSoundClipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				controller.addSoundClips();

			}
		});
		return addSoundClipButton;
	}
	
	private JButton createRemoveSoundClipsButton() {
		//ImageIcon removeSoundClipsIcon = new ImageIcon("icons/document_delete_32.png");
		JButton removeSoundClipsButton = new JButton("Remove Sound Clips");
		removeSoundClipsButton.setToolTipText("Remove Selected Sound Clips From Selected Album");
		removeSoundClipsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.removeSoundClips();
			}
		});
		return removeSoundClipsButton;
	}
	
	private JButton createPlayButton() {
		//ImageIcon playIcon = new ImageIcon("icons/play_32.png");
		JButton playButton = new JButton("Play");
		playButton.setToolTipText("Play Selected Sound Clip");
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.playSoundClips();
			}
		});
		return playButton;
	}
	
	private JButton createUndoButton() {
		JButton undoButton = new JButton("Undo");
		undoButton.setToolTipText("Undo last action.");
		undoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.undo();
			}
		});
		return undoButton;
	}
	
	private JButton createRedoButton() {
		JButton redoButton = new JButton("Redo");
		redoButton.setToolTipText("Redo last undone action.");
		redoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.redo();
			}
		});
		return redoButton;
	}
	
	private JButton createFlagButton() {
		JButton redoButton = new JButton("Flag");
		redoButton.setToolTipText("Flag the currently selected soundclips.");
		redoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.flag();
			}
		});
		return redoButton;
	}
	
	private JButton createRateButton() {
		JButton redoButton = new JButton("Rate");
		redoButton.setToolTipText("Rate the currently selected soundclips.");
		redoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.rate();
			}
		});
		return redoButton;
	}
	
	public void setUndoEnable(boolean state) {
		undoButton.setEnabled(state);
	}
	
	public void setRedoEnabled(boolean state) {
		redoButton.setEnabled(state);
	}
}
